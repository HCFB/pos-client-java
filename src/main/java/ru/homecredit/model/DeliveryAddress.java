package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "delivery_addresses")
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_address_id_seq")
    @SequenceGenerator(name = "delivery_address_id_seq", sequenceName = "delivery_address_id_seq", allocationSize = 1)
    Long id;
    private String address;
    private String code;
}
