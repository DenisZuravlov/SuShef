package com.SuShef.backend.login.api;


import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.login.service.AuthService;
import com.SuShef.backend.login.service.Role;
import com.SuShef.backend.login.service.User;
import com.SuShef.backend.login.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        String token = authService.userLogin(request.getEmail(), request.password);

        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public LoginResponse register(@Valid @RequestBody RegisterRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        user.setPhone(request.getPhone());

        String token = authService.register(user);
        return new LoginResponse(token);
    }


}
