package com.example.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hogwarts.models.Artifact;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, String> {

}
