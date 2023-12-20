package com.example.demo.repository;

import com.example.demo.model.CultureHouse;
import com.example.demo.model.CultureHouseActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CultureHouseRepository extends JpaRepository<CultureHouse, Long> {
}