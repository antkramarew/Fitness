package fitness.rest.controller;

import fitness.domain.dto.CredentialsDTO;
import fitness.rest.model.CredentialsModel;
import fitness.service.business.AuthService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by toxa on 24.08.2017.
 */

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/user")
public class UserController {

    @Autowired
    private AuthService authService;
    @Autowired
    private DozerBeanMapper mapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity createUser(@RequestBody CredentialsModel model) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.CREATED);
        CredentialsDTO credentials = mapper.map(model, CredentialsDTO.class);
        String securityToken = authService.getSecurityToken(credentials);
        responseEntity.getHeaders().add("securityToken", securityToken);
        return responseEntity;
    }


}
