package com.example.demo.repository;
/*
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    //void deleteById(int id);
}*/
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    //User findByUsername(String username);
    boolean existsByUsername(String username);
    //void deleteById(int id);
    User findByUsername(String username);
    boolean existsByEmail(String email);
    // Optional<User> findByUsername(String username);
}