package ru.homecredit.web.model;

import lombok.Data;

import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class Order {
    private DeliveryAddress deliveryAddress;
    private List<Item> items;
    private String  orderDateComplete;
    private String  orderNum;
    private double orderSum;
    private String productCode;
}
