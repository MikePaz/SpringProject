package com.spring.services;

import com.spring.model.Owner;

public interface OwnerService extends CrudService<Owner , Long>  {
    Owner findByLastName(String lastName);
}
