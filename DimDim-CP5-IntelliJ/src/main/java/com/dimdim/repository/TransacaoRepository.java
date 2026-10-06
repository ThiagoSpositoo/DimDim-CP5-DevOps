package com.dimdim.repository;
import com.dimdim.model.Transacao; import org.springframework.data.jpa.repository.*; import java.util.*;
public interface TransacaoRepository extends JpaRepository<Transacao,Long>{
 @EntityGraph(attributePaths="usuario") List<Transacao> findAllByOrderByDataTransacaoDesc();
 @EntityGraph(attributePaths="usuario") Optional<Transacao> findWithUsuarioById(Long id);
}
