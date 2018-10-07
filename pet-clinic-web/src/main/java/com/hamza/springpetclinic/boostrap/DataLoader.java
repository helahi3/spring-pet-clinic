package com.hamza.springpetclinic.boostrap;

import com.hamza.springpetclinic.model.Owner;
import com.hamza.springpetclinic.model.PetType;
import com.hamza.springpetclinic.model.Vet;
import com.hamza.springpetclinic.services.OwnerService;
import com.hamza.springpetclinic.services.PetTypeService;
import com.hamza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Daniyal");
        owner1.setLastName("Rana");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Zain");
        owner2.setLastName("Ali");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Owais");
        vet1.setLastName("Khan");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Safder");
        vet2.setLastName("Haider");

        vetService.save(vet2);


    }
}
