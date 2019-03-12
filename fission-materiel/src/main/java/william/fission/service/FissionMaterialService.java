package william.fission.service;

import william.fission.dto.CommonPaginationDto;
import william.fission.dto.FissionMaterielDto;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 16:29
 * @Description:分销物料的录入和查询服务
 */
public interface FissionMaterialService {

    /**
     * 录入分销物料
     */
    void enteringMateriel(FissionMaterielDto dto);

    /**
     * 根据id查询物料
     *
     * @param materielId 物料id
     * @return
     */
    Optional<FissionMaterielDto> queryById(long materielId);

    /**
     * 分页查询物料
     *
     * @param offset
     * @param limit
     * @return
     */
    CommonPaginationDto<FissionMaterielDto> page(int offset, int limit);

    /**
     * 根据skuId查询物料
     *
     * @param skuId
     */
    List<FissionMaterielDto> listBySkuId(String skuId);
}
