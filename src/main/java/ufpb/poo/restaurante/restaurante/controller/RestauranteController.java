package ufpb.poo.restaurante.restaurante.controller;

import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;
import ufpb.poo.restaurante.restaurante.facade.RestauranteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/restaurante",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = {"http://localhost:3000", "https://front-poo-five.vercel.app", "http://localhost:8080"})
public class RestauranteController {
    @Autowired
    private RestauranteFacade restauranteFacade;

    @PostMapping
    @ResponseBody
    public RestauranteDTO criar(@RequestBody RestauranteDTO restauranteDTO, @RequestHeader Map<String, String> headers) throws Exception {
        String authorization = headers.get("authorization");

        VerificaSessao verificaSessao = new VerificaSessao();

        if (authorization == null) {
            throw new Exception("Token de usuário nao informado");
        }

        String[] bearerToken = authorization.split(" ");

        if (bearerToken[1] == null) {
            throw new Exception("Token de usuário nao informado");
        }

        Boolean sessionOK = verificaSessao.verificaTokenUsuario(bearerToken[1]);

        if (!sessionOK) {
            throw new Exception("Usuario não tem permissão para acessar está funcionalidade");
        }


        return restauranteFacade.criar(restauranteDTO);
    }
    @PutMapping("/{restauranteId}")
    @ResponseBody
    public RestauranteDTO atualizar(@PathVariable("restauranteId") Long restauranteId, @RequestBody RestauranteDTO restauranteDTO, @RequestHeader Map<String, String> headers) throws Exception {
        String authorization = headers.get("authorization");

        VerificaSessao verificaSessao = new VerificaSessao();

        if (authorization == null) {
            throw new Exception("Token de usuário nao informado");
        }

        String[] bearerToken = authorization.split(" ");

        if (bearerToken[1] == null) {
            throw new Exception("Token de usuário nao informado");
        }

        Boolean sessionOK = verificaSessao.verificaTokenUsuario(bearerToken[1]);

        if (!sessionOK) {
            throw new Exception("Usuario não tem permissão para acessar está funcionalidade");
        }

        return restauranteFacade.atualizar(restauranteDTO, restauranteId);
    }
    @GetMapping
    @ResponseBody
    public List<RestauranteDTO> getAll(){
        return restauranteFacade.getAll();
    }
    @GetMapping("/{restauranteId}")
    @ResponseBody
    public RestauranteDTO getById(@PathVariable("restauranteId") Long restauranteId){
        return restauranteFacade.getById(restauranteId);
    }
    @DeleteMapping("/{restauranteId}")
    @ResponseBody
    public String deletar(@PathVariable("restauranteId") Long restauranteId, @RequestHeader Map<String, String> headers) throws Exception {
        String authorization = headers.get("authorization");

        VerificaSessao verificaSessao = new VerificaSessao();

        if (authorization == null) {
            throw new Exception("Token de usuário nao informado");
        }

        String[] bearerToken = authorization.split(" ");

        if (bearerToken[1] == null) {
            throw new Exception("Token de usuário nao informado");
        }

        Boolean sessionOK = verificaSessao.verificaTokenUsuario(bearerToken[1]);

        if (!sessionOK) {
            throw new Exception("Usuario não tem permissão para acessar está funcionalidade");
        }



        return restauranteFacade.delete(restauranteId);
    }
}
