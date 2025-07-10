package ynu.edu.business_service.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class Business {
    @TableId
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private Double starPrice;
    private Double deliveryPrice;
    private String remarks;

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public Double getStarPrice() {
        return starPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }
}
