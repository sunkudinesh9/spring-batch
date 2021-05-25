package com.dineshlearnings.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dineshlearnings.springbatch.model.User;

public interface UserRespository extends JpaRepository<User, Integer> {

}
