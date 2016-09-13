package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "orders")
public class Order extends AbstractModel {
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id")
    private DeliveryAddress deliveryAddress;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY ,cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private List<Item> items;
    private Date orderDateComplete;
    //private String orderNum;
    private double orderSum;
    private String productCode;
}
