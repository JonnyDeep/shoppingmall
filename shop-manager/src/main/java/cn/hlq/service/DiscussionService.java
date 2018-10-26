package cn.hlq.service;

import cn.hlq.common.pojo.Discussion;

import java.util.List;

/**
 * @author huangliqun
 * @date 2018-10-26
 */
public interface DiscussionService {
    /**
     * insert a discussion of goods
     * @param discussion
     */
    public Integer postDuscussion(Discussion discussion);

    /**
     * query all discussions of goods
     * @param goodId
     * @return
     */
    public List<Discussion> queryDiscussion(Integer goodId);
}
