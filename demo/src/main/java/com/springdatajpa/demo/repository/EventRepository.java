package com.springdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.demo.model.event.Event;

public interface EventRepository extends JpaRepository<Event, Long> {}