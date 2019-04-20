package guru.springframework.spring5WebApplication.Model.repositories;

import guru.springframework.spring5WebApplication.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
