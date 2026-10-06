package com.dimdim.repository;
import com.dimdim.model.Usuario; import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{ boolean existsByEmail(String email); boolean existsByEmailAndIdNot(String email,Long id); }
