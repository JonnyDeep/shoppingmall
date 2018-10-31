package cn.hlq.common.utils.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;


/**
 * @author huangliqun
 */
public interface SessionRepository {

    /**
     * 保存session
     * @param session
     */
    void saveSession(Session session);

    /**
     * 删除session
     * @param sessionId
     */
    void deleteSession(Serializable sessionId);

    /**
     * 获得session
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);


    /**
     * 获得所有session
     * @return
     */
    Collection<Session> getAllSessions();
}
