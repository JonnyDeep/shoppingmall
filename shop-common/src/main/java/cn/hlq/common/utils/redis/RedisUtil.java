package cn.hlq.common.utils.redis;

import cn.hlq.common.utils.Exception.CustomException;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class RedisUtil {
    RedisTemplate<String,Object> redisTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }

    /**
     * String 类型获取缓存
     * @param key
     * @return
     */
    public Object get(String key){

        return key==null?null:redisTemplate.opsForValue().get(key);
    }

   public boolean set(String key,Object value,long exprieTime) throws  Exception
    {
        try{
            if(key!=null&&null!=value){
                System.out.println("key---:"+key);
                redisTemplate.opsForValue().set(key,value);
                return true;

            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new CustomException("存储redis出错");
        }
        return false;
    }

    public void deleteByKey(String key)
    {
        if(key!=null){
            redisTemplate.delete(key);
        }
    }

    public Collection<Object> allSession(String patter){
        Set<String> keys = redisTemplate.keys(patter);
        Collection<Object> values = new ArrayList<Object>();
        for (String key :
                keys) {
            values.add(get(key));
        }
        return values;
    }
}
