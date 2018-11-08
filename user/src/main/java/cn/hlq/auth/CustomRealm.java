package cn.hlq.auth;

import cn.hlq.common.pojo.Customer;
import cn.hlq.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class CustomRealm extends AuthorizingRealm {

    private static Logger logger = LogManager.getLogger(CustomRealm.class);
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Autowired
    CustomerService customerService;

    @Autowired
    DefaultWebSecurityManager securityManager;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("--------授权-------");
        //添加用户权限和角色
        String userName = (String) principalCollection.getPrimaryPrincipal();
        List<String> permessionList = new ArrayList<String>();
        permessionList.add("user:add");
        permessionList.add("user:delete");
        if(userName.equals("zhou"))
        {
            permessionList.add("user:query");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permessionList);
        info.addRole("customer");
        permessionList.stream().forEach(i-> logger.info(i));
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("------认证-----");
        String userName = (String)authenticationToken.getPrincipal();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        logger.info("-->sessionDao:"+sessionManager.getSessionDAO().getClass());
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
        for(Session session:sessions)
        {
            logger.info("----> userName:{}",session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
            if(userName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))){
                sessionManager.getSessionDAO().delete(session);
            }
        }
        if("".equals(userName))
        {
            return null;
        }
        Customer temp = new Customer();
        temp.setUsername(userName);
        temp = customerService.queryCustomerByUserName(temp);

        if(temp!=null){
            logger.info("----> save sesseion to shiro:");

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,temp.getPassword(),this.getName());
            return info;
        }else {
            throw new UnknownAccountException();
        }

    }
}
