package com.dimdim.model;
public enum TipoTransacao { ENTRADA("Entrada"), SAIDA("Saída"); private final String descricao; TipoTransacao(String d){descricao=d;} public String getDescricao(){return descricao;} }
