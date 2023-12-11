package com.example.demo.services;

import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Service
public class UniversityService {
    private final UniversityRepository universityRepository;


    @Autowired
    public UniversityService(UniversityRepository university) {
        this.universityRepository = university;
    }

    public University findById(long id) {
        Optional<University> university = universityRepository.findById(id);
        return university.orElse(null);
    }
    public University saveUniversity(University university) {
        var _university = Optional.of(universityRepository.save(university));
        return _university.orElse(new University());
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

}
