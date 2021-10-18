package com.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="contato")
public class ContatoModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private Long telefone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private PessoaModel pessoa;

    public ContatoModel(){}

    public ContatoModel(Long id, PessoaModel pessoa, String email, Long telefone){
        this.id = id;
        this.pessoa = pessoa;
        this.email = email;
        this.telefone = telefone;
    }

    public PessoaModel getPessoa(){
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoaModel){
        this.pessoa = pessoaModel;
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getTelefone(){
        return telefone;
    }

    public void setTelefone(Long telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}