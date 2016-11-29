package ru.homecredit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.homecredit.exception.WrongOfferStatusException;
import ru.homecredit.web.model.ErrorResponse;

/**
 * Created by RRybasov on 28.11.16.
 */
@ControllerAdvice(basePackages = "ru.homecredit.controller")
public class ExceptionController {

    @ExceptionHandler(WrongOfferStatusException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse wrongStatus(WrongOfferStatusException ex) {
        return new ErrorResponse(ex.getMessage());
    }

}
