package ufpb.poo.restaurante.restaurante.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String password;

    public UsuarioDTO(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UsuarioDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
