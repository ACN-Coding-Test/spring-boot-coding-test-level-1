package com.codejam.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
//@Table(name = "SCHEDULE")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "ID")
    private Integer id;

    //@Column(name = "VENUE", columnDefinition = "varchar(50)")
    private String venue;

    //@Column(name = "EVENT_NAME", columnDefinition = "varchar(60)")
    private String event_name;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "SCHEDULE_DATE_TIME", columnDefinition = "varchar(50)")
    private String date_time;
}
