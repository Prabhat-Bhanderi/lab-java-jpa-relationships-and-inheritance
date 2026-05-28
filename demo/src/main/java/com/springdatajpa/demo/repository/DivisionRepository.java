package com.springdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdatajpa.demo.model.nurse.Division;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district);
}
