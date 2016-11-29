package ru.homecredit.web.model.CashOnDelivery.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by RRybasov on 15.11.16.
 */
@Data
public class OfferCreateDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String region;
    private String postcode;
    private String shippingCompanyId;
    private List<ItemDTO> items;
}
