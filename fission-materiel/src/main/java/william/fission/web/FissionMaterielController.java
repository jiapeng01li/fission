package william.fission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import william.fission.dto.FissionMaterielDto;
import william.fission.service.FissionMaterialService;
import java.util.Optional;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/3/12 18:27
 * @Description:
 */
@RestController
@RequestMapping("/fission/materiel")
public class FissionMaterielController {
    @Autowired
    private FissionMaterialService service;

    @GetMapping("/{materielId}")
    public FissionMaterielDto queryById(@PathVariable("materielId") long materielId) {
        Optional<FissionMaterielDto> dto = service.queryById(materielId);
        return dto.get();
    }
}
