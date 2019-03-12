package william.fission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 16:16
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FissionMaterielSkuItemDto {
    @JsonProperty("sku_id")
    private String skuId;

    @JsonProperty("sku_name")
    private String skuName;

    @JsonProperty("bonus")
    private Long bonus;

    @JsonProperty("gifts")
    private List<FissionSkuGiftDto> gifts;
}
