package cn.hlq.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DubboTest {
    private static Logger logger = LogManager.getLogger(DubboTest.class.getName());

    @Test
    public void testTestService() throws IOException {
        logger.info("服务提供者已经注册成功");
        System.in.read();
    }



}
