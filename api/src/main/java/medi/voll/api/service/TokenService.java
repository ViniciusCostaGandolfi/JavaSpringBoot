package medi.voll.api.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import medi.voll.api.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.create()
                        .withIssuer("VollMed API")
                        .withClaim("id", user.getId())
                        .withClaim("email", user.getEmail())
                        .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro no runtime ;-; ", exception);
        }
    }

    public String getSubject(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            return JWT.require(algorithm)
                        .withIssuer("VollMed API")
                        .build()
                        .verify(token)
                        .getSubject();
        } catch (JWTCreationException exception){
            throw new RuntimeException("Token inválido! ", exception);
        }

    }

    public Instant datoExpeireToken() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-3:00"));
    }
    
}
