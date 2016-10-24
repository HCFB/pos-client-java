package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "client_infos")
public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_info_id_seq")
    @SequenceGenerator(name = "client_info_id_seq", sequenceName = "client_info_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String sex;
}
