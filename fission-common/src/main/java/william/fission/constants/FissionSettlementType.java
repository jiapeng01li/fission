package william.fission.constants;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 15:41
 * @Description:分销结算类型
 */
public enum FissionSettlementType {
    IN_TIME(1),                 //生成分销订单后,实时结算
    ARTIFICIAL(2),              //由财务定期人工结算
    IN_TIME_BOTH_SIDES(3)       //分销商和购买者双方都进行实时结算
    ;
    private int value;

    FissionSettlementType(int value) {
        this.value = value;
    }
}
