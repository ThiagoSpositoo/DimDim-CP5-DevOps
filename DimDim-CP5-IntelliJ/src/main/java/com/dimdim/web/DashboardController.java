package com.dimdim.web;
import com.dimdim.model.*; import com.dimdim.service.*; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping; import java.math.BigDecimal; import java.util.*;
@Controller public class DashboardController {
 private final UsuarioService usuarios; private final TransacaoService transacoes;
 public DashboardController(UsuarioService u,TransacaoService t){usuarios=u;transacoes=t;}
 @GetMapping("/dashboard") public String dashboard(Model m){var us=usuarios.listar();var ts=transacoes.listar();BigDecimal entradas=total(ts,TipoTransacao.ENTRADA),saidas=total(ts,TipoTransacao.SAIDA);m.addAttribute("totalUsuarios",us.size());m.addAttribute("qtdTransacoes",ts.size());m.addAttribute("entradas",entradas);m.addAttribute("saidas",saidas);m.addAttribute("saldo",entradas.subtract(saidas));m.addAttribute("ultimas",ts.stream().limit(5).toList());return "dashboard";}
 private BigDecimal total(List<Transacao> ts,TipoTransacao tipo){return ts.stream().filter(t->t.getTipo()==tipo).map(Transacao::getValor).reduce(BigDecimal.ZERO,BigDecimal::add);}
}
