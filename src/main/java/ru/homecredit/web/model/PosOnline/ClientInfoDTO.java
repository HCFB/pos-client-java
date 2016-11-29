package ru.homecredit.web.model.PosOnline;

import lombok.Data;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class ClientInfoDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String sex;
}
