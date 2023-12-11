package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.University;
import com.example.demo.services.UniversityService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;
    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable("id") long id) {
        University university =  universityService.findById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }
    @GetMapping
    public List<University> getAllUniversities() {
        return new ArrayList<>(universityService.findAll());
    }
    @PostMapping(consumes = {"application/json"})
    public University newUniversity(@RequestBody University newUniversity) {
        return universityService.saveUniversity(newUniversity);
    }

}

