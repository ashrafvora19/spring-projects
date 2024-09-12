package com.example.hogwarts.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.hogwarts.dtos.ArtifactsDtoRecord;
import com.example.hogwarts.models.Artifact;

@Mapper(componentModel = "spring")
public interface ArtifactMapper {

	ArtifactsDtoRecord toDto(Artifact artifact);
	
	List<ArtifactsDtoRecord> toDto(List<Artifact> artifact);

	Artifact toEntity(ArtifactsDtoRecord artifact);
	
	List<Artifact> toEntity(List<ArtifactsDtoRecord> artifact);
	
}
