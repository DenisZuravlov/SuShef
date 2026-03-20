package com.SuShef.backend.login.api;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    public String email;
    @NotNull
    public String password;
}
