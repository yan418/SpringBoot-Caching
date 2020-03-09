package springcaching.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springcaching.modules.dao.UserDao;
import springcaching.modules.entities.User;
import springcaching.modules.service.UserService;

//指定缓存公共属性值
@CacheConfig(cacheNames="user")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    //Cacheable 查询缓存设置 参数，cacheNames 缓存名，key key的名字  unless 不缓存null值
    @Cacheable(key = "#id",unless="#result == null")
    @Override
    public User get(Integer id) {
        User user = userDao.getUserById(id);
        System.out.println(user);
        return user;
    }

    //更新缓存  需要有返回值
    @CachePut(key="#result.id",unless="#result == null")
    @Override
    public User save(User user) {

        int row = userDao.updateUser(user);
        if(row!=1){
            throw new RuntimeException("修改失败");
        }
        return  user;
    }

    //清楚缓存 参数还有有 allEntries=true 清空全部的缓存
    // allEntries = true 会将缓存中的所有数据清空
    // beforeInvocation = true， 为true的时候会先调用缓存清空
    @CacheEvict(key="#id", allEntries = true/*, beforeInvocation = true*/)
    @Override
    public Integer delete(Integer id) {
        int row = userDao.deleteUser(id);
        if(row!=1){
            throw new RuntimeException("删除失败");
        }

        return id;
    }
}
