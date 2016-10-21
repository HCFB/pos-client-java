package ru.homecredit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "delivery_addresses")
public class DeliveryAddress extends AbstractModel {
    private String address;
    private String code;
}
