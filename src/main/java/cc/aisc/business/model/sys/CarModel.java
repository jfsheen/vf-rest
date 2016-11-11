package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonTreeNode;

import java.math.BigDecimal;

/**
 * Created by sjf on 16-10-20.
 *
 * 车辆品牌、型号、款式
 */
public class CarModel extends CommonTreeNode {

    private String name;          //车型名称
    private BigDecimal evalPrc;   //估价
    private Boolean isImptd;      //是否进口车
    private String carInfo;       // ;分割的车辆参数信息，车重;排气量;轴距;长;宽;高
    private String description;
    private String lblName;
    private String colors;

    public CarModel() {
    }

    public String getLblName() {
        return lblName;
    }

    public void setLblName(String lblName) {
        this.lblName = lblName;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEvalPrc() {
        return evalPrc;
    }

    public void setEvalPrc(BigDecimal evalPrc) {
        this.evalPrc = evalPrc;
    }

    public Boolean getImptd() {
        return isImptd;
    }

    public void setImptd(Boolean imptd) {
        isImptd = imptd;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
