package laserprint.repository;

import laserprint.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nhkha on 8/14/2017.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findById(int id);
    List<Book> findAll();
}
