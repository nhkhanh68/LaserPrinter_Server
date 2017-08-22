package laserprint.repository;

import laserprint.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    Patient findById(int id);
    List<Patient> findAll();
    Patient findByPatientCode(String code);
}
