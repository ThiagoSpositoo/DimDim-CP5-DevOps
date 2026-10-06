package com.dimdim.service;
import com.dimdim.model.*; import com.dimdim.repository.TransacaoRepository; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class TransacaoService {
 private final TransacaoRepository repository; private final UsuarioService usuarioService;
 public TransacaoService(TransacaoRepository r,UsuarioService u){repository=r;usuarioService=u;}
 @Transactional(readOnly=true) public List<Transacao> listar(){return repository.findAllByOrderByDataTransacaoDesc();}
 @Transactional(readOnly=true) public Transacao buscar(Long id){return repository.findWithUsuarioById(id).orElseThrow(()->new RecursoNaoEncontradoException("Transação "+id+" não encontrada"));}
 @Transactional public Transacao criar(TransacaoForm f){Transacao t=new Transacao(); preencher(t,f); return repository.save(t);}
 @Transactional public Transacao atualizar(Long id,TransacaoForm f){Transacao t=buscar(id); preencher(t,f); return t;}
 @Transactional public void excluir(Long id){repository.delete(buscar(id));}
 private void preencher(Transacao t,TransacaoForm f){t.setDescricao(f.getDescricao());t.setValor(f.getValor());t.setTipo(f.getTipo());t.setUsuario(usuarioService.buscar(f.getUsuarioId()));}
}
