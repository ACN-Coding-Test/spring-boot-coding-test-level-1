package com.codejam.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "REVENUE", schema = "testdb")
public class RevenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "monthly_rate")
    private String monthlyRate;

    @Column(name = "date_time")
    private String dateTime;


}
