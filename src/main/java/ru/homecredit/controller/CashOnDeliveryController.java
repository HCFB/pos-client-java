package ru.homecredit.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import ru.homecredit.model.CashOnDelivery.Offer;
import ru.homecredit.service.OfferService;
import ru.homecredit.web.model.CashOnDelivery.ExLink;
import ru.homecredit.web.model.CashOnDelivery.dto.OfferCreateDTO;
import ru.homecredit.web.model.CashOnDelivery.enums.MethodResult;


/**
 * Created by RRybasov on 15.11.16.
 */

@Slf4j
@Controller
public class CashOnDeliveryController {


    private OfferService offerService;
    private RestOperations restTemplate;

    @Autowired
    public CashOnDeliveryController(OfferService offerService,
                                    RestOperations restTemplate) {
        this.offerService = offerService;
        this.restTemplate = restTemplate;
    }

    @ResponseBody
    @RequestMapping(value = "offerCreate", method = RequestMethod.POST)
    public ExLink createOffer(@RequestBody OfferCreateDTO offerCreateDTO, @RequestHeader("Host") String host) {
        return offerService.createOffer(offerCreateDTO, host);
    }

    @RequestMapping(value = "/offer/{method}/{offerId}", method = RequestMethod.GET)
    public String resultOffer(@PathVariable long offerId, @PathVariable MethodResult method) {
        return "redirect:/front/offerResult.html?result=" + method.name() + "&offerId=" + offerId;
    }

    @ResponseBody
    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.GET)
    public Offer getOffer(@PathVariable long offerId) {
        return offerService.getOffer(offerId);
    }
}
