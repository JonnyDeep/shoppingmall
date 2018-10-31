package cn.hlq.common.utils.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class CustomerSessionListener implements SessionListener{
    public void onStart(Session session) {
        System.out.println("session create:"+session.getId());
    }

    public void onStop(Session session) {
        System.out.println("session stop:"+session.getId());
    }

    public void onExpiration(Session session) {
        System.out.println("session Expir:"+session.getId());
    }
}
