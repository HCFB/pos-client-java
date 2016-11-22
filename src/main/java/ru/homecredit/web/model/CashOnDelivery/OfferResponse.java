package ru.homecredit.web.model.CashOnDelivery;

import lombok.Data;
import ru.homecredit.web.model.CashOnDelivery.enums.CurrencyEnum;
import ru.homecredit.web.model.CashOnDelivery.enums.OfferStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by RRybasov on 15.11.16.
 */
@Data
public class OfferResponse {
    private String id;
    private Date validTo;
    private OfferStatus status;
    private BigDecimal servicePrice;
    private BigDecimal goodsPrice;
    private BigDecimal totalPrice;
    private CurrencyEnum currency;
    private List<ExLink> links;
}
