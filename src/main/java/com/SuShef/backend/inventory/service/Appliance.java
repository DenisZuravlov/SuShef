package com.SuShef.backend.inventory.service;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class  Appliance extends Item{
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Status status;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Category category;


}
