package com.example.horsedemo.service;

import com.example.horsedemo.repository.Horse;
import com.example.horsedemo.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    public List<Horse> listAll(){
        return horseRepository.findAll();
    }

    public void save(Horse horse){
        horseRepository.save(horse);
    }

    public Horse get(Integer id) {
        return horseRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        horseRepository.deleteById(id);
    }

}
