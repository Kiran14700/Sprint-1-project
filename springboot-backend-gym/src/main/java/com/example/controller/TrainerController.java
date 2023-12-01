package com.example.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Trainer;
import com.example.Exception.ResourceNotfoundException;
import com.example.repository.TrainerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TrainerController {
    
    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("/trainers")
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @GetMapping("/trainers/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable(value = "id") Long id)
            throws ResourceNotfoundException {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Trainer not found for this id :: " + id));
        return ResponseEntity.ok().body(trainer);
    }

    @PostMapping("/trainers")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @PutMapping("/trainers/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable(value = "id") Long id,
            @RequestBody Trainer trainerDetails) throws ResourceNotfoundException {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Trainer not found with this id :: " + id));

        trainer.setName(trainerDetails.getName());
        trainer.setSpecialization(trainerDetails.getSpecialization());
        trainer.setMembers(trainerDetails.getMembers());

        final Trainer updatedTrainer = trainerRepository.save(trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/trainers/{id}")
    public Map<String, Boolean> deleteTrainer(@PathVariable(value = "id") Long id)
            throws ResourceNotfoundException {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Trainer not found with this id :: " + id));

        trainerRepository.delete(trainer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Trainer with this id "+id+" is deleted", Boolean.TRUE);
        return response;
    }
}

