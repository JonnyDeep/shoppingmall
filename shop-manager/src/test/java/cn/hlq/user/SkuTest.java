package cn.hlq.user;


import cn.hlq.common.pojo.SkuGoodsVol;
import cn.hlq.common.utils.PageResult;
import cn.hlq.service.impl.SkuGoodsIServiceImpl;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SkuTest {

    @Autowired
    SkuGoodsIServiceImpl skuGoodsService;

    @Test
    public void test(){
        PageResult<SkuGoodsVol> skus = skuGoodsService.queryGoods(1,5);
        System.out.println(new Gson().toJson(skus));
    }

    @Test
    public void test1(){
        PageResult<SkuGoodsVol> skus = skuGoodsService.querySearchGoodsBy();
        System.out.println(new Gson().toJson(skus));
    }

}
