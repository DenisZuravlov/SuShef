package com.SuShef.backend.login.service;

import com.SuShef.backend.login.dal.UserRepository;
import com.SuShef.backend.middlewares.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public boolean passwordsMatch(String password, String encodedPassword){
        return encoder.matches(password, encodedPassword);
    }

    public String register(User user){
        String originalPassword = user.getPassword();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return userLogin(user.getEmail(), originalPassword);
    }

    public void deleteUser(long id, String password){
        User user = userRepository.findById(id).get();
        if(!encoder.matches(password, user.getPassword())){
           throw new RuntimeException("Incorrect password");
        }
        userRepository.deleteById(id);
    }

    public String userLogin(String email, String password){
        User user = userRepository.findByEmail(email);
        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getEmail(), Collections.emptyList());
        if( passwordsMatch(password, user.getPassword())){
            return jwtService.generateToken(userPrincipal);
        }
        else{
            throw new RuntimeException("Incorrect password");
        }

    }





}
