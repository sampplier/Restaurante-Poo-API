package ufpb.poo.restaurante.restaurante.controller;

import ufpb.poo.restaurante.restaurante.dto.restauranteDTO;
import ufpb.poo.restaurante.restaurante.facade.restauranteFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/restaurante",produces = MediaType.APPLICATION_JSON_VALUE)

public class restauranteController {
    @Autowired
    private restauranteFacede restauranteFacede;
    @PostMapping
    @ResponseBody
    public restauranteDTO criar(@RequestBody restauranteDTO restauranteDTO){
        return restauranteFacede.criar(restauranteDTO);
    }
    @PutMapping("/{restauranteId}")
    @ResponseBody
    public restauranteDTO atualizar(@PathVariable("restauranteId") Long restauranteId, @RequestBody restauranteDTO restauranteDTO){
        return restauranteFacede.atualizar(restauranteDTO, restauranteId);
    }
    @GetMapping
    @ResponseBody
    public List<restauranteDTO> getAll(){
        return restauranteFacede.getAll();
    }
    @GetMapping("/{restauranteId}")
    @ResponseBody
    public restauranteDTO getById(@PathVariable("restauranteId") Long restauranteId){
        return restauranteFacede.getById(restauranteId);
    }
    @DeleteMapping("/{restauranteId}")
    @ResponseBody
    public String deletar(@PathVariable("restauranteId") Long restauranteId){
        return restauranteFacede.delete(restauranteId);
    }
}
