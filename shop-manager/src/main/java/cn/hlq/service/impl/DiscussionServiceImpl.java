package cn.hlq.service.impl;

import cn.hlq.service.DiscussionService;
import org.springframework.stereotype.Service;

@Service("discussionService")
public class DiscussionServiceImpl implements DiscussionService {
    public String testDsicussionService() {
        return "ok";
    }
}
