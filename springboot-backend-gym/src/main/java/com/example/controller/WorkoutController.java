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

import com.example.Entity.Workout;
import com.example.Exception.ResourceNotfoundException;
import com.example.repository.WorkoutRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @GetMapping("/workouts")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/workouts/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable(value = "id") Long id)
            throws ResourceNotfoundException {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Workout not found for this id :: " + id));
        return ResponseEntity.ok().body(workout);
    }

    @PostMapping("/workouts")
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }

    @PutMapping("/workouts/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable(value = "id") Long id,
            @RequestBody Workout workoutDetails) throws ResourceNotfoundException {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Workout not found with this id :: " + id));

        workout.setName(workoutDetails.getName());
        workout.setDescription(workoutDetails.getDescription());

        final Workout updatedWorkout = workoutRepository.save(workout);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/workouts/{id}")
    public Map<String, Boolean> deleteWorkout(@PathVariable(value = "id") Long id) throws ResourceNotfoundException {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Workout not found with this id :: " + id));

        workoutRepository.delete(workout);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Workout session  with this id "+id+" is deleted", Boolean.TRUE);
        return response;
    }
}

