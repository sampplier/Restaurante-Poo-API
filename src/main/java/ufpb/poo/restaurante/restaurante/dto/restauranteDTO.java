package ufpb.poo.restaurante.restaurante.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurante")
public class restauranteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String photo;
    private String nome;
    private String descricao;
    private String preco;

    public String getDescricao() {
        return descricao;
    }

    public restauranteDTO() {
    }

    public restauranteDTO(long id, String photo, String nome, String descricao, String preco) {
        this.id = id;
        this.photo = photo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
