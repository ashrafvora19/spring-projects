package com.example.hogwarts.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.hogwarts.models.Artifact;
import com.example.hogwarts.models.Wizard;
import com.example.hogwarts.repositories.ArtifactRepository;
import com.example.hogwarts.repositories.WizardRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DBDataKInitializer implements CommandLineRunner {
	
	private final ArtifactRepository artifactRepository;
	
	private final WizardRepository wizardRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Artifact a1 = new Artifact();
        a1.setId("0254464");
        a1.setName("Deluminator");
        a1.setDescription("A Deluminator is a device that resembles a cigarette lighter.");
        a1.setImageUrl("ImageUrl");
		
		Artifact artifact1 = new Artifact();
		artifact1.setId("12345");
		artifact1.setName("Invisibility Cloak");
		artifact1.setDescription("Make wearer invisible.");
		artifact1.setImageUrl("ImageUrl");
		
		Artifact artifact2 = new Artifact();
		artifact2.setId("223345");
		artifact2.setName("Elder Wand");
		artifact2.setDescription("Manipulate magic more easily.");
		artifact2.setImageUrl("ImageUrl");
		
		Artifact artifact3 = new Artifact();
		artifact3.setId("789761");
		artifact3.setName("Gryffin Sword");
		artifact3.setDescription("Sword of Gryffin rider.");
		artifact3.setImageUrl("ImageUrl");
		
		Artifact artifact4 = new Artifact();
		artifact4.setId("559563");
		artifact4.setName("Marauder's Map");
		artifact4.setDescription("Magical map create by Hogwart.");
		artifact4.setImageUrl("ImageUrl");
		
		Artifact artifact5 = new Artifact();
		artifact5.setId("9785445");
		artifact5.setName("Resurrection Stone");
		artifact5.setDescription("Resurrect at random time.");
		artifact5.setImageUrl("ImageUrl");
		
		Wizard wizard1 = new Wizard();
		wizard1.setId(1L);
		wizard1.setName("Albus Dumbldore");
		wizard1.addArtifact(a1);
		wizard1.addArtifact(artifact2);
		
		Wizard wizard2 = new Wizard();
		wizard2.setId(2L);
		wizard2.setName("Harry Potter");
		wizard2.addArtifact(artifact1);
		wizard2.addArtifact(artifact3);
		
		Wizard wizard3 = new Wizard();
		wizard3.setId(3L);
		wizard3.setName("Neville Longbottom");
		wizard3.addArtifact(artifact4);
		
		wizardRepository.save(wizard1);
		wizardRepository.save(wizard2);
		wizardRepository.save(wizard3);
		artifactRepository.save(artifact5);
	}

}
