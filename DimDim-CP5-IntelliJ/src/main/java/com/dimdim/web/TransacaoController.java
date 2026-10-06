package com.dimdim.web;
import com.dimdim.model.*; import com.dimdim.service.*; import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/transacoes") public class TransacaoController {
 private final TransacaoService service; private final UsuarioService usuarioService; public TransacaoController(TransacaoService s,UsuarioService u){service=s;usuarioService=u;}
 @GetMapping public String listar(Model m){m.addAttribute("transacoes",service.listar());return "transacoes/lista";}
 @GetMapping("/novo") public String novo(@RequestParam(required=false) Long usuarioId,Model m){TransacaoForm f=new TransacaoForm();f.setUsuarioId(usuarioId);return formulario(m,f,null);}
 @PostMapping public String criar(@Valid @ModelAttribute("form") TransacaoForm f,BindingResult r,Model m,RedirectAttributes a){if(!r.hasErrors()){service.criar(f);a.addFlashAttribute("sucesso","Transação criada com sucesso");return "redirect:/transacoes";}return formulario(m,f,null);}
 @GetMapping("/{id}/editar") public String editar(@PathVariable Long id,Model m){Transacao t=service.buscar(id);TransacaoForm f=new TransacaoForm();f.setDescricao(t.getDescricao());f.setValor(t.getValor());f.setTipo(t.getTipo());f.setUsuarioId(t.getUsuario().getId());return formulario(m,f,id);}
 @PostMapping("/{id}") public String atualizar(@PathVariable Long id,@Valid @ModelAttribute("form") TransacaoForm f,BindingResult r,Model m,RedirectAttributes a){if(!r.hasErrors()){service.atualizar(id,f);a.addFlashAttribute("sucesso","Transação atualizada com sucesso");return "redirect:/transacoes";}return formulario(m,f,id);}
 @PostMapping("/{id}/excluir") public String excluir(@PathVariable Long id,RedirectAttributes a){service.excluir(id);a.addFlashAttribute("sucesso","Transação excluída");return "redirect:/transacoes";}
 private String formulario(Model m,TransacaoForm f,Long id){m.addAttribute("form",f);m.addAttribute("transacaoId",id);m.addAttribute("usuarios",usuarioService.listar());m.addAttribute("tipos",TipoTransacao.values());return "transacoes/form";}
}
