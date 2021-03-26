package com.myfirstspringproject.spring5webapp.bootstrap;

import com.myfirstspringproject.spring5webapp.domain.Author;
import com.myfirstspringproject.spring5webapp.domain.Book;
import com.myfirstspringproject.spring5webapp.domain.Publisher;
import com.myfirstspringproject.spring5webapp.repositories.AuthorRepository;
import com.myfirstspringproject.spring5webapp.repositories.BookRepository;
import com.myfirstspringproject.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;



    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design","12334343");
        Publisher ppp = new Publisher("itit","38 element route");

        publisherRepository.save(ppp);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublishers(ppp);
        ppp.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(ppp);




        Author rod = new Author("Rod","Jhonson");
        Book noEJB= new Book("J2EE Development without EJB","18657656");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        ppp.getBooks().add(noEJB);
        noEJB.setPublishers(ppp);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(ppp);

        System.out.println("Started in Bootsrap");
        System.out.println("Number of Books  "+ bookRepository.count() + "Number of Publishers "+ publisherRepository.count() + " number of books in this publisher "+ppp.getBooks().size());

    }
}
