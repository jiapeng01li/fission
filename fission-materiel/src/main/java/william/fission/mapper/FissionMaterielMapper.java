package william.fission.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import william.fission.entity.FissionMaterielEntity;
import java.util.List;


/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 16:25
 * @Description:
 */
@Component
public interface FissionMaterielMapper extends Mapper<FissionMaterielEntity>, MySqlMapper<FissionMaterielEntity> {
    String TABLE_NAME = "fission_materiel";

    List<FissionMaterielEntity> page(@Param("offset") int offset, @Param("limit") int limit);

    List<FissionMaterielEntity> listBySkuId(@Param("skuId") String skuId);

    int count();
}
