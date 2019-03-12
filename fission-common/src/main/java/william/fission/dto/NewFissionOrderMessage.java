package william.fission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/3/1 14:55
 * @Description:新分销订单消息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class NewFissionOrderMessage {
    private String refCode;

    private String tradeNumber;

    private Long buyerMemberId;

    private Long paidAmount;

    private String skuId;

    @Override
    public String toString() {
        return String.format("[refCode: %s, tradeNumber: %s, buyerMemberId: %s, paidAmount: %s, skuId: %s ]",
                refCode, tradeNumber, buyerMemberId, paidAmount, skuId);
    }
}
