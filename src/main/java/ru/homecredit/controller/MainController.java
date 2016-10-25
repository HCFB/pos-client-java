package ru.homecredit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.homecredit.service.ApplicationsService;
import ru.homecredit.service.OrderService;
import ru.homecredit.web.model.*;


/**
 * Created by RRybasov on 05.07.16.
 */
@Controller
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class MainController {

    private OrderService orderService;

    private ApplicationsService applicationsService;

    @Autowired
    public MainController(OrderService orderService, ApplicationsService applicationsService) {
        this.orderService = orderService;
        this.applicationsService = applicationsService;
    }

    @ResponseBody
    @RequestMapping(value = "applicationCreate", method = RequestMethod.POST)
    public HttpEntity<ApplicationResponse> createApplication(@RequestBody CreateApplicationRequest createApplicationRequest, @RequestHeader("Host") String host) {
        return applicationsService.createApplication(createApplicationRequest, host);
    }

    @ResponseBody
    @RequestMapping(value = "order/{orderId}", method = RequestMethod.GET)
    public OrderDTO getOrder(@PathVariable Long orderId) throws ResourceNotFoundException {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    public String getAccept(@RequestParam String order) {
        return "redirect:/front/accept.html?order=" + order;
    }
}
