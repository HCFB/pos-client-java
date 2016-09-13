package ru.homecredit.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Resource;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@NoArgsConstructor
public class ApplicationResponse {
    private String bankUrl;
    private ApplicationResourceDTO applicationResource;
}
