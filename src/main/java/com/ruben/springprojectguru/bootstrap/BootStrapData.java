package com.ruben.springprojectguru.bootstrap;

import com.ruben.springprojectguru.domain.Author;
import com.ruben.springprojectguru.domain.Book;
import com.ruben.springprojectguru.domain.Publisher;
import com.ruben.springprojectguru.repositories.AuthorRepository;
import com.ruben.springprojectguru.repositories.BookRepository;
import com.ruben.springprojectguru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    //denpendecie injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Amazon");
        publisher.setCity("Turnhout");
        publisher.setState("Belgium");

        publisherRepository.save(publisher);


        System.out.println("Publisher Count: " + publisherRepository.count());

        Author ruben = new Author("Ruben","Muanza");
        Book ddd = new Book("Domain Driven Design","346453");
        ruben.getBooks().add(ddd);// boeken toewijzwen aan de auteur
        ddd.getAuthors().add(ruben);// auteur van de boek toevoegen

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(ruben);//auteur opslaan in de H2-database
        bookRepository.save(ddd);// boek opslaan in de H2-database
        publisherRepository.save(publisher);

        Author gael = new Author("Gael", "Messiah");
        Book rd = new Book("Rich dad, Poor dad", "588674");
        gael.getBooks().add(rd);
        rd.getAuthors().add(gael);

        rd.setPublisher(publisher);
        publisher.getBooks().add(rd);
        authorRepository.save(gael);
        bookRepository.save(rd);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books " + publisher.getBooks().size());
    }
}
