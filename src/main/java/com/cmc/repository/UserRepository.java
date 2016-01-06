package com.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
