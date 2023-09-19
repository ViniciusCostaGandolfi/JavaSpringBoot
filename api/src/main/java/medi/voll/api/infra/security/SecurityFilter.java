package medi.voll.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import medi.voll.api.repository.UserRepository;
import medi.voll.api.service.TokenService;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private TokenService tokenService;

    @Autowired 
    private UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String token = this.getToken(request);
                if (token != null) {
                    
                    String subject = tokenService.getSubject(token);
                    UserDetails user = this.repository.findByEmail(subject);
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }
                filterChain.doFilter(request, response);
            }

    private String getToken(HttpServletRequest request) {
        if (request.getHeader("Authorization") == null) {
            return null;
        }
        return request.getHeader("Authorization").replace("Bearer", "");
    }
    
}
