package com.example.demo.services;

import com.example.demo.model.CultureHouse;
import com.example.demo.model.CultureHouseActivity;
import com.example.demo.repository.CultureHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CultureHouseService {
    private final CultureHouseRepository cultureHouseRepository;

    @Autowired
    public CultureHouseService(CultureHouseRepository repository) {this.cultureHouseRepository = repository;}

    public List<CultureHouse> findAll() {
        return cultureHouseRepository.findAll();
    }
    public CultureHouse findCultureHouseById(@PathVariable("id") long id) {
        Optional<CultureHouse> cultureHouse = cultureHouseRepository.findById(id);
        return cultureHouse.orElse(null);
    }
    public List<CultureHouseActivity> getCultureHouseActivities(long id) {
        return cultureHouseRepository.findById(id).orElseThrow().getCultureHouseActivities();
    }
}
