package bgd.controller;

import bgd.domain.Security;
import bgd.dto.SecurityDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.SecurityMapper;
import bgd.service.AbstractService;
import bgd.service.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/securities")
@RestController
@AllArgsConstructor
public class SecurityController extends AbstractController<Security, SecurityDTO, String > {
    private final SecurityService securityService;
    private final SecurityMapper securityMapper;


    @Override
    protected AbstractService<Security, String> getService() {
        return securityService;
    }

    @Override
    protected AbstractMapper<Security, SecurityDTO> getMapper() {
        return securityMapper;
    }
}
