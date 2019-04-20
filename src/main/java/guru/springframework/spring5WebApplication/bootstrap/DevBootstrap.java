package guru.springframework.spring5WebApplication.bootstrap;

import guru.springframework.spring5WebApplication.Model.Author;
import guru.springframework.spring5WebApplication.Model.Book;
import guru.springframework.spring5WebApplication.Model.Publisher;
import guru.springframework.spring5WebApplication.Model.repositories.AuthorRepository;
import guru.springframework.spring5WebApplication.Model.repositories.BookRepository;
import guru.springframework.spring5WebApplication.Model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){
        Author eric = new Author("Eric","Evans");
        Publisher hc = new Publisher("Harper Collins","harper address");

        Book ddd = new Book("Domain Driven Design","1234",hc);
        eric.addBook(ddd);
        ddd.addAuthor(eric);

        ddd.setPublisher(hc);
        publisherRepository.save(hc);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Publisher worx = new Publisher("Worx","worx address");


        Author rod = new Author("Rod","Jhonson");
        Book noEJB = new Book("J2EE development without EJB","1235",worx);
        rod.addBook(noEJB);
        noEJB.addAuthor(rod);
        noEJB.addAuthor(eric);

        noEJB.setPublisher(worx);
        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }


}
