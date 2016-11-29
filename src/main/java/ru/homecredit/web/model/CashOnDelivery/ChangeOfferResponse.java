package ru.homecredit.web.model.CashOnDelivery;

import lombok.Data;

import java.util.List;

/**
 * Created by amalmygin on 30.10.2015.
 */
@Data
public class ChangeOfferResponse {
    private List<ExLink> links;
}