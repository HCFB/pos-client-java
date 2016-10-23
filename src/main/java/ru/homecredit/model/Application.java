package ru.homecredit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_id_seq")
    @SequenceGenerator(name = "application_id_seq", sequenceName = "application_id_seq", allocationSize = 1)
    private Long id;
    private String bankUrl;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private ApplicationResource applicationResource;
}