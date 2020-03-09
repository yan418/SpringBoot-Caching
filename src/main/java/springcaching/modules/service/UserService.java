package springcaching.modules.service;

import springcaching.modules.entities.User;

import java.util.List;

public interface UserService{

    User get(Integer id);

    User save(User user);

    Integer delete(Integer id);

}
