package com.dimdim.web;
import com.dimdim.model.Usuario; import com.dimdim.service.*; import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller public class UsuarioController {
 private final UsuarioService service; public UsuarioController(UsuarioService s){service=s;}
 @GetMapping("/usuarios") public String listar(Model m){m.addAttribute("usuarios",service.listar());return "usuarios/lista";}
 @GetMapping("/usuarios/novo") public String novo(Model m){m.addAttribute("usuario",new Usuario());return "usuarios/form";}
 @PostMapping("/usuarios") public String criar(@Valid @ModelAttribute Usuario usuario,BindingResult r,RedirectAttributes a){if(!r.hasErrors())try{service.criar(usuario);a.addFlashAttribute("sucesso","Usuário criado com sucesso");return "redirect:/usuarios";}catch(RegraNegocioException e){r.rejectValue("email","duplicado",e.getMessage());}return "usuarios/form";}
 @GetMapping("/usuarios/{id}/editar") public String editar(@PathVariable Long id,Model m){m.addAttribute("usuario",service.buscar(id));return "usuarios/form";}
 @PostMapping("/usuarios/{id}") public String atualizar(@PathVariable Long id,@Valid @ModelAttribute Usuario usuario,BindingResult r,RedirectAttributes a){if(!r.hasErrors())try{service.atualizar(id,usuario);a.addFlashAttribute("sucesso","Usuário atualizado com sucesso");return "redirect:/usuarios";}catch(RegraNegocioException e){r.rejectValue("email","duplicado",e.getMessage());}usuario.setId(id);return "usuarios/form";}
 @PostMapping("/usuarios/{id}/excluir") public String excluir(@PathVariable Long id,RedirectAttributes a){service.excluir(id);a.addFlashAttribute("sucesso","Usuário excluído");return "redirect:/usuarios";}
}
