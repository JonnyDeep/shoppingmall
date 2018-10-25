package cn.hlq.common.utils;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import java.util.List;

public class PageResult<K> {
    private long total;
    private List<K> rows;
    private PageInfo<K> pageInfo;

    public PageResult(List<K> list)
    {
        setRows(list);
        pageInfo = new PageInfo<K>(list);
        setTotal(pageInfo.getTotal());
    }

    public long getTotal(){
        return total;
    }

    public void setTotal(long total){
        this.total = total;
    }

    public List<?> getRows(){
        return rows;
    }

    public void setRows(List<K> rows){
        this.rows = rows;
    }

    public String toString()
    {
        return new Gson().toJson(this);
    }


}
