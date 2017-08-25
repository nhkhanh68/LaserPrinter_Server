package laserprint.repository;

import laserprint.model.BookStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nhkha on 8/14/2017.
 */
@Repository
public interface BookStudentRepository  extends CrudRepository<BookStudent, Integer> {
    List<BookStudent> findAll();
    List<BookStudent> findByStudentId (int id);
}
