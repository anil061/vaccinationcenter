package com.learn.microservices.vaccinationCenter.repository;

import com.learn.microservices.vaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
