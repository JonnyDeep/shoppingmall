package cn.hlq.auth;

import cn.hlq.common.pojo.Customer;
import cn.hlq.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("--------授权-------");
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
        if("".equals(userName))
        {
            return null;
        }
        Customer temp = new Customer();
        temp.setUsername(userName);
        temp = customerService.queryCustomerByUserName(temp);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,temp.getPassword(),this.getName());
        return info;
    }
}
