
package springcaching.modules.dao;

import springcaching.modules.entities.Provider;
import springcaching.modules.entities.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(Integer id);

    int updateUser(User user);

    int deleteUser(Integer id);

}
