package william.fission.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import william.fission.constants.FissionDisplayType;
import william.fission.constants.FissionMaterielType;
import william.fission.constants.FissionSettlementType;
import william.fission.dto.CommonPaginationDto;
import william.fission.dto.FissionMaterielDto;
import william.fission.dto.FissionMaterielSkuItemDto;
import william.fission.entity.FissionMaterielEntity;
import william.fission.mapper.FissionMaterielMapper;
import william.fission.service.FissionMaterialService;
import william.fission.utils.JacksonUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/21 16:29
 * @Description:分销物料的录入和查询服务
 */
@Service
public class FissionMaterialServiceImpl implements FissionMaterialService {
    private static Logger logger = LoggerFactory.getLogger(FissionMaterialServiceImpl.class);

    @Autowired
    private FissionMaterielMapper mapper;

    @Override
    public void enteringMateriel(FissionMaterielDto dto) {
        FissionMaterielEntity entity = dto2Entity(dto);
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        mapper.insert(entity);
    }

    @Override
    public Optional<FissionMaterielDto> queryById(long id) {
        FissionMaterielEntity entity = mapper.selectByPrimaryKey(id);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(entity2Dto(entity));
    }

    @Override
    public CommonPaginationDto<FissionMaterielDto> page(int offset, int limit) {
        CommonPaginationDto<FissionMaterielDto> page = CommonPaginationDto.valueOf(offset, limit, mapper.count());
        Optional.ofNullable(mapper.page(offset, limit)).ifPresent(p -> {
            List<FissionMaterielDto> data = p.stream().map(this::entity2Dto).collect(Collectors.toList());
            page.setData(data);
        });
        return page;
    }

    @Override
    public List<FissionMaterielDto> listBySkuId(String skuId) {
        return Optional.ofNullable(mapper.listBySkuId(skuId))
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entity2Dto)
                .collect(Collectors.toList());
    }

    private FissionMaterielEntity dto2Entity(FissionMaterielDto dto) {
        FissionMaterielEntity entity = new FissionMaterielEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setStartTime(new Date(dto.getStartTime() * 1000L));
        entity.setStopTime(new Date(dto.getStopTime() * 1000L));
        entity.setMaterielType(FissionMaterielType.SKU);
        entity.setSettlementType(FissionDisplayType.TO_B == dto.getDisplayType() ? FissionSettlementType.ARTIFICIAL : FissionSettlementType.IN_TIME);
        entity.setItems(JacksonUtils.writeAsString(dto.getItems()));
        return entity;
    }

    private FissionMaterielDto entity2Dto(FissionMaterielEntity entity) {
        FissionMaterielDto dto = new FissionMaterielDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setId(String.valueOf(entity.getId()));
        dto.setStartTime(entity.getStartTime().getTime() / 1000L);
        dto.setStopTime(entity.getStopTime().getTime() / 1000L);
        dto.setItems(JacksonUtils.readValue(entity.getItems(), new TypeReference<List<FissionMaterielSkuItemDto>>() {
        }));
        return dto;
    }
}
