package com.SuShef.backend.inventory.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;


@MappedSuperclass
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateUpdated;
    private ItemClass itemClass;
    private String description;
}
