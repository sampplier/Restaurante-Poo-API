package ufpb.poo.restaurante.restaurante.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufpb.poo.restaurante.restaurante.dto.UsuarioDTO;
import ufpb.poo.restaurante.restaurante.repoJPA.UsuarioJPA;

import javax.xml.bind.DatatypeConverter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping(value = "/auth")
@CrossOrigin(origins = {"http://localhost:3000", "https://front-poo-five.vercel.app", "http://localhost:8080", "*"})
public class AuthController {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Autowired
    private UsuarioJPA usuarioJPA;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, String>> loginUsuario(@RequestBody Map<String, String> body) throws Exception {
        Map<String, String> response = new HashMap<>();
        try {

            String username = body.get("usuario");

            if (username == null || username.trim().isEmpty()) {
                response.put("error", "Nome de usuario não informado");
                return ResponseEntity.badRequest().body(response);
            }

            UsuarioDTO usuario = usuarioJPA.findByName(username);

            if (usuario == null) {
                response.put("error", "Usuario nao existe");
                return ResponseEntity.badRequest().body(response);
            }

            String token = this.generateAccessToken(usuario);

            response.put("message", "Login realizado com sucesso");
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    private String generateAccessToken(UsuarioDTO usuario) {
        return Jwts.builder()
                .claim("nome", usuario.getName())
                .claim("usuarioId", usuario.getId())
                .setSubject(String.valueOf(usuario.getId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, "SECRET_KEY")
                .compact();
    }


}
