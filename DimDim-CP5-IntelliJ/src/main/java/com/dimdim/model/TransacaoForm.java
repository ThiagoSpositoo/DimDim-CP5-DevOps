package com.dimdim.model;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public class TransacaoForm {
 @NotBlank(message="Informe a descrição") @Size(max=200) private String descricao;
 @NotNull(message="Informe o valor") @DecimalMin(value="0.01",message="O valor deve ser maior que zero") private BigDecimal valor;
 @NotNull(message="Informe o tipo") private TipoTransacao tipo;
 @NotNull(message="Selecione o usuário") private Long usuarioId;
 public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
 public BigDecimal getValor(){return valor;} public void setValor(BigDecimal v){valor=v;}
 public TipoTransacao getTipo(){return tipo;} public void setTipo(TipoTransacao v){tipo=v;}
 public Long getUsuarioId(){return usuarioId;} public void setUsuarioId(Long v){usuarioId=v;}
}
