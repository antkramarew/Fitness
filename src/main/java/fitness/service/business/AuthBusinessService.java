package fitness.service.business;

import fitness.domain.dto.CredentialsDTO;
import org.springframework.stereotype.Service;

/**
 * Created by toxa on 24.08.2017.
 */

@Service
public class AuthBusinessService implements AuthService {
    @Override
    public String getSecurityToken(CredentialsDTO credentials) {
        return null;
    }
}
