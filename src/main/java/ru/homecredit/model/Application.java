package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "applications")
public class Application extends AbstractModel {
    private String bankUrl;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private ApplicationResource applicationResource;
}