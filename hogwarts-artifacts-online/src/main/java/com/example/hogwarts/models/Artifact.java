package com.example.hogwarts.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Artifact implements Serializable {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	@JsonManagedReference
	private Wizard owner;
}
