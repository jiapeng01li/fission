package william.fission;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import william.fission.constants.FissionDisplayType;
import william.fission.dto.FissionMaterielDto;
import william.fission.dto.FissionMaterielSkuItemDto;
import william.fission.dto.FissionSkuGiftDto;
import william.fission.service.FissionMaterialService;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/3/12 17:38
 * @Description:
 */
@SpringBootTest(classes = FissionMaterielApplication.class)
@RunWith(SpringRunner.class)
public class TestFissionMaterielService {
    @Autowired
    private FissionMaterialService service;

    @Test
    public void testAdd(){
        FissionMaterielDto dto = new FissionMaterielDto();
        dto.setTitle("物料2");
        dto.setOriginPosterUrl("www.baidu.com");
        dto.setLandingPageUrl("www.baidu.com");
        dto.setStartTime(1550742357L);
        dto.setStopTime(1550752357L);
        dto.setStatus(1);
        dto.setDisplayType(FissionDisplayType.TO_B);
        List<FissionMaterielSkuItemDto> items = Lists.newLinkedList();
        FissionMaterielSkuItemDto item1 = new FissionMaterielSkuItemDto();
        FissionSkuGiftDto gift1 = new FissionSkuGiftDto();
        List<FissionSkuGiftDto> gifts = Lists.newLinkedList();
        gift1.setSkuId("1");
        gift1.setCount(1);
        gifts.add(gift1);
        item1.setGifts(gifts);
        item1.setSkuId("3");
        item1.setSkuName("sku3");
        items.add(item1);
        FissionMaterielSkuItemDto item2 = new FissionMaterielSkuItemDto();
        item2.setSkuId("4");
        item2.setSkuName("sku4");
        item2.setBonus(400L);
        items.add(item2);
        dto.setItems(items);
        service.enteringMateriel(dto);
    }

    @Test
    public void testGetById(){
        Optional<FissionMaterielDto> dto = service.queryById(1L);
        Assert.assertTrue(dto.isPresent());
    }

}
