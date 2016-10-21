package ru.homecredit.service;

import org.springframework.http.ResponseEntity;
import ru.homecredit.web.model.ApplicationResponse;
import ru.homecredit.web.model.CreateApplicationRequest;

/**
 * Created by RRybasov on 08.09.2016.
 */
public interface ApplicationsService {
    ResponseEntity<ApplicationResponse> createApplication(CreateApplicationRequest createApplicationRequest, String host);
}
