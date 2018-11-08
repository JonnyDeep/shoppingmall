package cn.hlq.user;

import cn.hlq.common.pojo.Discussion;
import cn.hlq.dao.DiscussionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DiscussionTest {
    @Autowired
    DiscussionMapper discussionMapper;

    @Test
    public void test(){

        System.out.println(discussionMapper.queryDiscussionCountByGoodsId(2)==null?0:discussionMapper.queryDiscussionCountByGoodsId(2));
    }
}
