package com.example.hogwarts.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hogwarts.exceptions.ResourceNotFoundException;
import com.example.hogwarts.models.Artifact;
import com.example.hogwarts.services.ArtifactService;

@SpringBootTest
@AutoConfigureMockMvc
class ArtifactControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ArtifactService artifactService;
	
	@InjectMocks
	ArtifactControllerTest artifactController;
	
	List<Artifact> artifacts;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		artifacts = new ArrayList<>();

		Artifact artifact = new Artifact();
		artifact.setId("12345");
		artifact.setName("Invisibility Cloak");
		artifact.setDescription("Make wearer invisible.");
		artifact.setImageUrl("ImageUrl");
		artifacts.add(artifact);
		
		artifact = new Artifact();
		artifact.setId("223345");
		artifact.setName("Elder Wand");
		artifact.setDescription("Manipulate magic more easily.");
		artifact.setImageUrl("ImageUrl");
		artifacts.add(artifact);
		
		artifact = new Artifact();
		artifact.setId("789761");
		artifact.setName("Gryffin Sword");
		artifact.setDescription("Sword of Gryffin rider.");
		artifact.setImageUrl("ImageUrl");
		artifacts.add(artifact);
		
		artifact = new Artifact();
		artifact.setId("559563");
		artifact.setName("Marauder's Map");
		artifact.setDescription("Magical map create by Hogwart.");
		artifact.setImageUrl("ImageUrl");
		artifacts.add(artifact);
		
		artifact = new Artifact();
		artifact.setId("9785445");
		artifact.setName("Resurrection Stone");
		artifact.setDescription("Resurrect at random time.");
		artifact.setImageUrl("ImageUrl");
		artifacts.add(artifact);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindArtifactByIdSuccess() throws Exception {
		BDDMockito.given(artifactService.findById("12345")).willReturn(artifacts.get(0));
		
		this.mockMvc.perform(get("/api/v1/artifacts/12345").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.flag").value(true))
			.andExpect(jsonPath("$.code").value(HttpStatus.OK.value()))
			.andExpect(jsonPath("$.message").value("Success"))
			.andExpect(jsonPath("$.data.id").value("12345"))
			.andExpect(jsonPath("$.data.name").value("Invisibility Cloak"));
			
	}

	@Test
	void testFindArtifactByIdNotFound() throws Exception {
		BDDMockito.given(artifactService.findById("12345")).willThrow(new ResourceNotFoundException("Artifact not found."));
		
		this.mockMvc.perform(get("/api/v1/artifacts/12345").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.flag").value(false))
			.andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
			.andExpect(jsonPath("$.message").value("Artifact not found."))
			.andExpect(jsonPath("$.data").isEmpty());
			
	}

}
