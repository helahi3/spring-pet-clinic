package com.hamza.springpetclinic.boostrap;

import com.hamza.springpetclinic.model.*;
import com.hamza.springpetclinic.services.OwnerService;
import com.hamza.springpetclinic.services.PetTypeService;
import com.hamza.springpetclinic.services.SpecialityService;
import com.hamza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            loadData();


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadio = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentist = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

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
        vet1.getSpecialities().add(savedRadio);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Safder");
        vet2.setLastName("Haider");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }
}
