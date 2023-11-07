package ufpb.poo.restaurante.restaurante.repoJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufpb.poo.restaurante.restaurante.dto.UsuarioDTO;

@Repository
public interface UsuarioJPA extends JpaRepository<UsuarioDTO, Long> {
    @Query(value = "SELECT * FROM usuarios u WHERE u.name = :username", nativeQuery = true)
    UsuarioDTO findByName(@Param("username") String name);
}
