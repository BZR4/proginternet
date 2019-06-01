package br.com.albertoferes.pi.proginternet.service;

import br.com.albertoferes.pi.proginternet.model.Contato;
import br.com.albertoferes.pi.proginternet.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository repository;

    public Contato salvar(Contato contato){
        return repository.save(contato);
    }

    public Contato buscar(int id){
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("ID: "+id+" nao encontrado!"));
    }

    public Contato editar(Contato contato){
        return repository.save(contato);
    }

    public void apagar(Contato contato){
        repository.delete(contato);
    }

    public void apagar(int id){
        Contato contato = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID: "+id+" nao encontrado!"));
        repository.delete(contato);
    }

    public List<Contato> buscarTodos(){
        return repository.findAll();
    }
}
