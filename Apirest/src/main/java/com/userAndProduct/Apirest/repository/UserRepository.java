 package com.userAndProduct.Apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userAndProduct.Apirest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
