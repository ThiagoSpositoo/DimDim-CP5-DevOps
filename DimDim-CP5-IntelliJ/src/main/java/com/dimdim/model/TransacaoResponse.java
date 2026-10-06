package com.dimdim.model;
import java.math.BigDecimal; import java.time.LocalDateTime;
public record TransacaoResponse(Long id,String descricao,BigDecimal valor,TipoTransacao tipo,LocalDateTime dataTransacao,Long usuarioId){
 public static TransacaoResponse de(Transacao t){return new TransacaoResponse(t.getId(),t.getDescricao(),t.getValor(),t.getTipo(),t.getDataTransacao(),t.getUsuario().getId());}
}
