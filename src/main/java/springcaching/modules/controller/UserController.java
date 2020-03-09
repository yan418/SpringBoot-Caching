package springcaching.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcaching.modules.entities.Provider;
import springcaching.modules.entities.User;
import springcaching.modules.service.ProviderService;
import springcaching.modules.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")


    public User getUser(@PathVariable("id") Integer id) {
        User user = userService.get(id);
        return user;
    }

    @GetMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Integer id){

        User user = new User();
        user.setId(id);
        user.setRealName("www");
        user.setUsername("zzz");
        userService.save(user);
        if(id<=0){
            user.setRealName("IP不合法");
            return user;
        }
        userService.save(user);
        return user;
    }

    @GetMapping("/delete/{id}")
    public Integer deleteUser(@PathVariable("id") Integer id) {
        if(id<=0){
            return id=0;
        }
        userService.delete(id);
        return id;
    }


}
