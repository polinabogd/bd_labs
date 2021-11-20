package bgd.service;

import bgd.domain.Security;
import bgd.repository.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SecurityService extends AbstractService<Security, String> {
    public SecurityRepository securityRepository;

    @Override
    protected JpaRepository<Security, String> getRepository() {
        return securityRepository;
    }
}