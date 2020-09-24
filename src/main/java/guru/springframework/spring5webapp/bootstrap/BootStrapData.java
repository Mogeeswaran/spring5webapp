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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher();
        publisher1.setName("Kinos");
        publisher1.setAddressLine1("dublin");
        publisher1.setCity("dublin");
        publisher1.setState("Ireland");
        publisher1.setZip("123456");
        publisherRepository.save(publisher1);

        System.out.println("Stated Spring Boot Application");
        System.out.println("Publisher Count: "+ publisherRepository.count());

        Author mogee = new Author("Mogee","Zaveeth");
        Book ddd = new Book("Domain Knowledge", "123123");
        mogee.getBooks().add(ddd);
        ddd.getAuthors().add(mogee);
        ddd.setPublisher(publisher1);
        publisher1.getBooks().add(ddd);

        authorRepository.save(mogee);
        bookRepository.save(ddd);
        publisherRepository.save(publisher1);

        Author zaveeth = new Author("Surya","Suganya");
        Book zzz = new Book("Family Knowledge", "15653156");
        zaveeth.getBooks().add(zzz);
        zzz.getAuthors().add(zaveeth);
        zzz.setPublisher(publisher1);
        publisher1.getBooks().add(zzz);

        authorRepository.save(zaveeth);
        bookRepository.save(zzz);
        publisherRepository.save(publisher1);



        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Publisher Number of Books: "+ publisher1.getBooks().size());

    }
}
