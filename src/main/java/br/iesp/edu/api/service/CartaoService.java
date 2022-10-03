package br.iesp.edu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iesp.edu.api.entity.Cartao;
import br.iesp.edu.api.repository.CartaoRepository;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository repository;

    public Cartao save (Cartao cartao){
        return repository.save(cartao);
    }

    public Cartao update(Cartao cartao) throws Exception{
        if(cartao.getId()==null){
            throw new Exception("ID não encontrado");
        }
        return repository.save(cartao);
    }

    public void deletar(Cartao cartao) throws Exception{
        if(cartao.getId()==null){
            throw new Exception("ID não encontrado");
        }
        repository.delete(cartao);
    }

    public List<Cartao> listar(){
        return repository.findAll();
    }

}
