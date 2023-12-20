package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.Laboratory;
import com.example.demo.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryService {
    private final LaboratoryRepository laboratoryRepository;
    @Autowired
    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }
    public List<Laboratory> findAll() {
        return laboratoryRepository.findAll();
    }
    public Laboratory getLaboratoryById(@PathVariable("id") long id) {
        Optional<Laboratory> laboratory = laboratoryRepository.findById(id);
        return laboratory.orElse(null);
    }
    @Transactional
    public Laboratory saveLaboratory(Laboratory laboratory) {
        var _laboratory = Optional.of(laboratoryRepository.save(laboratory));
        return _laboratory.orElse(new Laboratory());
    }
    @Transactional
    public Laboratory updateLaboratory(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }
}
