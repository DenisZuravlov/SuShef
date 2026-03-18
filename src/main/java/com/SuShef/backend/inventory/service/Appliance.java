package com.SuShef.backend.inventory.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Appliance extends Item{
    private String brand;
    private String model;
    @Enumerated
    @NonNull
    private Status status;
    @Enumerated
    @NonNull
    private Category category;


}
