package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Trainer;
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
