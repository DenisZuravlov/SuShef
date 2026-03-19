package com.SuShef.backend.login.service;


import com.SuShef.backend.login.dal.UserRepository;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService{

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final AuthService authService;

    private final UserRepository userRepository;

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow();
    }


    public User changePassword(User user, String password){
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

    public User updateUser(User user, long id , String password){
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No such user" ));

        if(encoder.matches(password, userToUpdate.getPassword())){
            user.setPassword(userToUpdate.getPassword());
            user.setRole(userToUpdate.getRole());
            user.setEmail(userToUpdate.getEmail());
            user.setPhone(userToUpdate.getPhone());
            return userRepository.save(userToUpdate);

        }
        else{
            throw new NoSuchElementException("Incorrect password");
        }

    }







}
