package fitness.service.business;

import fitness.domain.dto.CredentialsDTO;

/**
 * Created by toxa on 24.08.2017.
 */
public interface AuthService {

    String getSecurityToken(CredentialsDTO credentials);
}
