package com.hamza.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PetType extends BaseEntity {

    @Column(name = "name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
