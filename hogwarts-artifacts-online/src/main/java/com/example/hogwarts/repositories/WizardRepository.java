package com.example.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hogwarts.models.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {

}
