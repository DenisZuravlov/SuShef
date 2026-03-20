package com.SuShef.backend.inventory.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.SuShef.backend.middlewares.UserPrincipal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;


@MappedSuperclass
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "userId", type = Long.class))
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private String name;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateUpdated;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemClass itemClass;
    private String description;

    @PrePersist
    protected void onCreate() {
        // Automatically set userId from the authenticated user in SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserPrincipal) {
            UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
            this.userId = principal.getId();
        }
        // Set creation and update timestamps
        this.dateCreated = LocalDate.now();
        this.dateUpdated = LocalDate.now();
    }
}
