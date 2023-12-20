package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Dormitory;
import com.example.demo.model.Laboratory;
import com.example.demo.model.LaboratoryAssistant;
import com.example.demo.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/laboratory")
public class LaboratoryController {
    private final LaboratoryService laboratoryService;
    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }
    @GetMapping()
    public List<Laboratory> getLaboratories() {
        return laboratoryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratoryById(@PathVariable("id") long id) {
        Laboratory laboratory = laboratoryService.getLaboratoryById(id);
        return new ResponseEntity<>(laboratory, HttpStatus.OK);

    }
    @PostMapping("/addLaboratory")
    public Laboratory newLaboratory(@RequestBody Laboratory newLaboratory) {
        return laboratoryService.saveLaboratory(newLaboratory);
    }
    @PostMapping("/updateLaboratory")
    public ResponseEntity<String> updateLabpratory(@RequestBody Laboratory laboratory) {
        Laboratory updated = laboratoryService.updateLaboratory(laboratory);
        return ResponseEntity.ok("University with ID: " + updated.getIdLaboratory() + " has been updated");
    }
    @GetMapping("/findLaboratoryAssistants/{id}")
    ResponseEntity<List<LaboratoryAssistant>> findWorkers(@PathVariable("id") long id) {
        List<LaboratoryAssistant> assistants = new ArrayList<>(laboratoryService.getLaboratoryById(id).getLaboratoryAssistants());
        return ResponseEntity.ok(assistants);
    }
}
