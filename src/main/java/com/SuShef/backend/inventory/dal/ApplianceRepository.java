package com.SuShef.backend.inventory.dal;

import com.SuShef.backend.inventory.service.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
    List<Appliance> findAllByOrderByNameAsc();
    List<Appliance> findAllByOrderByNameDesc();
    List<Appliance> findAllByOrderByDateCreatedAsc();
    List<Appliance> findAllByOrderByDateCreatedDesc();
    List<Appliance> findAllByOrderByStatusAsc();
    List<Appliance> findAllByOrderByStatusDesc();
    List<Appliance> findAllByOrderByBrandAsc();
    List<Appliance> findAllByOrderByBrandDesc();




}
