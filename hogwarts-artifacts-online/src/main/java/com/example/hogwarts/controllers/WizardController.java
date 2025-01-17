package com.example.hogwarts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hogwarts.dtos.Result;
import com.example.hogwarts.dtos.WizardDtoRecord;
import com.example.hogwarts.models.Wizard;
import com.example.hogwarts.services.WizardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("${api.endpoint.base-url}/wizards")
public class WizardController {
	
	private final WizardService wizardService;
	
	@GetMapping("/{wizard-id}")
	public Result findWizardById(@PathVariable("wizard-id") Long wizardId) {
		Wizard wizard = wizardService.findById(wizardId);
		return new Result(true, HttpStatus.OK.value(), "Success", wizard);
	}
	
	@PostMapping
	public Result findWizardById(@RequestBody WizardDtoRecord wizardDto) {
		Wizard wizard = wizardService.addWizard(wizardDto);
		return new Result(true, HttpStatus.OK.value(), "Success", wizard);
	}
	
	@DeleteMapping("/{wizard-id}")
	public Result deleteWizardById(@PathVariable("wizard-id") Long wizardId) {
		wizardService.deleteWizardById(wizardId);
		return new Result(true, HttpStatus.OK.value(), "Success", null);
	}

}
