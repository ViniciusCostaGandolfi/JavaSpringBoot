package medi.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import medi.voll.api.dto.Authentication.AuthenticationLoginDTO;
import medi.voll.api.infra.security.GetTokenDTO;
import medi.voll.api.model.User;
import medi.voll.api.service.TokenService;

@RestController
@RequestMapping("/login")
public class AuthorizationControler {

    @Autowired(required = true)
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> makeLogin(@RequestBody @Valid AuthenticationLoginDTO data) {
        var authorizationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        User authentication =  (User) this.authenticationManager.authenticate(authorizationToken);
        var tokenJWT = tokenService.generateToken(authentication);
        return ResponseEntity.ok(new GetTokenDTO(tokenJWT, authentication.getEmail(), authentication.getId()));
    }
    
}
