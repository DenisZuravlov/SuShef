package com.SuShef.backend.inventory.service;

import com.SuShef.backend.inventory.dal.ApplianceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplianceService{
    private final ApplianceRepository applianceRepository; // import the appliance repository

    public Appliance addAppliance(Appliance appliance){ // add a new appliance
        return applianceRepository.save(appliance);
    }

    public void deleteAppliance(Long id){
        if(applianceRepository.existsById(id)) { // if the appliance exists
            applianceRepository.deleteById(id); // delete the appliance
        }
        else{
            throw new NoSuchElementException("Appliance ID " + id + " not found");
        }
    }

    public void updateAppliance(Appliance appliance, Long id){
        if(applianceRepository.existsById(id)) { // if the appliance exists
            deleteAppliance(id); // delete the appliance
            addAppliance(appliance); // add the updated appliance
        }
        else { // if the appliance does not exist
            throw new NoSuchElementException("Appliance ID " + id + " not found"); // throw an exception
        }
    }

    public List<Appliance> getAllAppliances(){
        return applianceRepository.findAll();
    }



}
