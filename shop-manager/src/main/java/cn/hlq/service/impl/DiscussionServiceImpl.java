package cn.hlq.service.impl;

import cn.hlq.common.pojo.Discussion;
import cn.hlq.dao.DiscussionMapper;
import cn.hlq.dao.DiscussionVolMapper;
import cn.hlq.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("discussionService")
public class DiscussionServiceImpl implements DiscussionService {
    @Autowired
    DiscussionMapper discussionMapper;
    @Autowired
    DiscussionVolMapper discussionVolMapper;
    public Integer postDuscussion(Discussion discussion) {
        return discussionMapper.insert(discussion);
    }

    public List<Discussion> queryDiscussion(Integer goodId) {
       return discussionVolMapper.selectByGoodsId(goodId);
    }
}
