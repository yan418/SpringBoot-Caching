package springcaching.modules.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcaching.modules.dao.ProviderDao;
import springcaching.modules.entities.Provider;
import springcaching.modules.service.ProviderService;
import springcaching.utils.RedisClient;

import java.util.Date;
import java.util.List;



@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderDao providerDao;

    //封装的redis类
    @Autowired
    RedisClient redisClient;

    @Override
    public List<Provider> getAll() {
        List<Provider> list = providerDao.getProviders();
        return list;
    }

    //查询
    @Override
    public Provider provider(Integer pid) {

        //缓存名
        String name = "provider" + pid;
        //查询一下缓存中是否有数据
        //Object obj = redisClient.get(name);
        Object obj = redisClient.get(name);
        if(obj != null){
            return (Provider) obj;
        }

        //数据库查询
        Provider p = providerDao.getProviderByPid(pid);
        //参数，缓存名、值、缓存时长，秒为单位
        boolean set = redisClient.set(name, p);
        return p;

    }

    //更新缓存
    @Override
    public void save(Provider provider) {

        if(provider==null){
            throw new RuntimeException("provider不能为空");
        }
        provider.setCreateDate(new Date());
        int row = providerDao.updateProvider(provider);
        if(row!=1){
            throw new RuntimeException("修改失败");
        }
        //更新缓存
        //缓存名
        String name = "provider" + provider.getPid();
        redisClient.set(name,provider);
    }

    //事务管理
    @Transactional
    @Override
    public void add(Provider provider) {

        //模拟事务管理
        if(provider.getProviderName().equals("333")){
            throw new RuntimeException("增加失败");
        }

        int row = providerDao.addProvider(provider);
        if(row!=1){
            throw new RuntimeException("增加失败");
        }
    }


    //删除
    @Override
    public void delete(Integer pid) {
        int row=providerDao.deleteProviderByPid(pid);
        if(row!=1){
            throw new RuntimeException("删除失败");
        }
        //删除缓存
        //缓存名
        String name = "provider" + pid;
        redisClient.del(name);
    }

}
