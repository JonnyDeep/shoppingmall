package cn.hlq.controller;

import cn.hlq.annotation.SystemLog;
import cn.hlq.common.pojo.Goods;
import cn.hlq.common.pojo.SkuGoodsVol;
import cn.hlq.common.utils.JsonResult;
import cn.hlq.common.utils.PageResult;
import cn.hlq.common.utils.ResultCode;
import cn.hlq.service.GoodsService;
import cn.hlq.service.SkuGoodsService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private static Logger logger = LogManager.getLogger(GoodsController.class);

    @Autowired
    GoodsService goodsService;

    @Autowired
    SkuGoodsService skuGoodsService;
    @RequestMapping("/queryGoods")
    @SystemLog(module = "用户系统",methods = "搜索商品")
    public @ResponseBody JsonResult queryGoodsBySearchKey(@RequestParam(value = "") String q)
    {
        logger.info("------>q{},",q);
        PageResult<SkuGoodsVol> pageResult = skuGoodsService.querySearchGoodsBy();

        logger.info("--->pageNum:{},pageCount:{}",pageResult.getPageNum(),pageResult.getPageCount());
        logger.info("--->pageResult:{}",new Gson().toJson(pageResult));
        JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS,"查询成功",pageResult);
        logger.info("--->jsonResult:{}",new Gson().toJson(jsonResult));
        return  jsonResult;
    }

    @RequestMapping(value = "/queryGoodsByCondition",method = RequestMethod.GET)
    @SystemLog(module = "用户系统",methods = "搜索商品")
    public @ResponseBody JsonResult queryGoodsByCondition(@RequestParam(required = true) String searchCondition)
    {
        logger.info("-----> search condition：{}",searchCondition);
//        Session session = SecurityUtils.getSubject().getSession();
//        Collection c = session.getAttributeKeys();
//        if (c.size()==0){
//            logger.info("---> no session");

//        c.stream().forEach(v->{logger.info("key:{},value:{}",v,session.getAttribute(v));});

        List<Goods> list = goodsService.queryGoods();

        list.stream().forEach(v->{logger.info("---->result:"+new Gson().toJson(v));});
        JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS);
        jsonResult.setData(list);
        return  jsonResult;
    }

}
