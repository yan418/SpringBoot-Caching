package springcaching.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;


//配置 Redis缓存，存JSON格式进行存储
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setConnectionFactory(redisConnectionFactory);

        return template;
    }

}

/**
 * //针对 的都是操作字符串
 *
 *   StringRedisTemplate stringRedisTemplate;
 *   五大数据类型
 *         stringRedisTemplate.opsForValue();//操作字符串
 *         stringRedisTemplate.opsForList();//操作List
 *         stringRedisTemplate.opsForSet();//操作Set
 *         stringRedisTemplate.opsForZSet();//操作ZSet
 *         stringRedisTemplate.opsForHash();//操作Hash
 */