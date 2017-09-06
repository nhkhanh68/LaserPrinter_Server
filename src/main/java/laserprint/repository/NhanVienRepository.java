package laserprint.repository;

import laserprint.model.NhanVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends CrudRepository<NhanVien, Integer>{
    NhanVien findByMaNhanVien(String s);
    NhanVien findById(int id);
}
