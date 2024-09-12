package com.example.hogwarts.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.hogwarts.dtos.WizardDtoRecord;
import com.example.hogwarts.models.Wizard;

@Mapper(componentModel = "spring")
public interface WizardMapper {

	WizardDtoRecord toDto(Wizard wizard);
	
	Wizard toEntity(WizardDtoRecord wizaDto);
	
	Iterable<WizardDtoRecord> toDto(Iterable<Wizard> wizard);
	
	Iterable<Wizard> toEntity(Iterable<WizardDtoRecord> wizardDto);
}
