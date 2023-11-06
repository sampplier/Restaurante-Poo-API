package ufpb.poo.restaurante.restaurante.controller;

import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;
import ufpb.poo.restaurante.restaurante.facade.RestauranteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/restaurante",produces = MediaType.APPLICATION_JSON_VALUE)

public class RestauranteController {
    @Autowired
    private RestauranteFacade restauranteFacade;
    @PostMapping
    @ResponseBody
    public RestauranteDTO criar(@RequestBody RestauranteDTO restauranteDTO){
        return restauranteFacade.criar(restauranteDTO);
    }
    @PutMapping("/{restauranteId}")
    @ResponseBody
    public RestauranteDTO atualizar(@PathVariable("restauranteId") Long restauranteId, @RequestBody RestauranteDTO restauranteDTO){
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
    public String deletar(@PathVariable("restauranteId") Long restauranteId){
        return restauranteFacade.delete(restauranteId);
    }
}
