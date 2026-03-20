package com.SuShef.backend.login.dal;

import com.SuShef.backend.login.service.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
