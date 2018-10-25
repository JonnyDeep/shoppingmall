package cn.hlq.common.pojo;

public class Goods {
    private Integer id;

    private String goodsNo;

    private String goodsName;

    private Integer goodsCategoryId;

    private Integer sellid;

    private Long gtmCreateTime;

    private Long gtmModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Integer getSellid() {
        return sellid;
    }

    public void setSellid(Integer sellid) {
        this.sellid = sellid;
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