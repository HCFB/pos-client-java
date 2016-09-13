package ru.homecredit.web.model;

import lombok.Data;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class OrderDTO {
    private DeliveryAddressDTO deliveryAddress;
    private List<ItemDTO> items;
    @Nullable
    private Date orderDateComplete;
    private String  orderNum;
    private double orderSum;
    private String productCode;
}
