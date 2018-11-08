package cn.hlq.common.utils.session;

import cn.hlq.common.utils.redis.RedisUtil;
import cn.hlq.common.utils.SerializeUtil;
import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class MyJedisShiroSessionRepository implements SessionRepository {

    public static final String REDIS_SHIRO_SESSION = "json_shiro_session:";
    public static final String STRING_SHIRO_ALL = "json_shiro_session:*";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    private static final int DB_INDEX = 1;
    private RedisUtil redisUtil;
    private static Logger logger = Logger.getLogger(MyJedisShiroSessionRepository.class.getName());
    public void saveSession(Session session) {
        if(session==null||session.getId()==null){
            throw new NullPointerException("session is empty");
        }

        try{
            String key = buildRedisSessionKey(session.getId());
            byte[] value = SerializeUtil.serializeObject(session);
            logger.info("---->session:"+session);
            long sessionTimeOut = session.getTimeout()/1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5*60);
            getRedisUtil().set(key,value,expireTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteSession(Serializable sessionId) {
        if(sessionId==null){
            throw new NullPointerException("session id is empty");
        }
        try {
            getRedisUtil().deleteByKey(buildRedisSessionKey(sessionId));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Session getSession(Serializable sessionId) {
        if(sessionId==null){
            throw new NullPointerException("session id is empty");
        }
        Session session = null;
        try {
            byte[] value = (byte [])getRedisUtil().get(buildRedisSessionKey(sessionId));
            session = (Session)SerializeUtil.deserializeObject(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return session;
    }

    public Collection<Session> getAllSessions() {
       Collection<Object> objs = getRedisUtil().allSession(STRING_SHIRO_ALL);
       Collection<Session> retVal = new ArrayList<Session>();
        for (Object obj :
                objs) {
            byte[] value =(byte[])obj;
            retVal.add((Session)SerializeUtil.deserializeObject(value));
        }
        return retVal;
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    private String buildRedisSessionKey(Serializable sessionId){
        return REDIS_SHIRO_SESSION+sessionId;
    }


}
