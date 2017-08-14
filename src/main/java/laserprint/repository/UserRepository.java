package laserprint.repository;

import laserprint.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nhkha on 25/03/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByToken(String token);
    User findByUserName(String userName);
    User findById(int id);
}
