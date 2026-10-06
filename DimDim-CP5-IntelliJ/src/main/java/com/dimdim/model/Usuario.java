package com.dimdim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Informe o nome") @Size(max=100)
    @Column(nullable=false, length=100) private String nome;
    @NotBlank(message="Informe o e-mail") @Email @Size(max=150)
    @Column(nullable=false, unique=true, length=150) private String email;
    @JsonIgnore @OneToMany(mappedBy="usuario", cascade=CascadeType.REMOVE)
    private List<Transacao> transacoes = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public List<Transacao> getTransacoes(){return transacoes;} public void setTransacoes(List<Transacao> v){this.transacoes=v;}
}
