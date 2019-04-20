package guru.springframework.spring5WebApplication.Model.repositories;

import guru.springframework.spring5WebApplication.Model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
