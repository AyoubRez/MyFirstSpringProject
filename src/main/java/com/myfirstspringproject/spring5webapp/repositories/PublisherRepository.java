package com.myfirstspringproject.spring5webapp.repositories;

import com.myfirstspringproject.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
