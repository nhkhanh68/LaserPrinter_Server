package laserprint.repository;

import laserprint.model.HealthRecords;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HealthRecordsRepository extends CrudRepository<HealthRecords, Integer> {
    List<HealthRecords> findAll();
    List<HealthRecords> findByPatientId(int id);
}
