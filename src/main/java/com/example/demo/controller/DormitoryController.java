package com.example.demo.controller;

import com.example.demo.model.Dormitory;
import com.example.demo.model.University;
import com.example.demo.services.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost/808sfafasd1")
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
    @PostMapping("/addDormitory")
    public Dormitory newDormitory(@RequestBody Dormitory newDormitory) {
        return dormitoryService.saveDormitory(newDormitory);
    }
    @PostMapping("/updateDormitory")
    public ResponseEntity<String> updateDormitory(@RequestBody Dormitory dormitory) {
        Dormitory updated = dormitoryService.updateDormitory(dormitory);
        return ResponseEntity.ok("University with ID: " + updated.getDormitoryId() + " has been updated");
    }

}
