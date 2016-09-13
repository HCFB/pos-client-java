package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "application_resources")
public class ApplicationResource extends AbstractModel {
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
