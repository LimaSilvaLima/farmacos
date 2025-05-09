package com.remedios.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.var;

import  com.remedios.infra.TokenService;
import com.remedios.usuarios.UsuarioRepository;

@Component
public interface SecurityFilter extends OncePerRequestFilter {
    //@Autowired 
    //private TokenService tokenService;
    //@Autowired
    //private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
       
        var tokenJWT = recuperarToken(request);
        
        if (tokenJWT !=null){
            var subject = tokenService.getSubjetc(tokenJWT);
            var usuario = repository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("Token JWT: " + tokenJWT);
            System.out.println(tokenJWT);


        }
        
        

        filterChain.doFilter(request, response);
        
    }
    private String recuperarToken(HttpServletRequest request) {
        var autrhorizationHeader = request.getHeader("Authorization");
        if (autrhorizationHeader != null) {
            return autrhorizationHeader.replace("Bearer ", "");
                        
        } 
        return null;
    }
    

}
