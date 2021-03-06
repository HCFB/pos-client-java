package ru.homecredit.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import ru.homecredit.dao.ApplicationDAO;
import ru.homecredit.dao.OrderDAO;
import ru.homecredit.model.PosOnline.Application;
import ru.homecredit.model.PosOnline.DeliveryAddress;
import ru.homecredit.model.PosOnline.Item;
import ru.homecredit.model.PosOnline.Order;
import ru.homecredit.web.model.PosOnline.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Service
public class ApplicationsServiceImpl implements ApplicationsService {

    private DozerBeanMapper mapper;
    private OAuth2RestOperations restOperations;
    private String createApplicationUrl;
    private ApplicationDAO applicationDAO;
    private OrderDAO orderDAO;

    @Autowired
    public ApplicationsServiceImpl(DozerBeanMapper mapper,
                                   @Qualifier("posRest")
                                   OAuth2RestOperations restOperations,
                                   ApplicationDAO applicationDAO,
                                   OrderDAO orderDAO,
                                   @Value("${api.createApplication.uri}") String createApplicationUrl) {
        this.mapper = mapper;
        this.restOperations = restOperations;
        this.createApplicationUrl = createApplicationUrl;
        this.applicationDAO = applicationDAO;
        this.orderDAO = orderDAO;
    }

    @Override
    public ResponseEntity<ApplicationResponse> createApplication(CreateApplicationRequest createApplicationRequest, String host) {
        ClientInfoDTO clientInfo = mapper.map(createApplicationRequest, ClientInfoDTO.class);
        Order order = generateOrder(createApplicationRequest);
        OrderDTO orderDto = mapper.map(order, OrderDTO.class);
        ApplicationRequest request = new ApplicationRequest(clientInfo, orderDto, String.format("http://%s/accept?order=%s&status=", host, orderDto.getOrderNum()));
        ResponseEntity<ApplicationResponse> response = restOperations.postForEntity(createApplicationUrl, request, ApplicationResponse.class);
        Application application = mapper.map(response.getBody(), Application.class);
        application.getApplicationResource().setOrder(order);
        applicationDAO.save(application);
        return response;
    }

    private Order generateOrder(CreateApplicationRequest createApplicationRequest) {
        Order order = new Order();
        DeliveryAddressDTO deliveryAddressDTO = mapper.map(createApplicationRequest, DeliveryAddressDTO.class);
        List<Item> items = new ArrayList<>();
        for(ItemDTO item : createApplicationRequest.getItems()) {
            Item newItem = mapper.map(item, Item.class);
            items.add(newItem);
        }
        order.setItems(items);
        order.setDeliveryAddress(mapper.map(deliveryAddressDTO, DeliveryAddress.class));
        order.setProductCode("0-0-24");
        order.setOrderDateComplete(new Date());
        order.setOrderSum(getOrderSum(createApplicationRequest.getItems()));
        orderDAO.save(order);
        return order;
    }


    private double getOrderSum(List<ItemDTO> items) {
        double orderSum = 0;
        for(ItemDTO item : items) {
            orderSum += item.getPrice();
        }
        return orderSum;
    }
}
