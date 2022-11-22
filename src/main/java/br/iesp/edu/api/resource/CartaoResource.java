package br.iesp.edu.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.iesp.edu.api.entity.Cartao;
import br.iesp.edu.api.service.CartaoService;

@RestController
@RequestMapping("/api/cartao")
public class CartaoResource {
    
    @Autowired
    private CartaoService service;

    @GetMapping
    public List<Cartao> ListarCartao(){
        return service.listar();
    }

    @PutMapping
    public Cartao Atualizar(@RequestBody Cartao cartao) throws Exception{
        return service.update(cartao);
    }

    @PostMapping
    public Cartao Criar(@RequestBody Cartao cartao) throws Exception{
        return service.save(cartao);
    }

    @DeleteMapping
    public void Deletar(@RequestBody Cartao cartao) throws Exception{
        service.deletar(cartao);
    }
    
}
