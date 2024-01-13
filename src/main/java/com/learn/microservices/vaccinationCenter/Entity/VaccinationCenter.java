package com.learn.microservices.vaccinationCenter.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String centerName;
    @Column
    private String centerAddress;

}
