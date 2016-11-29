package ru.homecredit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.homecredit.model.PosOnline.Application;

/**
 * Created by RRybasov on 09.09.2016.
 */
@Repository
public interface ApplicationDAO extends CrudRepository<Application, Long> {
}
