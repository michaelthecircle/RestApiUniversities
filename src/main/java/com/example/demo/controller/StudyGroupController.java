package com.example.demo.controller;

import com.example.demo.model.Dormitory;
import com.example.demo.model.StudyGroup;
import com.example.demo.services.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studygroup")
public class StudyGroupController {
    private final StudyGroupService studyGroupService;
    @Autowired
    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }
    @GetMapping()
    public List<StudyGroup> getStudyGroups() {
        return studyGroupService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudyGroup> getStudyGroupById(@PathVariable("id") long id) {
        StudyGroup studyGroup = studyGroupService.getStudyGroupById(id);
        return new ResponseEntity<>(studyGroup, HttpStatus.OK);

    }
    @PostMapping("/addStudyGroup")
    public StudyGroup newStudyGroup(@RequestBody StudyGroup studyGroup) {
        return studyGroupService.saveGroup(studyGroup);
    }
    @PostMapping("/updateStudyGroup")
    public ResponseEntity<String> updateStudyGroup(@RequestBody StudyGroup studyGroup) {
        StudyGroup updated = studyGroupService.updateGroup(studyGroup);
        return ResponseEntity.ok("University with ID: " + updated.getIdStudyGroup() + " has been updated");
    }
}
