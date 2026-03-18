package com.SuShef.backend.inventory.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Ingredient extends Item{
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate expiryDate;
    @NotNull
    private int quantity;
    @Enumerated
    @NotNull
    private Location location;


}
