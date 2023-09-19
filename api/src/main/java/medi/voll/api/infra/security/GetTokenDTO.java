package medi.voll.api.infra.security;

public record GetTokenDTO(
    String token,
    String email,
    Long id
    ) {
    
}
