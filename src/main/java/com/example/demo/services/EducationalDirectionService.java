package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.EducationalDirection;
import com.example.demo.repository.EducationalDirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EducationalDirectionService {
    private final EducationalDirectionRepository educationalDirectionRepository;
    @Autowired
    public EducationalDirectionService(EducationalDirectionRepository educationalDirectionRepository) {
        this.educationalDirectionRepository = educationalDirectionRepository;
    }
    public List<EducationalDirection> findAll() {
        return educationalDirectionRepository.findAll();
    }
    public EducationalDirection getEducationalDirectionById(@PathVariable("id") long id) {
        Optional<EducationalDirection> direction = educationalDirectionRepository.findById(id);
        return direction.orElse(null);
    }
    @Transactional
    public EducationalDirection saveDirection(EducationalDirection direction) {
        var _direction = Optional.of(educationalDirectionRepository.save(direction));
        return _direction.orElse(new EducationalDirection());
    }
    @Transactional
    public EducationalDirection updateDirection(EducationalDirection direction) {
        return educationalDirectionRepository.save(direction);
    }
}
