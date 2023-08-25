package br.com.alura.scrennmatch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.alura.scrennmatch.domain.Filme;
import br.com.alura.scrennmatch.domain.DadoCadastroFilme;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaLista(Model model){
        model.addAttribute("lista", filmes);
        return "filmes/listagem";
    }
    
    @PostMapping
    public String cadastraFilme(DadoCadastroFilme dados, Model model){
        var filme = new Filme(dados);
        filmes.add(filme);

        return "redirect:/filmes";
    }
}
