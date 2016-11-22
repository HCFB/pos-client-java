package ru.homecredit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.homecredit.model.CashOnDelivery.Offer;

/**
 * Created by RRybasov on 17.11.16.
 */
@Repository
public interface OfferDAO extends CrudRepository<Offer, Long> {
}
