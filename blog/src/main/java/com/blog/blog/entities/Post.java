package com.blog.blog.entities;
import jakarta.persistence.*;

@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String conteudo;
    /*@ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;*/

    public Post(){}

    public Post(String conteudo, Long id, String titulo, User usuario) {
        this.conteudo = conteudo;
        this.id = id;
        this.titulo = titulo;
        //this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    /*public User getUsuario() {
        return usuario;
    }
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }*/

    



}
