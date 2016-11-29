package ru.homecredit.web.model.PosOnline;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@AllArgsConstructor
public class ApplicationRequest {
    private ClientInfoDTO clientInfo;
    private OrderDTO order;
    private String shopUrl;
}
