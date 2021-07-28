package com.example.spring5app.bootstrap;

import com.example.spring5app.domain.Author;
import com.example.spring5app.domain.Book;
import com.example.spring5app.domain.Publisher;
import com.example.spring5app.repositories.AuthorRepository;
import com.example.spring5app.repositories.BookRepository;
import com.example.spring5app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher tor = new Publisher();
        tor.setName("Tor Books");
        publisherRepository.save(tor);

        Publisher daw = new Publisher();
        daw.setName("DAW Books");
        publisherRepository.save(daw);

        Author patrick = new Author("Patrick", "Rothfuss");
        Book wind = new Book("Name Of The Wind", "123123");
        patrick.getBooks().add(wind);
        wind.getAuthors().add(patrick);
        wind.setPublisher(daw);

        authorRepository.save(patrick);
        bookRepository.save(wind);
        publisherRepository.save(daw);

        Author brandon = new Author("Brandon", "Sanderson");
        Book mistborn = new Book("Mistborn", "321321");
        brandon.getBooks().add(mistborn);
        mistborn.getAuthors().add(brandon);
        mistborn.setPublisher(tor);

        authorRepository.save(brandon);
        bookRepository.save(mistborn);
        publisherRepository.save(tor);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
