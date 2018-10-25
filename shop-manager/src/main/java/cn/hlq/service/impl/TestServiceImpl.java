package cn.hlq.service.impl;

import cn.hlq.service.TestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
    public String getName() {
        return "hello";
    }
}
