package com.learn.microservices.vaccinationCenter.Controller;

import com.learn.microservices.vaccinationCenter.Entity.VaccinationCenter;
import com.learn.microservices.vaccinationCenter.Model.Citizen;
import com.learn.microservices.vaccinationCenter.Model.RequiredResponse;
import com.learn.microservices.vaccinationCenter.repository.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private CenterRepo centerRepo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
        VaccinationCenter vc = centerRepo.save(vaccinationCenter);
        return new ResponseEntity<>(vc, HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id){
        RequiredResponse reqRes = new RequiredResponse();
          VaccinationCenter center = centerRepo.findById(id).get();
          reqRes.setVaccinationCenter(center);
          List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
          reqRes.setCitizens(listOfCitizens);
          return new ResponseEntity<>(reqRes,HttpStatus.OK);
    }
    public String fallbackMethod() {
        // Fallback behavior in case of failure
        return "Fallback result";
    }
}
