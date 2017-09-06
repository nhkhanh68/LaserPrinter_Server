package laserprint.repository;

import laserprint.model.CheckIn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheckInRepository extends CrudRepository<CheckIn, Integer> {
    CheckIn findByNhanVienIdAndNgay(int id, String s);
    List<CheckIn> findByNhanVienId(int id);
    List<CheckIn> findByNgay(String s);
}
