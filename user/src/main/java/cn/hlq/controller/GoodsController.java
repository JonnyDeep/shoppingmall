package cn.hlq.controller;

import cn.hlq.annotation.SystemLog;
import cn.hlq.common.pojo.Goods;
import cn.hlq.common.utils.JsonResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/goods")
public class GoodsController {
    private static Logger logger = LogManager.getLogger(GoodsController.class);

    @RequestMapping("/queryGoodsByCategory")
    @SystemLog(module = "用户系统",methods = "搜索商品")
    public @ResponseBody JsonResult queryGoodsByCategory(@RequestParam(required = true) Integer category)
    {
        JsonResult jsonResult = new JsonResult();
        return  jsonResult;
    }

}
