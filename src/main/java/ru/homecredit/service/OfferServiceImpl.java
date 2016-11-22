package ru.homecredit.service;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.homecredit.dao.OfferDAO;
import ru.homecredit.model.CashOnDelivery.CartItem;
import ru.homecredit.model.CashOnDelivery.CodDeliveryAddress;
import ru.homecredit.model.CashOnDelivery.Offer;
import ru.homecredit.model.CashOnDelivery.UserInfo;
import ru.homecredit.web.model.CashOnDelivery.*;
import ru.homecredit.web.model.CashOnDelivery.dto.ItemDTO;
import ru.homecredit.web.model.CashOnDelivery.dto.OfferCreateDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 17.11.16.
 */

@Slf4j
@Service
public class OfferServiceImpl implements OfferService {

    private DozerBeanMapper mapper;
    private OAuth2RestOperations restOperations;
    private OfferDAO offerDao;
    private String offerUrl;

    @Autowired
    public OfferServiceImpl(DozerBeanMapper mapper,
                            @Qualifier("codRest")
                            OAuth2RestOperations restOperations,
                            OfferDAO offerDao,
                            @Value("${api.cod.createOffer.uri}") String offerUrl
                            ) {
        this.mapper = mapper;
        this.restOperations = restOperations;
        this.offerDao = offerDao;
        this.offerUrl = offerUrl;
    }

    @Override
    public ExLink createOffer(OfferCreateDTO offerCreateDTO, String host){
        OfferRequest request = mapper.map(offerCreateDTO, OfferRequest.class);
        Offer offer = generateOffer(offerCreateDTO);
        DeliveryAddress deliveryAddress = mapper.map(offerCreateDTO, DeliveryAddress.class);
        request.setTotalPrice(new Price(getTotalPrice(offerCreateDTO.getItems()), "RUR"));
        request.setDeliveryAddress(deliveryAddress);
        request.setShopOrderId(String.valueOf(offer.getId()));
        request.setSuccessUrl(String.format("http://%s/offer/success/%s", host, offer.getId()));
        request.setFailUrl(String.format("http://%s/offer/fail/%s", host, offer.getId()));
        request.setDiscountAmount(new Price(BigDecimal.ZERO, "RUR"));
        request.setShippingCost(new Price(BigDecimal.ZERO, "RUR"));
        try {
            OfferResponse entity = restOperations.postForObject(offerUrl, request, OfferResponse.class);
            offer.setRemoteId(entity.getId());
            offer.setValidTo(entity.getValidTo());
            offer.setGoodsPrice(entity.getGoodsPrice());
            offer.setStatus(entity.getStatus());
            offer.setTotalPrice(entity.getTotalPrice());
            offer.setCurrency(entity.getCurrency());
            offer.setServicePrice(entity.getServicePrice());
            offerDao.save(offer);
            return entity.getLinks().stream().filter((exLink) -> exLink.getRel().equals("REDIRECT_URL")).findFirst().get();
        } catch (HttpClientErrorException ex) {
            log.error(ex.getResponseBodyAsString());
            throw ex;
        }
    }

    @Override
    public Offer getOffer(long offerId) {
        return offerDao.findOne(offerId);
    }



    private BigDecimal getTotalPrice(List<ItemDTO> items) {
        double result = 0;
        for(ItemDTO item : items) {
            result += item.getQuantity().doubleValue() * item.getItemPrice().getAmount().doubleValue();
        }
        return BigDecimal.valueOf(result);
    }

    private Offer generateOffer(OfferCreateDTO offerCreateDTO) {
        List<CartItem> items = new ArrayList<>();
        offerCreateDTO.getItems().forEach(x -> items.add(mapper.map(x, CartItem.class)));
        CodDeliveryAddress deliveryAddress = mapper.map(offerCreateDTO, CodDeliveryAddress.class);
        UserInfo userInfo = mapper.map(offerCreateDTO, UserInfo.class);
        Offer offer = new Offer();
        offer.setCartItems(items);
        offer.setCodDeliveryAddress(deliveryAddress);
        offer.setUserInfo(userInfo);
        offer.setCreateDate(new Date());
        offerDao.save(offer);
        return offer;
    }

}
