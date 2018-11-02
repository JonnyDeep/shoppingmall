package cn.hlq.common.pojo;

import java.io.Serializable;

public class PropertyName implements Serializable{
    private Integer id;

    private String name;

    private Integer goodsCategoryId;

    private Integer parentCategoryId;

    private Long gtmCreateTime;

    private Long gtmModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Long getGtmCreateTime() {
        return gtmCreateTime;
    }

    public void setGtmCreateTime(Long gtmCreateTime) {
        this.gtmCreateTime = gtmCreateTime;
    }

    public Long getGtmModifyTime() {
        return gtmModifyTime;
    }

    public void setGtmModifyTime(Long gtmModifyTime) {
        this.gtmModifyTime = gtmModifyTime;
    }
}