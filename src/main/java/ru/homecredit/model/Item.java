package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "items")
public class Item extends AbstractModel {
    private String model;
    private String name;
    private String partnerGoodCatalog;
    private Double price;
    private String producer;
    private Integer quantity;
    private Integer weight;
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "order_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "order_id"))
    private Order order;
}
