package ru.homecredit.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import ru.homecredit.web.model.*;

import java.util.List;
import java.util.Random;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Service
public class ApplicationsServiceImpl implements ApplicationsService {

    private DozerBeanMapper mapper;
    private OAuth2RestOperations restOperations;
    private String createApplicationUrl;

    @Autowired
    public ApplicationsServiceImpl(DozerBeanMapper mapper,
                                   OAuth2RestOperations restOperations,
                                   @Value("${api.createApplication.uri}") String createApplicationUrl) {
        this.mapper = mapper;
        this.restOperations = restOperations;
        this.createApplicationUrl = createApplicationUrl;
    }

    @Override
    public ResponseEntity<ApplicationResponse> createApplication(CreateApplicationRequest createApplicationRequest, String host) {
        ClientInfo clientInfo = mapper.map(createApplicationRequest, ClientInfo.class);
        Order order = generateOrder(createApplicationRequest);
        ApplicationRequest request = new ApplicationRequest(clientInfo, order, host);
        ResponseEntity<ApplicationResponse> response = restOperations.postForEntity(createApplicationUrl, request, ApplicationResponse.class);
        response.getBody().getApplicationResource().getLinks();
        return response;
    }

    private Order generateOrder(CreateApplicationRequest createApplicationRequest) {
        Order order = new Order();
        DeliveryAddress deliveryAddress = mapper.map(createApplicationRequest, DeliveryAddress.class);
        order.setItems(createApplicationRequest.getItems());
        order.setDeliveryAddress(deliveryAddress);
        order.setProductCode("0-0-12");
        Random rn = new Random();
        order.setOrderNum(String.valueOf(rn.nextInt(999999) + 100000));
        order.setOrderSum(getOrderSum(createApplicationRequest.getItems()));
        return order;
    }


    private double getOrderSum(List<Item> items) {
        double orderSum = 0;
        for(Item item : items) {
            orderSum += item.getPrice();
        }
        return orderSum;
    }
}
