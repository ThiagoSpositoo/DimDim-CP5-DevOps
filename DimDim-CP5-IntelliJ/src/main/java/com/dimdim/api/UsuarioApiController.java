package com.dimdim.api;
import com.dimdim.model.Usuario; import com.dimdim.service.UsuarioService; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/usuarios") public class UsuarioApiController {
 private final UsuarioService service; public UsuarioApiController(UsuarioService s){service=s;}
 @GetMapping public List<Usuario> listar(){return service.listar();} @GetMapping("/{id}") public Usuario buscar(@PathVariable Long id){return service.buscar(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Usuario criar(@Valid @RequestBody Usuario u){return service.criar(u);}
 @PutMapping("/{id}") public Usuario atualizar(@PathVariable Long id,@Valid @RequestBody Usuario u){return service.atualizar(id,u);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluir(id);}
}
