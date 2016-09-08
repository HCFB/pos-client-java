package ru.homecredit.web.model;

import lombok.Data;

import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class CreateApplicationRequest {
    //@Mapping("firstName")
    private String name;
    //@Mapping("lastName")
    private String lastname;
    //@Mapping("middleName")
    private String middlename;
    private String email;
    private String phone;
    private String address;
    private String code;
    private String sex;
    private List<Item> items;
}
