package cn.hlq.common.pojo;

public class Discussion {
    private Integer id;

    private Integer uid;

    private Integer goodsId;

    private String wordDiscussion;

    private String imageDiscussion;

    private Long gtmCreateTime;

    private Long gtmModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getWordDiscussion() {
        return wordDiscussion;
    }

    public void setWordDiscussion(String wordDiscussion) {
        this.wordDiscussion = wordDiscussion == null ? null : wordDiscussion.trim();
    }

    public String getImageDiscussion() {
        return imageDiscussion;
    }

    public void setImageDiscussion(String imageDiscussion) {
        this.imageDiscussion = imageDiscussion == null ? null : imageDiscussion.trim();
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