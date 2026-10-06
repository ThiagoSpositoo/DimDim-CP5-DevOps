package com.dimdim.web;
import com.dimdim.service.UsuarioService; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeController { private final UsuarioService service; public HomeController(UsuarioService s){service=s;} @GetMapping("/") public String home(Model m){m.addAttribute("temUsuarios",!service.listar().isEmpty());return "landing";} }
