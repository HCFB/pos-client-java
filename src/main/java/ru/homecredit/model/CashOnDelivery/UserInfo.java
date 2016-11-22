package ru.homecredit.model.CashOnDelivery;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 16.11.16.
 */
@Data
@Entity
@Table(name = "cod_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_user_info_id_seq")
    @SequenceGenerator(name = "cod_user_info_id_seq", sequenceName = "cod_user_info_id_seq", allocationSize = 1)
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
}
