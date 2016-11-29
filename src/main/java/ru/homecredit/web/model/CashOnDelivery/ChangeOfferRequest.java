package ru.homecredit.web.model.CashOnDelivery;

import lombok.Getter;
import lombok.Setter;
import ru.homecredit.web.model.CashOnDelivery.enums.OfferStatus;

/**
 * User: kdanilov
 * Date: 05.10.15
 * Time: 19:00
 */
@Getter
@Setter
public class ChangeOfferRequest {
    private OfferStatus status;
}
