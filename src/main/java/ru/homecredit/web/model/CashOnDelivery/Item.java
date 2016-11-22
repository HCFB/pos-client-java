package ru.homecredit.web.model.CashOnDelivery;

import lombok.*;

@Data
public class Item {

    private String name;
    private Integer quantity;
    private String seller;
    private Price itemPrice;
    private String category;
    private String weight;
}
