package com.springdatajpa.demo.repository;

import com.springdatajpa.demo.model.nurse.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association, Long> {}