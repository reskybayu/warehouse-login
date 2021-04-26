package com.Warehouse.repositories;

import com.Warehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u from User u Where u.email =?1")
    User findByEmail(String email);

}
