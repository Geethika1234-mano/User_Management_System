package com.example.User_Management_System.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User_Management_System.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
