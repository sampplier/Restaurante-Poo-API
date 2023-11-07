package ufpb.poo.restaurante.restaurante.repoJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;
@Repository
public interface RepoJPA extends JpaRepository<RestauranteDTO, Long> {


}