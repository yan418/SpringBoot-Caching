package springcaching;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//缓存
@EnableCaching
//事务管理
@EnableTransactionManagement
//会自动 装配指定包下面所有Mapper，省得在每个Mapper上面写@Mapper
@MapperScan("springcaching.modules.dao")
@SpringBootApplication
public class CachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachingApplication.class, args);
    }

}
