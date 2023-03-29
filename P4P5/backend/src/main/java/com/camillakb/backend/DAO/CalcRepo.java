package com.camillakb.backend.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camillakb.backend.Entity.Calculation;

@Repository
public interface CalcRepo extends JpaRepository<Calculation, Integer> {
    Page<Calculation> findAllByUsername(String username, Pageable pageable);
}
