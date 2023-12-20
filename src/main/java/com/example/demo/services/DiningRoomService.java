package com.example.demo.services;

import com.example.demo.model.DiningRoom;
import com.example.demo.model.Dormitory;
import com.example.demo.repository.DiningRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DiningRoomService {
    private final DiningRoomRepository diningRoomRepository;
    @Autowired
    public DiningRoomService(DiningRoomRepository diningRoomRepository) {
        this.diningRoomRepository = diningRoomRepository;
    }

    public List<DiningRoom> findAll() {
        return diningRoomRepository.findAll();
    }
    public DiningRoom getDiningRoomById(@PathVariable("id") long id) {
        Optional<DiningRoom> diningRoom = diningRoomRepository.findById(id);
        return diningRoom.orElse(null);
    }
    @Transactional
    public DiningRoom saveDiningRoom(DiningRoom diningRoom) {
        var _diningRoom = Optional.of(diningRoomRepository.save(diningRoom));
        return _diningRoom.orElse(new DiningRoom());
    }
    @Transactional
    public DiningRoom updateDiningRoom(DiningRoom diningRoom) {
        return diningRoomRepository.save(diningRoom);
    }
}
