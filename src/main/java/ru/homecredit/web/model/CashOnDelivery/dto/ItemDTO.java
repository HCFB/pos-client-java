package ru.homecredit.web.model.CashOnDelivery.dto;

import lombok.Data;
import ru.homecredit.web.model.CashOnDelivery.Price;


@Data
public class ItemDTO {
    private String name;
    private Integer quantity;
    private String seller;
    private Price itemPrice;
    private String category;
    private String weight;
}
