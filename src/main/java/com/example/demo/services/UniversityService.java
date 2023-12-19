package com.example.demo.services;

import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public University getUniversityById(@PathVariable("id") long id) {
        Optional<University> university = universityRepository.findById(id);
        return university.orElse(null);
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Transactional
    public List<University> findUniversitiesByCriteria(boolean hasGovernmentFunding, boolean hasMilitaryCenter, boolean hasDormitories, double minRating) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<University> query = cb.createQuery(University.class);
        Root<University> university = query.from(University.class);

        List<Predicate> predicates = new ArrayList<>();
        if (hasGovernmentFunding) {
            predicates.add(cb.equal(university.get("hasGovernmentFunding"), true));
        }
        if (hasMilitaryCenter) {
            predicates.add(cb.equal(university.get("hasMilitaryCenter"), true));
        }
        if(hasDormitories) {
            predicates.add(cb.isNotEmpty(university.get("dormitories")));
        }
        if(minRating != 0.0) {
            predicates.add(cb.greaterThanOrEqualTo(university.get("rating"), minRating));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
    @Transactional
    public University findUniversitiesByName(String name) {
        return universityRepository.findByName(name);
    }

    @Transactional
    public University addUniversity(University university) {
        return universityRepository.save(university);
    }

    @Transactional
    public University updateUniversity(University university) {
        return universityRepository.save(university);
    }

}
