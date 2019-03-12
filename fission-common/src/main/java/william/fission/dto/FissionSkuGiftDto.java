package william.fission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/27 11:50
 * @Description:分销赠送的商品
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FissionSkuGiftDto {
    @JsonProperty("sku_id")
    private String skuId;

    @JsonProperty("count")
    private int count;
}
