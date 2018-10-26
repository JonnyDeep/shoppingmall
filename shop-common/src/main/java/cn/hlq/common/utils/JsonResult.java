package cn.hlq.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.runtime.JSONFunctions;

public class JsonResult {
    private String code;
    private String messge;
    private Object data;
    private int pageCount;
    private int pageNum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(ResultCode code)
    {
        this.code = code.val();
    }


    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public JsonResult(){
        this.setCode(ResultCode.SUCCESS);
        this.setMessge("成功!");
    }

    public JsonResult(ResultCode code)
    {
        this.setCode(code.val());
        this.setMessge(code.message());

    }

    public JsonResult(ResultCode code,String messge,Object data) {
        this.setCode(code);
        this.setMessge(messge);
        if(data instanceof PageResult)
        {
            PageResult pageResult = (PageResult)data;
            this.setPageCount(pageResult.getPageCount());
            this.setPageNum(pageResult.getPageNum());
            this.setData(pageResult);
        }else{
            this.setData(data);
        }
    }

    public String toString(){
        JsonObject json = new JsonObject();
        json.addProperty("code",code);
        json.addProperty("message",messge);
        json.addProperty("pageCount",pageCount);
        json.addProperty("pageNum",pageNum);
        json.add("data",new Gson().toJsonTree(data));
        return json.toString();
    }

}
