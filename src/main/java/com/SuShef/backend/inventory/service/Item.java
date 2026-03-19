package com.SuShef.backend.inventory.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.time.LocalDate;


@MappedSuperclass
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "userId", type = Long.class))
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long userId;
    @NotNull
    private String name;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateUpdated;
    @NotNull
    @Enumerated
    private ItemClass itemClass;
    private String description;
}
