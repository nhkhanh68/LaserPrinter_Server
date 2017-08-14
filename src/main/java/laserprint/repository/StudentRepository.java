package laserprint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import laserprint.model.Student;

import java.util.List;


/**
 * Created by Tu on 20-May-16.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {
    Student findById(int id);
    List<Student> findByFullNameContaining(String studentName);
    Student findByStudentCode(String studentCode);
}