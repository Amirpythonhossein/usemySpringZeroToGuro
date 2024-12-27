package guru.springframework.spring_6_webapp.bootstrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);


        Author ferdosi = new Author();
        ferdosi.setLastName("Ferdosi");
        ferdosi.setLastName("Ferdosiani");

        Book shahnameh = new Book();
        shahnameh.setTitle("ashar no");
        shahnameh.setIsbn("246810");

        Author ferdosiSaved = authorRepository.save(ferdosi);
        Book shahnamehSaved = bookRepository.save(shahnameh);


        ericSaved.getBooks().add(dddSaved);
        ferdosiSaved.getBooks().add(shahnamehSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(ferdosiSaved);

        System.out.println(" In Bootstrap");
        System.out.println("The num of Authors is " + authorRepository.count());
        System.out.println("The nums of Boks is " + bookRepository.count());
    }
}
