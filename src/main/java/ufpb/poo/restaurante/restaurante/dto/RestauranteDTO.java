package ufpb.poo.restaurante.restaurante.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurante")
public class RestauranteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String photo;
    private String nome;
    private String descricao;
    private double preco;

    public String getDescricao() {
        return descricao;
    }

    public RestauranteDTO() {
    }

    public RestauranteDTO(long id, String photo, String nome, String descricao, double preco) {
        this.id = id;
        this.photo = photo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //id photo nome descrição preco

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
