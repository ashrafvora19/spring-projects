package com.example.hogwarts.dtos;

import jakarta.validation.constraints.NotEmpty;

public record ArtifactsDtoRecord(
		@NotEmpty
		String name,
		
		@NotEmpty
		String description,
		
		@NotEmpty
		String imageUrl
		) {

}
