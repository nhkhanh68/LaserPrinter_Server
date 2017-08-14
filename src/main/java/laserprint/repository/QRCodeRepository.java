package laserprint.repository;

import laserprint.model.QRCode;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nhkha on 8/14/2017.
 */
public interface QRCodeRepository extends CrudRepository<QRCode, Integer> {

}
