package com.ch.bean;

/**
 * Created by 赖红 on 2017/12/26.
 */
public class Type {
    private Integer typeId;

    private String typeName;

    private String describes;

    private String imageName;

    private Integer blogCount; // 数量

    private Integer orderNo; // 排序 从小到大排序显示

    public Type() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Type(Integer typeId, String typeName, String describes,
                String imageName) {
        super();
        this.typeId = typeId;
        this.typeName = typeName;
        this.describes = describes;
        this.imageName = imageName;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }
}
