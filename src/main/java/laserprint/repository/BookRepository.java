package laserprint.repository;

import laserprint.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nhkha on 8/14/2017.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findById(int id);
    List<Book> findAll();
}
