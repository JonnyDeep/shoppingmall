package cn.hlq.common.pojo;

import java.io.Serializable;

public class GoodspPropertyFilter implements Serializable {
    private Integer id;

    private Integer goodsId;

    private String goodsProperty;

    private Long gtmCreateTime;

    private Long gtmModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty == null ? null : goodsProperty.trim();
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