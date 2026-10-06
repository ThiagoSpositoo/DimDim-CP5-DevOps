package com.dimdim.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name="Transacao")
public class Transacao {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=200) private String descricao;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal valor;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private TipoTransacao tipo;
 @Column(name="data_transacao",nullable=false) private LocalDateTime dataTransacao=LocalDateTime.now();
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="usuario_id",nullable=false) private Usuario usuario;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
 public BigDecimal getValor(){return valor;} public void setValor(BigDecimal v){valor=v;}
 public TipoTransacao getTipo(){return tipo;} public void setTipo(TipoTransacao v){tipo=v;}
 public LocalDateTime getDataTransacao(){return dataTransacao;} public void setDataTransacao(LocalDateTime v){dataTransacao=v;}
 public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario v){usuario=v;}
}
