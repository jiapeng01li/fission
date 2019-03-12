package william.fission;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import william.fission.constants.FissionDisplayType;
import william.fission.constants.FissionMaterielType;
import william.fission.constants.FissionSettlementType;
import william.fission.dto.FissionMaterielSkuItemDto;
import william.fission.dto.FissionSkuGiftDto;
import william.fission.entity.FissionMaterielEntity;
import william.fission.mapper.FissionMaterielMapper;
import william.fission.utils.JacksonUtils;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/3/12 17:38
 * @Description:
 */
@SpringBootTest(classes = FissionMaterielApplication.class)
@RunWith(SpringRunner.class)
public class TestFissionMaterielMapper {
    @Autowired
    private FissionMaterielMapper mapper;

    @Test
    public void testSelectAll() {
        List<FissionMaterielEntity> entities = mapper.selectAll();
        Assert.assertNotNull(entities);
    }

    @Test
    public void testAdd() {
        FissionMaterielEntity entity = new FissionMaterielEntity();
        entity.setTitle("分销物料1");
        entity.setOriginPosterUrl("www.baidu.com");
        entity.setLandingPageUrl("www.baidu.com");
        entity.setStartTime(new Date());
        entity.setStopTime(new Date());
        entity.setStatus(1);
        entity.setMaterielType(FissionMaterielType.SKU);
        entity.setDisplayType(FissionDisplayType.TO_C);
        entity.setSettlementType(FissionSettlementType.IN_TIME_BOTH_SIDES);

        List<FissionMaterielSkuItemDto> items = Lists.newLinkedList();
        FissionMaterielSkuItemDto item1 = new FissionMaterielSkuItemDto();
        item1.setSkuId("1");
        item1.setSkuName("sku1");
        List<FissionSkuGiftDto> gifts = Lists.newLinkedList();
        FissionSkuGiftDto gift = new FissionSkuGiftDto();
        gift.setSkuId("1");
        gift.setCount(1);
        gifts.add(gift);
        item1.setGifts(gifts);
        items.add(item1);

        FissionMaterielSkuItemDto item2 = new FissionMaterielSkuItemDto();
        item2.setSkuId("2");
        item2.setSkuName("sku2");
        items.add(item2);

        entity.setItems(JacksonUtils.writeAsString(items));
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        mapper.insert(entity);
        Assert.assertNotNull(entity.getId());
    }

    @Test
    public void testPage() {
        List<FissionMaterielEntity> page = mapper.page(0, 20);
        Assert.assertNotNull(page);
    }

    @Test
    public void testCount() {
        int count = mapper.count();
        Assert.assertTrue(count > 0);
    }

}
