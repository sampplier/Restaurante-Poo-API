package ufpb.poo.restaurante.restaurante.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurante")
public class restauranteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String preco;
    private String photo;

    public restauranteDTO() {
    }

    public restauranteDTO(long id, String nome, String preco, String photo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
