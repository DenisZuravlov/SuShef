package com.SuShef.backend.inventory.dal;

import com.SuShef.backend.inventory.service.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
    Appliance findByName(String name);
    Appliance findByBrand(String manufacturer);
    Appliance findByModel(String model);
}
