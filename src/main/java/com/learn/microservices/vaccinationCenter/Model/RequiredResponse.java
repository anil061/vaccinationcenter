package com.learn.microservices.vaccinationCenter.Model;

import com.learn.microservices.vaccinationCenter.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {
    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;
}
