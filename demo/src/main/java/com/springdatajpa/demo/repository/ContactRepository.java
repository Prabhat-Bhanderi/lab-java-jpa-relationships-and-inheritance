package com.springdatajpa.demo.repository;

import com.springdatajpa.demo.model.pr.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}