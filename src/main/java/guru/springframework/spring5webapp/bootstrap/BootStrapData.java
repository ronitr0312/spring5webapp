package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Author eric = new Author("Eric","Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    Publisher publisher = new Publisher();
    publisher.setName("Demo");
    publisher.setAddressLine1("murbad rd");
    publisher.setCity("kaluan");
    publisher.setState("Maharashtra");
    publisher.setZip("421301");

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    publisher.getBooks().add(ddd);

    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisherRepository.save(publisher);

    Author rod = new Author("Rod","Johnson");
    Book noEJB = new Book("J2EE Developer without EJB",  "2327341");

    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    publisher.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(publisher);

    System.out.println("Started in BootStrap");
    System.out.println("number of Books : "+bookRepository.count());
    System.out.println("number of Publisher : "+publisherRepository.count());
    System.out.println("number of books with publisher : "+publisher.getBooks().size());


  }
}
