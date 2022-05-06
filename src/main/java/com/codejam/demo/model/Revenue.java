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
//@Table(name = "REVENUE")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "REVENUE_ID")
    private Integer id;

    //@Column(name = "MONTHLY_RATE", columnDefinition = "varchar(50)")
    private String monthly_rate;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "REVENUE_DATE_TIME", columnDefinition = "varchar(50)")
    private String date_time;
}
