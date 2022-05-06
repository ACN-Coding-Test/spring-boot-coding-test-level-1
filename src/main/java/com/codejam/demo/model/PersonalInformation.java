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
@Table(name = "PERSONAL_INFORMATION")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonalInformation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "REAL_NAME", columnDefinition = "varchar(50)")
    private String real_name;

    @Column(name = "IDOL_NAME", columnDefinition = "varchar(60)")
    private String idol_name;

    @Column(name = "ADDRESS", columnDefinition = "varchar(255)")
    private String address;

    @Column(name = "IDOL_STATUS", columnDefinition = "varchar(25)")
    private String idol_status;

}
