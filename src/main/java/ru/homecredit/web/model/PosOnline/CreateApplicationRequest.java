package ru.homecredit.web.model.PosOnline;

import lombok.Data;

import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
public class CreateApplicationRequest {

    private String name;
    private String lastname;
    private String middlename;
    private String email;
    private String phone;
    private String address;
    private String code;
    private String sex;
    private List<ItemDTO> items;
}
