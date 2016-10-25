package ru.homecredit.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import ru.homecredit.web.model.OrderDTO;

/**
 * Created by rrybasov on 24.10.2016.
 */
public interface OrderService {
    OrderDTO getOrder(Long id) throws ResourceNotFoundException;
}
