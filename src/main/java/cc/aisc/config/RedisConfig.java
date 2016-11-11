package cc.aisc.config;

import cc.aisc.commons.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by sjf on 16-3-28.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Bean(name = "redisKeyGenerator")
    public KeyGenerator redisKeyGenerator(){
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            Class cls = getGenericType(o.getClass());
            sb.append(cls != null ? cls.getName() + "-" : "");
            sb.append(method.getName());
            for (Object obj : objects) {
                if (null != obj) {
                    sb.append("-");
                    sb.append(obj.toString());
                }
            }
            LOGGER.info("redis key = {}",sb.toString());
            //return StringUtils.textToMD5L32(sb.toString());
            return sb.toString();
        };
    }

    @SuppressWarnings("unchecked")
    private Class getGenericType(Class cls) {
        Type[] types = cls.getGenericInterfaces();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType t = (ParameterizedType) type;
                return (Class) t.getActualTypeArguments()[0];
            } else if (type instanceof Class) {
                return getGenericType((Class) type);
            }
        }
        return null;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxWaitMillis(30000);
        jpc.setMaxIdle(100);
        jpc.setTestOnBorrow(true);
        jpc.setTestOnReturn(true);
        return jpc;
    }

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setPoolConfig(jedisPoolConfig());
        return factory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        /*Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();*/
        return template;
    }

    @Bean(name = "cacheManager")
    public CacheManager cacheManager(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(1000);//10s
        return cacheManager;
    }

}
