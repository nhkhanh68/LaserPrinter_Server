package laserprint.repository;

import laserprint.model.LogTien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogTienRepository extends CrudRepository<LogTien, Integer>{
    List<LogTien> findByStudentId(int id);
}
