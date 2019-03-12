package william.fission.constants;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 15:55
 * @Description:分销物料类型，方便后期扩展，目前仅支持分销sku
 */
public enum FissionMaterielType {
    SKU(1),
    OTHERS(0),
    ;
    private int value;

    FissionMaterielType(int value) {
        this.value = value;
    }
}
