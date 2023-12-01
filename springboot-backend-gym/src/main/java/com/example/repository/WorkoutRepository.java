package com.example.repository;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
