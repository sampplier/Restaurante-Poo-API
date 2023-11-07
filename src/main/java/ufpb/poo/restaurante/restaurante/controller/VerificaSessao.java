package ufpb.poo.restaurante.restaurante.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

public class VerificaSessao {
    public Boolean verificaTokenUsuario(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary("SECRET_KEY"))
//                .parseClaimsJws(token)
//                .getBody();

       try {
           Jws<Claims> jwt = Jwts.parser()
                   .setSigningKey("SECRET_KEY")
                   .parseClaimsJws(token);


           return true;
       } catch (Exception e) {
           System.out.println("USUARIO NAO LOGADO");
           return false;
       }
    }
}
