package ufpb.poo.restaurante.restaurante.facade;

import org.springframework.beans.factory.annotation.Autowired;
import ufpb.poo.restaurante.restaurante.RepoJPA.RepoJPA;
import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteFacade {
    @Autowired
    private RepoJPA repoJPA;

    public RestauranteDTO criar(RestauranteDTO restauranteDTO) {
        return repoJPA.save(restauranteDTO);
    }

    public RestauranteDTO atualizar(RestauranteDTO restauranteDTO, Long restauranteId) {
        restauranteDTO.setId(restauranteId);
        return repoJPA.save(restauranteDTO);
    }

    public RestauranteDTO getById(Long restauranteId) {
        return repoJPA.findById(restauranteId).orElse(null);
    }

    public List<RestauranteDTO> getAll() {
        return repoJPA.findAll();
    }

    public String delete(Long restauranteId) {
        repoJPA.deleteById(restauranteId);
        return "Exclusão bem-sucedida";
    }
}
