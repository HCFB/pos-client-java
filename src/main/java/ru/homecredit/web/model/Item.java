package ru.homecredit.web.model;

import lombok.Data;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class Item {
    private String model;
    private String name;
    private String partnerGoodCatalog;
    private Double price;
    private String producer;
    private Integer quantity;
    private Integer weight;
}
