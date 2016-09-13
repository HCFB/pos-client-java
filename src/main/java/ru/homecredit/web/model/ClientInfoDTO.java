package ru.homecredit.web.model;

import lombok.Data;
import org.dozer.Mapping;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class ClientInfoDTO {
//    @Mapping("name")
    private String firstName;
//    @Mapping("lastname")
    private String lastName;
//    @Mapping("middlename")
    private String middleName;
    private String email;
    private String phone;
    private String sex;
}
