package com.SuShef.backend.inventory.service;

import com.SuShef.backend.inventory.dal.ApplianceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class ApplianceService extends ItemService{
    private final ApplianceRepository applianceRepository; // import the appliance repository

    public Appliance addAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public void deleteAppliance(Long id){
        Appliance applianceToDelete = applianceRepository.findById(id) // find the appliance by id
                .orElseThrow(() -> notFound("Appliance", id)); // throw an exception if the appliance is not found
        applianceRepository.delete(applianceToDelete);
    }

    public void updateAppliance(Appliance appliance, Long id){
        Appliance applianceToUpdate = applianceRepository.findById(id) // find the appliance by id
                .orElseThrow(() -> notFound("Appliance", id)); // throw an exception if the appliance is not found
        updateItem(applianceToUpdate, appliance); // method from ItemService that updates common fields of ingredients and appliances
        applianceToUpdate.setBrand(appliance.getBrand());
        applianceToUpdate.setModel(appliance.getModel());
        applianceToUpdate.setStatus(appliance.getStatus());
        applianceToUpdate.setCategory(appliance.getCategory());
        applianceRepository.save(applianceToUpdate);

    }


    public List<Appliance> getAllAppliances(){
        return applianceRepository.findAll();
    }

    public List<Appliance> getAllAppliancesByNameAsc(){
        return applianceRepository.findAllByOrderByNameAsc();
    }
    public List<Appliance> getAllAppliancesByNameDesc(){
        return applianceRepository.findAllByOrderByNameDesc();
    }


    public List<Appliance> getAllAppliancesByDateCreatedAsc(){
        return applianceRepository.findAllByOrderByDateCreatedAsc();
    }
    public List<Appliance> getAllAppliancesByDateCreatedDesc(){
        return applianceRepository.findAllByOrderByDateCreatedDesc();
    }


    public List<Appliance> GetAllAppliancesByStatusAsc(){
        return applianceRepository.findAllByOrderByStatusAsc();
    }
    public List<Appliance> GetAllAppliancesByStatusDesc(){
        return applianceRepository.findAllByOrderByStatusDesc();
    }


    public List<Appliance> GetAllAppliancesByBrandAsc(){
        return applianceRepository.findAllByOrderByBrandAsc();
    }
    public List<Appliance> GetAllAppliancesByBrandDesc(){
        return applianceRepository.findAllByOrderByBrandDesc();
    }










}
