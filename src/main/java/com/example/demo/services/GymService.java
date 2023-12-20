package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.Gym;
import com.example.demo.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {
    private final GymRepository gymRepository;
    @Autowired
    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }
    public List<Gym> findAll() {
        return gymRepository.findAll();
    }
    public Gym getGymById(@PathVariable("id") long id) {
        Optional<Gym> gym = gymRepository.findById(id);
        return gym.orElse(null);
    }
    @Transactional
    public Gym saveGym(Gym gym) {
        var _gym = Optional.of(gymRepository.save(gym));
        return _gym.orElse(new Gym());
    }
    @Transactional
    public Gym updateGym(Gym gym) {
        return gymRepository.save(gym);
    }
}
