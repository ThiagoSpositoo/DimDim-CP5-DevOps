package com.dimdim.service;
import com.dimdim.model.Usuario; import com.dimdim.repository.UsuarioRepository; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class UsuarioService {
 private final UsuarioRepository repository; public UsuarioService(UsuarioRepository r){repository=r;}
 @Transactional(readOnly=true) public List<Usuario> listar(){return repository.findAll();}
 @Transactional(readOnly=true) public Usuario buscar(Long id){return repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Usuário "+id+" não encontrado"));}
 @Transactional public Usuario criar(Usuario u){if(repository.existsByEmail(u.getEmail())) throw new RegraNegocioException("E-mail já cadastrado"); u.setId(null); return repository.save(u);}
 @Transactional public Usuario atualizar(Long id,Usuario d){Usuario u=buscar(id); if(repository.existsByEmailAndIdNot(d.getEmail(),id)) throw new RegraNegocioException("E-mail já cadastrado"); u.setNome(d.getNome());u.setEmail(d.getEmail());return u;}
 @Transactional public void excluir(Long id){repository.delete(buscar(id));}
}
