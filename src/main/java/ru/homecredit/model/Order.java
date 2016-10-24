package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", allocationSize = 1)
    private Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id")
    private DeliveryAddress deliveryAddress;
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "order_id")
    private List<Item> items = new ArrayList<>();
    private Date orderDateComplete;
    //private String orderNum;
    private double orderSum;
    private String productCode;
}
