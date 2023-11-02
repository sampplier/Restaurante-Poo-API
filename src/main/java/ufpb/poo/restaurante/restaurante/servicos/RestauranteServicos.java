package ufpb.poo.restaurante.restaurante.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufpb.poo.restaurante.restaurante.RepoJPA.RepoJPA;
import ufpb.poo.restaurante.restaurante.dto.restauranteDTO;

import java.util.List;

@Service
public class RestauranteServicos {
    @Autowired
    private RepoJPA restauranteRepository;

    public restauranteDTO salvarRestaurante(restauranteDTO restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public List<restauranteDTO> listarRestaurantes() {
        return restauranteRepository.findAll();
    }
}

