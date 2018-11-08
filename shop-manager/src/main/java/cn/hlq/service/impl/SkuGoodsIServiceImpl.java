package cn.hlq.service.impl;

import cn.hlq.common.pojo.SkuGoodsVol;
import cn.hlq.common.utils.PageResult;
import cn.hlq.dao.DiscussionMapper;
import cn.hlq.dao.SkuGoodsVolMapper;
import cn.hlq.service.SkuGoodsService;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skuGoodsService")
public class SkuGoodsIServiceImpl  implements SkuGoodsService {
    @Autowired
    SkuGoodsVolMapper skuGoodsVolMapper;

    @Autowired
    DiscussionMapper discussionMapper;
    public PageResult<SkuGoodsVol> queryGoods(Integer startPage,Integer pageSize){
        PageHelper.startPage(startPage,pageSize);
        List<SkuGoodsVol> skuGoodsVols = skuGoodsVolMapper.queryGoods();
        for (SkuGoodsVol s :
                skuGoodsVols) {
            System.out.println("---> "+ new Gson().toJson(s));
        }

        PageResult<SkuGoodsVol> pageResult = new PageResult<>(skuGoodsVols);
        return pageResult;
    }

    @Override
    public PageResult<SkuGoodsVol> querySearchGoodsBy() {
        PageHelper.startPage(1,20);
        List<SkuGoodsVol> skuGoodsVols = skuGoodsVolMapper.querySearchGoodsBy();
        for (SkuGoodsVol s :
                skuGoodsVols) {
            Integer count = discussionMapper.queryDiscussionCountByGoodsId(s.getGoodsId());
            s.setDiscussionCount(count==null?0:count);
        }
//        skuGoodsVols.stream().forEach(v->{
////            Integer count = discussionMapper.queryDiscussionCountByGoodsId(v.getGoodsId());
////            v.setDiscussionCount(count==null?0:count);
//            System.out.println("---> "+new Gson().toJson(v));
//        });

        PageResult<SkuGoodsVol> pageResult = new PageResult<>(skuGoodsVols);
        return pageResult;
    }
}
