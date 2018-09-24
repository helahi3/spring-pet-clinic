package com.hamza.springpetclinic.services;

import com.hamza.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long> {


    Owner findByLastName(String lastName);

}
