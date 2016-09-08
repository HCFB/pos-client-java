package ru.homecredit.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * Created by RRybasov on 08.09.2016.
 */
@NoArgsConstructor
@Setter
@Getter
public class ApplicationResource {
    private String idApplication;
    private String evidSrv;
    private ClientInfo clientInfo;
    private Order order;
    private String status;
    private String cancelReason;
    private String maxLimit;
}
