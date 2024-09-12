package com.example.hogwarts.services;

import org.springframework.stereotype.Service;

import com.example.hogwarts.dtos.WizardDtoRecord;
import com.example.hogwarts.exceptions.ResourceNotFoundException;
import com.example.hogwarts.mappers.WizardMapper;
import com.example.hogwarts.models.Wizard;
import com.example.hogwarts.repositories.WizardRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WizardService {
	
	private final WizardRepository wizardRepository;
	private final WizardMapper wizardMapper;
	
	public Wizard findById(Long id) {
		return wizardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wizard not found."));
	}
	
	public Wizard addWizard(WizardDtoRecord wizardDto) {
		return wizardRepository.save(wizardMapper.toEntity(wizardDto));
	}

}
