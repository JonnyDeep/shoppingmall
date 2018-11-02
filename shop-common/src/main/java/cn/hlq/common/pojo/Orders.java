package cn.hlq.common.pojo;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;

    private String orderNo;

    private Integer uid;

    private Double payPrice;

    private Byte isPay;

    private Long payTime;

    private Byte isShip;

    private Long shipTime;

    private Byte isReceipte;

    private Long receipteTime;

    private String shipNo;

    private Byte status;

    private Long gtmCreateTime;

    private Long gtmModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Byte getIsPay() {
        return isPay;
    }

    public void setIsPay(Byte isPay) {
        this.isPay = isPay;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Byte getIsShip() {
        return isShip;
    }

    public void setIsShip(Byte isShip) {
        this.isShip = isShip;
    }

    public Long getShipTime() {
        return shipTime;
    }

    public void setShipTime(Long shipTime) {
        this.shipTime = shipTime;
    }

    public Byte getIsReceipte() {
        return isReceipte;
    }

    public void setIsReceipte(Byte isReceipte) {
        this.isReceipte = isReceipte;
    }

    public Long getReceipteTime() {
        return receipteTime;
    }

    public void setReceipteTime(Long receipteTime) {
        this.receipteTime = receipteTime;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo == null ? null : shipNo.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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