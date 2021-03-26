package com.myfirstspringproject.spring5webapp.repositories;

import com.myfirstspringproject.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
