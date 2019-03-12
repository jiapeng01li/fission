package william.fission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import william.fission.constants.FissionDisplayType;
import william.fission.constants.FissionSettlementType;
import java.util.List;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 16:30
 * @Description:分销物料
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FissionMaterielDto {
    public static final int STATUS_NORMAL = 1;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("origin_poster_url")
    private String originPosterUrl;

    @JsonProperty("landing_page_url")
    private String landingPageUrl;

    @JsonProperty("start_time")
    private long startTime;

    @JsonProperty("stop_time")
    private long stopTime;

    @JsonProperty("status")
    private int status;

    @JsonProperty("display_type")
    private FissionDisplayType displayType;

    @JsonProperty("items")
    private List<FissionMaterielSkuItemDto> items;

    @JsonProperty("sku_id")
    private String skuId;

    @JsonProperty("extra")
    private String extra;

    @JsonProperty("settlement_type")
    private FissionSettlementType settlementType;

    @JsonProperty("reward_count_limit")
    private Integer rewardCountLimit;

    public boolean isValidNow() {
        long now = System.currentTimeMillis() / 1000L;
        return (STATUS_NORMAL == status && startTime <= now && now < stopTime);
    }
}
