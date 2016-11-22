package ru.homecredit.web.model.CashOnDelivery;

import lombok.Data;

import java.util.List;

/**
 * Created by RRybasov on 15.11.16.
 */
@Data
public class OfferRequest {

    private String shippingCompanyId;
    private Price totalPrice;
    private List<Item> items;
    private DeliveryAddress deliveryAddress;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String shopOrderId;
    private Price discountAmount;
    private Price shippingCost;

    private String successUrl;
    private String failUrl;
}
