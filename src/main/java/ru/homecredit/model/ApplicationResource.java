package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "application_resources")
public class ApplicationResource {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_resource_id_seq")
    @SequenceGenerator(name = "application_resource_id_seq", sequenceName = "application_resource_id_seq", allocationSize = 1)
    private Long id;
    private String idApplication;
    private String evidSrv;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private ClientInfo clientInfo;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Order order;
    private String status;
    private String cancelReason;
    private String maxLimit;
}
