package cn.hlq;

import cn.hlq.common.utils.SerializeUtil;
import cn.hlq.common.utils.redis.RedisManager;
import cn.hlq.common.utils.redis.RedisUtil;
import com.github.pagehelper.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.jws.Oneway;
import java.io.Serializable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-redis.xml"})
public class TestRedis {

    @Autowired
    protected ApplicationContext ctx;


    @Test
    public void test() throws Exception {

//        RedisTemplate<String,String> redisTemplate = (RedisTemplate)ctx.getBean("redisTemplate");
        System.out.println("hello");
//        RedisUtil redisUtil = (RedisUtil)ctx.getBean("redisUtil") ;
//        redisUtil.set("redisUtilTest","redis",100);
//        String value=(String)redisUtil.get("redisUtilTest");
//        System.out.println(value);
//        RedisManager redisManager = new RedisManager();
//        redisManager.init();
//        redisManager.set(SerializeUtil.serializeObject("hello"),SerializeUtil.serializeObject("just test"));
//        System.out.println("ok");
    }

}
