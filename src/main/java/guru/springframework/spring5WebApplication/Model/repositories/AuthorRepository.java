package guru.springframework.spring5WebApplication.Model.repositories;

import guru.springframework.spring5WebApplication.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
