package br.iesp.edu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        return repository.save(filme);
    }

    public Filme atualizar(Filme filme) throws Exception {
        if(filme.getId()==null){
            throw new Exception("ID não encontrado");
        }
        return repository.save(filme);
    }

    public void deletar(Filme filme) throws Exception{
        if(filme.getId()==null){
            throw new Exception("ID não encontrado");
        }
        repository.delete(filme);
    }

    public void deletarPorId(Integer id) throws Exception{
        repository.deleteById(id);
    }

    public List<Filme> listar(){
        return repository.findAll();
    }
}
