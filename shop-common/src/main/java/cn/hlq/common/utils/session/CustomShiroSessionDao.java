package cn.hlq.common.utils.session;

import cn.hlq.common.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

public class CustomShiroSessionDao extends AbstractSessionDAO {
    private MyJedisShiroSessionRepository jedisShiroSessionRepository;

    public MyJedisShiroSessionRepository getJedisShiroSessionRepository() {
        return jedisShiroSessionRepository;
    }

    public void setJedisShiroSessionRepository(MyJedisShiroSessionRepository jedisShiroSessionRepository) {
        this.jedisShiroSessionRepository = jedisShiroSessionRepository;
    }

    protected Serializable doCreate(Session session) {
        Serializable sessionId = session.getId();
        this.assignSessionId(session,sessionId);
        getJedisShiroSessionRepository().saveSession(session);
        return sessionId;
    }

    protected Session doReadSession(Serializable sessionId) {
        return getJedisShiroSessionRepository().getSession(sessionId);
    }

    public void update(Session session) throws UnknownSessionException {
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
