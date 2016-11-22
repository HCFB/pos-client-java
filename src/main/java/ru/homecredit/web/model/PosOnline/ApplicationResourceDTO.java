package ru.homecredit.web.model.PosOnline;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * Created by RRybasov on 08.09.2016.
 */
@NoArgsConstructor
@Setter
@Getter
public class ApplicationResourceDTO {
    private String idApplication;
    private String evidSrv;
    private ClientInfoDTO clientInfo;
    private OrderDTO order;
    private String status;
    private String cancelReason;
    private String maxLimit;
}
