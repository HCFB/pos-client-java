package ru.homecredit.model.CashOnDelivery;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 15.11.16.
 */
@Data
@Entity
@Table(name = "cod_delivery_addresses")
public class CodDeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_delivery_addresses_id_seq")
    @SequenceGenerator(name = "cod_delivery_addresses_id_seq", sequenceName = "cod_delivery_addresses_id_seq", allocationSize = 1)
    private long id;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String region;
    private String postcode;
}
