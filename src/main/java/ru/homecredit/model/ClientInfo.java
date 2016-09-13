package ru.homecredit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "client_infos")
public class ClientInfo extends AbstractModel {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String sex;
}
