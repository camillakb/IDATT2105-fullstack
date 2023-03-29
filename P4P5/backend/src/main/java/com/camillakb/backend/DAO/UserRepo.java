package com.camillakb.backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camillakb.backend.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
