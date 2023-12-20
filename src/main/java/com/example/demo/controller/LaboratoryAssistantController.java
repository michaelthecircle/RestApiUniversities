package com.example.demo.controller;

import com.example.demo.model.Dormitory;
import com.example.demo.model.LaboratoryAssistant;
import com.example.demo.services.LaboratoryAssistantService;
import com.example.demo.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/laboratoryAssistant")
public class LaboratoryAssistantController {
    private final LaboratoryAssistantService laboratoryAssistantService;
    @Autowired
    public LaboratoryAssistantController(LaboratoryAssistantService laboratoryService) {
        this.laboratoryAssistantService = laboratoryService;
    }
    @GetMapping()
    public List<LaboratoryAssistant> getAssistants() {
        return laboratoryAssistantService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryAssistant> getAssistantById(@PathVariable("id") long id) {
        LaboratoryAssistant laboratoryAssistant = laboratoryAssistantService.getAssistantById(id);
        return new ResponseEntity<>(laboratoryAssistant, HttpStatus.OK);

    }
    @PostMapping("/addAssistant")
    public LaboratoryAssistant newAssistant(@RequestBody LaboratoryAssistant newAssistant) {
        return laboratoryAssistantService.saveAssistant(newAssistant);
    }
    @PostMapping("/updateAssistant")
    public ResponseEntity<String> updateAssistant(@RequestBody LaboratoryAssistant assistant) {
        LaboratoryAssistant updated = laboratoryAssistantService.updateAssistant(assistant);
        return ResponseEntity.ok("University with ID: " + updated.getIdLaboratoryAssistant() + " has been updated");
    }
}
