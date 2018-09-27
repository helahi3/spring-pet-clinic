package com.hamza.springpetclinic.boostrap;

import com.hamza.springpetclinic.model.Owner;
import com.hamza.springpetclinic.model.Vet;
import com.hamza.springpetclinic.services.OwnerService;
import com.hamza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Daniyal");
        owner1.setLastName("Rana");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Zain");
        owner2.setLastName("Ali");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Owais");
        vet1.setLastName("Khan");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Safder");
        vet2.setLastName("Haider");

        vetService.save(vet2);


    }
}
