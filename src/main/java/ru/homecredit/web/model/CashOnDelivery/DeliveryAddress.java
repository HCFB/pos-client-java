package ru.homecredit.web.model.CashOnDelivery;

import lombok.Data;

@Data
public class DeliveryAddress {

    private String address1;
    private String address2;
    private String city;
    private String country;
    private String region;
    private String postcode;
}
