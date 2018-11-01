package cn.hlq.common.utils.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import java.util.logging.Logger;

public class CustomerCacheManager implements CacheManager,Destroyable {

    private static Logger logger = Logger.getLogger(CustomerCacheManager.class.getName());

    private org.springframework.cache.CacheManager cacheManager;

    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        logger.info("acquiring cache instance name ["+s+"]");
        org.springframework.cache.Cache cache = cacheManager.getCache(s);
        return new CustomerCache<K, V>(cache);
    }

    public void destroy() throws DestroyFailedException {
        cacheManager = null;
    }

}
