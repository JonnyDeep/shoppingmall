package cn.hlq.common.utils.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Logger;

public class CustomerCache<K,V> implements org.apache.shiro.cache.Cache<K, V> {
    private static Logger logger = Logger.getLogger(CustomerCache.class.getName());
    private final org.springframework.cache.Cache cache;

    public CustomerCache(org.springframework.cache.Cache cache)
    {
        if(cache==null)
        {
            logger.info("cache null");
            throw new IllegalArgumentException("cache argument cannot null");
        }
        this.cache = cache;
    }


    public V get(K k) throws CacheException {
        logger.info("cache ["+this.cache.getName()+"] for key [ "+k+" ] key type:"+k.getClass());
        org.springframework.cache.Cache.ValueWrapper valueWrapper = cache.get(k);
        if(valueWrapper==null){
            logger.info("Elemet for ["+ k +" ] is nulll" );
            return null;
        }
        return (V) valueWrapper.get();
    }

    public V put(K k, V v) throws CacheException {
        logger.info("cache ["+this.cache.getName()+"] for key [ "+k+" ] key type:"+k.getClass());
        V previous = get(k);
        cache.put(k,v);
        return previous;
    }

    public V remove(K k) throws CacheException {
        logger.info("cache ["+this.cache.getName()+"] for key [ "+k+" ] key type:"+k.getClass());
        V previous = get(k);
        cache.evict(k);
        return previous;
    }

    public void clear() throws CacheException {
        logger.info("cache ["+this.cache.getName()+"]");
        cache.clear();
    }

    public int size() {
        return 0;
    }

    public Set<K> keys() {
        return Collections.emptySet();
    }

    public Collection<V> values() {
        return Collections.emptySet();
    }

    @Override
    public String toString() {
        return "ShiroRedisCache [" + this.cache.getName()+"]";
    }
}
