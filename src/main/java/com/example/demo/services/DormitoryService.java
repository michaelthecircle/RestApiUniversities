package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.University;
import com.example.demo.repository.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DormitoryService {
    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Dormitory> findAll() {
        return dormitoryRepository.findAll();
    }
    public Dormitory getDormitoryById(@PathVariable("id") long id) {
        Optional<Dormitory> dormitory = dormitoryRepository.findById(id);
        return dormitory.orElse(null);
    }
    @Transactional
    public Dormitory saveDormitory(Dormitory dormitory) {
        var _dormitory = Optional.of(dormitoryRepository.save(dormitory));
        return _dormitory.orElse(new Dormitory());
    }
    @Transactional
    public Dormitory updateDormitory(Dormitory dormitory) {
        return dormitoryRepository.save(dormitory);
    }
}
