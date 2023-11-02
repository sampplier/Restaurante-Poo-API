package ufpb.poo.restaurante.restaurante.facade;

import org.springframework.beans.factory.annotation.Autowired;
import ufpb.poo.restaurante.restaurante.RepoJPA.RepoJPA;
import ufpb.poo.restaurante.restaurante.dto.restauranteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class restauranteFacede {
    @Autowired
    private RepoJPA repoJPA;

    public restauranteDTO criar(restauranteDTO restauranteDTO) {
        return repoJPA.save(restauranteDTO);
    }

    public restauranteDTO atualizar(restauranteDTO restauranteDTO, Long restauranteId) {
        restauranteDTO.setId(restauranteId);
        return repoJPA.save(restauranteDTO);
    }

    public restauranteDTO getById(Long restauranteId) {
        return repoJPA.findById(restauranteId).orElse(null);
    }

    public List<restauranteDTO> getAll() {
        return repoJPA.findAll();
    }

    public String delete(Long restauranteId) {
        repoJPA.deleteById(restauranteId);
        return "Exclusão bem-sucedida";
    }
}
