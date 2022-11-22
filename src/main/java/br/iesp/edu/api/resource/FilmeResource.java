package br.iesp.edu.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.service.FilmeService;

@RestController
@RequestMapping("/api/filme")
public class FilmeResource {
    
    @Autowired
    private FilmeService service;

    @PostMapping
    public Filme salvar(@RequestBody Filme filme){
        return service.salvar(filme);
    }

    @PutMapping
    public Filme atualizar(@RequestBody Filme filme) throws Exception{
        return service.atualizar(filme);
    }

    @DeleteMapping
    public void excluir(@RequestBody Filme filme) throws Exception{
        service.deletar(filme);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id) throws Exception{
        service.deletarPorId(id);
    }

    @GetMapping
    public List<Filme> listarFilme(){
        return service.listar();
    }
}
