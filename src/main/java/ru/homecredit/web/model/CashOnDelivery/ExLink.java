package ru.homecredit.web.model.CashOnDelivery;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;

/**
 * Created by RRybasov on 21.11.16.
 */
@Getter
@Setter
public class ExLink extends Link {
    private String method;
}
