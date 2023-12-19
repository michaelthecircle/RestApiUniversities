package com.example.demo.controller;

import com.example.demo.model.Dormitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.University;
import com.example.demo.services.UniversityService;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/university")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }
    @GetMapping()
    public List<University> getUniversity() {
        return universityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable("id") long id) {
        University university = universityService.getUniversityById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @GetMapping("/byFilter")
    public ResponseEntity<List<University>> findUniversitiesByCriteria(
            @RequestParam(value = "hasGovernmentFunding", required = false, defaultValue = "false") boolean hasGovernmentFunding,
            @RequestParam(value = "hasMilitaryCenter", required = false, defaultValue = "false") boolean hasMilitaryCenter,
            @RequestParam(value = "hasDormitories", required = false, defaultValue = "false") boolean hasDormitories,
            @RequestParam(value = "minRating", required = false, defaultValue = "0.0") double minRating
    ) {
        List<University>universities = universityService.findUniversitiesByCriteria(hasGovernmentFunding, hasMilitaryCenter, hasDormitories, minRating);
        return ResponseEntity.ok(universities);
    }

    @GetMapping("/findByName")
    ResponseEntity<University> findUniversitiesByName(@RequestParam("name") String name) {
        University university = universityService.findUniversitiesByName(name);
        if (university != null) {
            return new ResponseEntity<>(university, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUniversity")
    public ResponseEntity<String> addUniversity(@RequestBody University university) {
        University newUniversity = universityService.addUniversity(university);
        return ResponseEntity.ok("University added with ID: " + newUniversity.getIdUniversity());
    }

    @PostMapping("/updateUniversity")
    public ResponseEntity<String> updateUniversity(@RequestBody University university) {
        University updatedUniversity = universityService.updateUniversity(university);
        return ResponseEntity.ok("University with ID: " + updatedUniversity.getIdUniversity() + " has been updated");
    }
}

