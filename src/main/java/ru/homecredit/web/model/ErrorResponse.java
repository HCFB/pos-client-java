package ru.homecredit.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by RRybasov on 28.11.16.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
}
