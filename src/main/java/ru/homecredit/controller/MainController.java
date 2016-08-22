package ru.homecredit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RRybasov on 05.07.16.
 */
@Controller
@ResponseBody
public class MainController {

    OAuth2RestOperations restTemplate;

    @Autowired
    public MainController(@Qualifier("restTemplate") OAuth2RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/")
    public String mainPage() {
        /*restTemplate.postForObject("https://api-sandbox.homecredit.ru/e-shop/v1/applications", "{\n" +
                "  \"clientInfo\" : {\n" +
                "    \"email\" : \"test@example.com\",\n" +
                "    \"firstName\" : \"Ivan\",\n" +
                "    \"lastName\" : \"Ivanovich\",\n" +
                "    \"middleName\" : \"Ivanov\",\n" +
                "    \"phone\" : \"9260000000\",\n" +
                "    \"sex\" : \"MALE\"\n" +
                "  },\n" +
                "  \"order\" : {\n" +
                "    \"deliveryAddress\" : {\n" +
                "      \"address\" : \"Москва, ул. Правды 8 к.1\",\n" +
                "      \"code\" : \"A123\"\n" +
                "    },\n" +
                "    \"items\" : [ {\n" +
                "      \"model\" : \"ItemModel\",\n" +
                "      \"name\" : \"ItemName\",\n" +
                "      \"partnerGoodCatalog\" : \"TEST\",\n" +
                "      \"price\" : 10,\n" +
                "      \"producer\" : \"Someone\",\n" +
                "      \"quantity\" : 1,\n" +
                "      \"weight\" : 1\n" +
                "    } ],\n" +
                "    \"orderDateComplete\" : \"2016-07-05\",\n" +
                "    \"orderNum\" : \"1467717042582\",\n" +
                "    \"orderSum\" : 10,\n" +
                "    \"productCode\" : \"0-0-12\"\n" +
                "  },\n" +
                "  \"shopUrl\" : \"https://example.com?id=100500\"\n" +
                "}", String.class );*/
        return restTemplate.getAccessToken().getValue();
    }



}
