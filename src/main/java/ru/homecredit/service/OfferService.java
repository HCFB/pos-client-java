package ru.homecredit.service;

import ru.homecredit.model.CashOnDelivery.Offer;
import ru.homecredit.web.model.CashOnDelivery.ExLink;
import ru.homecredit.web.model.CashOnDelivery.dto.OfferCreateDTO;

/**
 * Created by RRybasov on 17.11.16.
 */
public interface OfferService {
    ExLink createOffer(OfferCreateDTO offerCreateDTO, String host);

    Offer getOffer(long offerId);
}
