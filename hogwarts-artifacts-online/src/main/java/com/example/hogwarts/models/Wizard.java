package com.example.hogwarts.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wizard implements Serializable {

	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonBackReference
	private List<Artifact> artifacts = new ArrayList<>();

	public void addArtifact(Artifact artifact) {
		artifacts.add(artifact);
		artifact.setOwner(this);
	}
}
