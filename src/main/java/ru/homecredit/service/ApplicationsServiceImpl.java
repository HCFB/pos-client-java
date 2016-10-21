package ru.homecredit.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homecredit.dao.ApplicationDAO;
import ru.homecredit.dao.OrderDAO;
import ru.homecredit.model.Application;
import ru.homecredit.model.DeliveryAddress;
import ru.homecredit.model.Item;
import ru.homecredit.model.Order;
import ru.homecredit.web.model.*;

import java.util.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Service
public class ApplicationsServiceImpl implements ApplicationsService {

    private DozerBeanMapper mapper;
    private OAuth2RestOperations restOperations;
    private String createApplicationUrl;
    private ApplicationDAO applicationDAO;

    @Autowired
    public ApplicationsServiceImpl(DozerBeanMapper mapper,
                                   OAuth2RestOperations restOperations,
                                   ApplicationDAO applicationDAO,
                                   @Value("${api.createApplication.uri}") String createApplicationUrl) {
        this.mapper = mapper;
        this.restOperations = restOperations;
        this.createApplicationUrl = createApplicationUrl;
        this.applicationDAO = applicationDAO;
    }

    @Override
    public ResponseEntity<ApplicationResponse> createApplication(CreateApplicationRequest createApplicationRequest, String host) {
        ClientInfoDTO clientInfo = mapper.map(createApplicationRequest, ClientInfoDTO.class);
        OrderDTO order = generateOrder(createApplicationRequest);
        ApplicationRequest request = new ApplicationRequest(clientInfo, order, String.format("%s?order=%s", host, order.getOrderNum()));
        ResponseEntity<ApplicationResponse> response = restOperations.postForEntity(createApplicationUrl, request, ApplicationResponse.class);
        applicationDAO.save(mapper.map(response.getBody(), Application.class));
        return response;
    }

    private OrderDTO generateOrder(CreateApplicationRequest createApplicationRequest) {
        Order order = new Order();
        DeliveryAddressDTO deliveryAddressDTO = mapper.map(createApplicationRequest, DeliveryAddressDTO.class);
        List<Item> items = new ArrayList<>();
        for(ItemDTO item : createApplicationRequest.getItems()) {
            Item newItem = mapper.map(item, Item.class);
            items.add(newItem);
        }
        order.setItems(items);
        order.setDeliveryAddress(mapper.map(deliveryAddressDTO, DeliveryAddress.class));
        order.setProductCode("0-0-12");
        order.setOrderDateComplete(new Date());
        order.setOrderSum(getOrderSum(createApplicationRequest.getItems()));
        return mapper.map(order, OrderDTO.class);
    }


    private double getOrderSum(List<ItemDTO> items) {
        double orderSum = 0;
        for(ItemDTO item : items) {
            orderSum += item.getPrice();
        }
        return orderSum;
    }
}
