package ufpb.poo.restaurante.restaurante.facade;

import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;

import java.util.List;

public interface RestauranteInterfaceFacade {
    RestauranteDTO criar(RestauranteDTO restauranteDTO);
    RestauranteDTO atualizar(RestauranteDTO restauranteDTO, Long restauranteId);
    RestauranteDTO getById(Long restauranteId);
    List<RestauranteDTO> getAll();
    String delete(Long restauranteId);
}
