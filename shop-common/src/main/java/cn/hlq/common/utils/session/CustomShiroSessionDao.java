package cn.hlq.common.utils.session;

import cn.hlq.common.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.Collection;
import java.util.logging.Logger;

public class CustomShiroSessionDao extends AbstractSessionDAO {
    private static Logger logger = Logger.getLogger(CustomShiroSessionDao.class.getName());
    private MyJedisShiroSessionRepository jedisShiroSessionRepository;

    public MyJedisShiroSessionRepository getJedisShiroSessionRepository() {
        return jedisShiroSessionRepository;
    }

    public void setJedisShiroSessionRepository(MyJedisShiroSessionRepository jedisShiroSessionRepository) {
        this.jedisShiroSessionRepository = jedisShiroSessionRepository;
    }

    protected Serializable doCreate(Session session) {
        if(session==null){
            logger.info("session is null");
        }
        Serializable sessionId = generateSessionId(session);
        logger.info("doCreate session:"+sessionId);
        this.assignSessionId(session,sessionId);
        getJedisShiroSessionRepository().saveSession(session);
        return sessionId;
    }

    protected Session doReadSession(Serializable sessionId) {

        logger.info("----->read session:");
        Session session = getJedisShiroSessionRepository().getSession(sessionId);
        if(session==null){

        }
        return session;
    }

    public void update(Session session) throws UnknownSessionException {
        logger.info("-----> update session");
        getJedisShiroSessionRepository().saveSession(session);
    }

    public void delete(Session session) {
        if(session==null){
            return;
        }
        Serializable id = session.getId();
        if(id!=null){
            getJedisShiroSessionRepository().deleteSession(id);
        }
    }

    public Collection<Session> getActiveSessions() {
        return getJedisShiroSessionRepository().getAllSessions();
    }
}
