package com.example.hogwarts.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.hogwarts.dtos.ArtifactsDtoRecord;
import com.example.hogwarts.exceptions.ResourceNotFoundException;
import com.example.hogwarts.mappers.ArtifactMapper;
import com.example.hogwarts.models.Artifact;
import com.example.hogwarts.repositories.ArtifactRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ArtifactService {
	
	private final ArtifactRepository artifactRepository;
	private final ArtifactMapper artifactMapper;
	
	public Artifact findById(String artifactId) {
		return artifactRepository.findById(artifactId).orElseThrow(() -> new ResourceNotFoundException("Artifact not found."));
	}

	public Artifact addArtifact(ArtifactsDtoRecord artifactDto) {
		Artifact artifact = artifactMapper.toEntity(artifactDto);
		artifact.setId(getSaltString());
		return artifactRepository.save(artifact);
	}
	
	private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
