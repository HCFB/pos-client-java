package ru.homecredit.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.homecredit.dao.OrderDAO;
import ru.homecredit.model.PosOnline.Order;
import ru.homecredit.web.model.PosOnline.OrderDTO;

/**
 * Created by rrybasov on 24.10.2016.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private Mapper mapper;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, Mapper mapper) {
        this.orderDAO = orderDAO;
        this.mapper = mapper;
    }

    @Override
    public OrderDTO getOrder(Long id) throws ResourceNotFoundException {
        Order order = orderDAO.findOne(id);
        if(order == null) throw new ResourceNotFoundException();
        return mapper.map(order, OrderDTO.class);
    }
}
