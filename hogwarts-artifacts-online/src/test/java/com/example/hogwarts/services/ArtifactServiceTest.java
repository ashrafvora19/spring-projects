package com.example.hogwarts.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hogwarts.exceptions.ResourceNotFoundException;
import com.example.hogwarts.models.Artifact;
import com.example.hogwarts.models.Wizard;
import com.example.hogwarts.repositories.ArtifactRepository;

@ExtendWith(MockitoExtension.class)
class ArtifactServiceTest {
	
	@InjectMocks
	ArtifactService artifactService;
	
	@Mock
	ArtifactRepository artifactRepository;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByIdSuccess() {
		// Given
		Artifact artifact = new Artifact();
		artifact.setId("12345");
		artifact.setName("Invisibility Cloak");
		artifact.setDescription("Make wearer invisible.");
		artifact.setImageUrl("ImageUrl");
		
		Wizard wizard = new Wizard();
		wizard.setId(2L);
		wizard.setName("Harry Potter");
		
		artifact.setOwner(wizard);
		
		BDDMockito.given(artifactRepository.findById("12345")).willReturn(Optional.of(artifact));
		
		// When
		Artifact returnedArtifact = artifactService.findById("12345");
		
		// Then
		assertThat(returnedArtifact.getId()).isEqualTo(artifact.getId());
		assertThat(returnedArtifact.getName()).isEqualTo(artifact.getName());
		assertThat(returnedArtifact.getDescription()).isEqualTo(artifact.getDescription());
		assertThat(returnedArtifact.getImageUrl()).isEqualTo(artifact.getImageUrl());
		
		verify(artifactRepository, times(1)).findById("12345");
		
	}

	@Test
	void testFindByIdNotFound() {
		// Given		
		BDDMockito.given(artifactRepository.findById(Mockito.any(String.class))).willReturn(Optional.empty());
		
		// When
		Throwable thrown = catchThrowable(() -> {
			artifactService.findById("12345");
		});
		
		// Then
		assertThat(thrown).isInstanceOf(ResourceNotFoundException.class).hasMessage("Artifact not found.");
		
		verify(artifactRepository, times(1)).findById("12345");
	}

}
