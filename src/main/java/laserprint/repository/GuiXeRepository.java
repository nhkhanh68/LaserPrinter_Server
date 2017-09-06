package laserprint.repository;

import laserprint.model.GuiXe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiXeRepository extends CrudRepository<GuiXe, Integer> {
    GuiXe findTopByStudentIdAndCheckinIsNotNullAndCheckoutIsNull(int id);
}
