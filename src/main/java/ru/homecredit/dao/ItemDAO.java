package ru.homecredit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.homecredit.model.Item;

/**
 * Created by rrybasov on 21.10.2016.
 */
@Repository
public interface ItemDAO extends CrudRepository<Item, Long> {
}
