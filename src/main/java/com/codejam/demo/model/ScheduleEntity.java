package com.codejam.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "SCHEDULE", schema = "testdb")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "venue")
    private String venue;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "country")
    private String country;

}
