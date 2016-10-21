package ru.homecredit.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.homecredit.service.ApplicationsService;
import ru.homecredit.web.model.*;

import java.util.List;
import java.util.Random;

/**
 * Created by RRybasov on 05.07.16.
 */
@Controller
@ResponseBody
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class MainController {

    private OAuth2RestOperations restTemplate;

    private ApplicationsService applicationsService;

    @Autowired
    public MainController(@Qualifier("restTemplate") OAuth2RestOperations restTemplate,
                          ApplicationsService applicationsService) {
        this.restTemplate = restTemplate;
                this.applicationsService = applicationsService;
    }

    @RequestMapping(value = "applicationCreate", method = RequestMethod.POST)
    public ResponseEntity<ApplicationResponse> createApplication(@RequestBody CreateApplicationRequest createApplicationRequest, @RequestHeader("Host") String host) {
        return applicationsService.createApplication(createApplicationRequest, host);
    }
}
