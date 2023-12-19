package com.example.demo.controller;

import com.example.demo.model.Dormitory;
import com.example.demo.services.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost/8081")
@RestController
@RequestMapping(value = "/dormitory")
public class DormitoryController {
    private final DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }
    @GetMapping()
    public List<Dormitory> getUniversity() {
        return dormitoryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dormitory> getUniversityById(@PathVariable("id") long id) {
        Dormitory dormitory = dormitoryService.getDormitoryById(id);
        return new ResponseEntity<>(dormitory, HttpStatus.OK);

    }
}
