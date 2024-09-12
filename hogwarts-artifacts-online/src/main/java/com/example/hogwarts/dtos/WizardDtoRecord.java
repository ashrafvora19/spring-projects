package com.example.hogwarts.dtos;

import jakarta.validation.constraints.NotEmpty;

public record WizardDtoRecord(
		@NotEmpty
		String name
		) {

}
