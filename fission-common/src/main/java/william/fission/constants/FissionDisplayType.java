package william.fission.constants;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 15:39
 * @Description:分销展示类型
 */
public enum  FissionDisplayType {
    TO_C(1),
    TO_B(2),
    PU(3),
    VIP(4),
    ;
    private int value;

    FissionDisplayType(int value) {
        this.value = value;
    }
}
