package com.example.hogwarts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hogwarts.dtos.ArtifactsDtoRecord;
import com.example.hogwarts.dtos.Result;
import com.example.hogwarts.models.Artifact;
import com.example.hogwarts.services.ArtifactService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ArtifactController {

	private final ArtifactService artifactService;
	
	@GetMapping("/api/v1/artifacts/{artifact-id}")
	public Result findArtifactById(@PathVariable("artifact-id") String artifactId) {
		Artifact artifact = artifactService.findById(artifactId);
		return new Result(true, HttpStatus.OK.value(), "Success", artifact);
	}
	
	@PostMapping("/api/v1/artifacts")
	public Result findArtifactById(@RequestBody ArtifactsDtoRecord artifactDto) {
		Artifact artifact = artifactService.addArtifact(artifactDto);
		return new Result(true, HttpStatus.OK.value(), "Success", artifact);
	}
}
