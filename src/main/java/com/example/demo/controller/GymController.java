package com.example.demo.controller;

import com.example.demo.model.CultureHouseActivity;
import com.example.demo.model.Dormitory;
import com.example.demo.model.Gym;
import com.example.demo.model.GymActivity;
import com.example.demo.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/gym")
public class GymController {
    private final GymService gymService;
    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }
    @GetMapping()
    public List<Gym> getGyms() {
        return gymService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGymById(@PathVariable("id") long id) {
        Gym gym = gymService.getGymById(id);
        return new ResponseEntity<>(gym, HttpStatus.OK);

    }
    @PostMapping("/addGym")
    public Gym newGym(@RequestBody Gym newGym) {
        return gymService.saveGym(newGym);
    }
    @PostMapping("/updateGym")
    public ResponseEntity<String> updateGym(@RequestBody Gym gym) {
        Gym updated = gymService.updateGym(gym);
        return ResponseEntity.ok("University with ID: " + updated.getIdGym() + " has been updated");
    }
    @GetMapping("/findActivities/{id}") //TODO::findactivities doesnt work
    ResponseEntity<List<GymActivity>> findActivities(@PathVariable("id") long id) {
        List<GymActivity> activities = new ArrayList<>(gymService.getGymById(id).getGymActivities());
        return ResponseEntity.ok(activities);
    }
}
