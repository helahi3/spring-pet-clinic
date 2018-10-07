package com.hamza.springpetclinic.boostrap;

import com.hamza.springpetclinic.model.Owner;
import com.hamza.springpetclinic.model.Pet;
import com.hamza.springpetclinic.model.PetType;
import com.hamza.springpetclinic.model.Vet;
import com.hamza.springpetclinic.services.OwnerService;
import com.hamza.springpetclinic.services.PetTypeService;
import com.hamza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Daniyal");
        owner1.setLastName("Rana");
        owner1.setAddress("55 Isabella");
        owner1.setCity("Toronto");
        owner1.setTelephone("12345678");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.now());
        pet1.setName("Rosco");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Zain");
        owner2.setLastName("Ali");
        owner2.setAddress("33 Isabella");
        owner2.setCity("Toronto");
        owner2.setTelephone("87654321");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("oscar");
        owner1.getPets().add(pet1);

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
