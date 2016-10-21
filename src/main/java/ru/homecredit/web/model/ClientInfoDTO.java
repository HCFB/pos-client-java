package ru.homecredit.web.model;

import lombok.Data;
import org.dozer.Mapping;

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
