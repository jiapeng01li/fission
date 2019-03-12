package william.fission.entity;

import lombok.Getter;
import lombok.Setter;
import william.fission.constants.FissionDisplayType;
import william.fission.constants.FissionMaterielType;
import william.fission.constants.FissionSettlementType;
import william.fission.mapper.FissionMaterielMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 15:19
 * @Description:分销物料核心数据结构
 */
@Getter
@Setter
@Table(name = FissionMaterielMapper.TABLE_NAME)
public class FissionMaterielEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String title;
    private String originPosterUrl;
    private String landingPageUrl;
    private Date startTime;
    private Date stopTime;
    private int status;
    private FissionMaterielType materielType;
    private FissionDisplayType displayType;
    private FissionSettlementType settlementType;
    private String items;
    private String extra;
    private String skuId;

    private Integer rewardCountLimit;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginPosterUrl() {
        return originPosterUrl;
    }

    public void setOriginPosterUrl(String originPosterUrl) {
        this.originPosterUrl = originPosterUrl;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    public void setLandingPageUrl(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public FissionMaterielType getMaterielType() {
        return materielType;
    }

    public void setMaterielType(FissionMaterielType materielType) {
        this.materielType = materielType;
    }

    public FissionDisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(FissionDisplayType displayType) {
        this.displayType = displayType;
    }

    public FissionSettlementType getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(FissionSettlementType settlementType) {
        this.settlementType = settlementType;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getRewardCountLimit() {
        return rewardCountLimit;
    }

    public void setRewardCountLimit(Integer rewardCountLimit) {
        this.rewardCountLimit = rewardCountLimit;
    }
}
