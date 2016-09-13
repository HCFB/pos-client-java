package ru.homecredit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.homecredit.model.Order;

/**
 * Created by rrybasov on 12.09.2016.
 */
@Repository
public interface OrderDAO extends CrudRepository<Order, Long> {
}
