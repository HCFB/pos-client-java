package ru.homecredit.model.CashOnDelivery;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by RRybasov on 16.11.16.
 */
@Data
@Entity
@Table(name = "cod_cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_cart_items_id_seq")
    @SequenceGenerator(name = "cod_cart_items_id_seq", sequenceName = "cod_cart_items_id_seq", allocationSize = 1)
    private long id;
    private String name;
    private Integer quantity;
    private String seller;
    private BigDecimal amount;
    private String currency;
    private String category;
    private String weight;
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "offer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "offer_id"))
    private Offer offer;
}
