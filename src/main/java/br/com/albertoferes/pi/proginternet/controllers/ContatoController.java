package br.com.albertoferes.pi.proginternet.controllers;

import br.com.albertoferes.pi.proginternet.model.Contato;
import br.com.albertoferes.pi.proginternet.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ContatoController {
    private static final String ADICIONAR = "adicionar";

    private ContatoService service;

    @Autowired
    public ContatoController(ContatoService service) {
        System.out.println("ContatoController inicializado!");
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Contato contato){
        return ADICIONAR;
    }

    @GetMapping("/todos")
    public String homePage(Model model){
        model.addAttribute("contatos", service.buscarTodos());
        return "contatos";
    }

    @PostMapping("/add")
    public String adicionarUsuario(@Valid Contato contato, BindingResult result, Model model){
        if (result.hasErrors()){
            return ADICIONAR;
        }
        service.salvar(contato);
        model.addAttribute("contatos", service.buscarTodos());
        return "contatos";
    }

    @GetMapping("/edit/{id}")
    public String exibirFormularioAtualizacao(@PathVariable("id")int id, Model model){
        Contato contato = service.buscar(id);
        model.addAttribute("contato", contato);
        return "atualizar";
    }

    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable("id") int id, @Valid Contato contato, BindingResult result, Model model){
        if (result.hasErrors()){
            contato.setId(id);
            return "atualizar";
        }
        service.salvar(contato);
        model.addAttribute("contatos", service.buscarTodos());
        return "contatos";
    }

    @GetMapping("/delete/{id}")
    public String apagarUsuario(@PathVariable("id") int id, Model model){
        service.apagar(id);
        model.addAttribute("contatos", service.buscarTodos());
        return "contatos";
    }
}
