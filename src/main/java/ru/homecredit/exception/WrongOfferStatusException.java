package ru.homecredit.exception;

/**
 * Created by RRybasov on 28.11.16.
 */
public class WrongOfferStatusException extends Exception {
    public WrongOfferStatusException(String message) {
        super(message);
    }
}
