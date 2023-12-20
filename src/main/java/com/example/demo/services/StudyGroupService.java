package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.StudyGroup;
import com.example.demo.repository.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;
    @Autowired
    public StudyGroupService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }
    public List<StudyGroup> findAll() {
        return studyGroupRepository.findAll();
    }
    public StudyGroup getStudyGroupById(@PathVariable("id") long id) {
        Optional<StudyGroup> studyGroup = studyGroupRepository.findById(id);
        return studyGroup.orElse(null);
    }
    @Transactional
    public StudyGroup saveGroup(StudyGroup studyGroup) {
        var _group = Optional.of(studyGroupRepository.save(studyGroup));
        return _group.orElse(new StudyGroup());
    }
    @Transactional
    public StudyGroup updateGroup(StudyGroup studyGroup) {
        return studyGroupRepository.save(studyGroup);
    }
}
