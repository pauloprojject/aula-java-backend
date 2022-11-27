package br.iesp.edu.api.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.enums.Perfil;
import br.iesp.edu.api.repository.FilmeRepository;
import br.iesp.edu.api.util.Criptografar;
import br.iesp.edu.api.util.FilmeAdmin;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme salvar(FilmeAdmin filmeAdmin) throws Exception{
        Pessoa pessoa = repository.findByCpf(filmeAdmin.getCpf());
        if(pessoa == null){
            throw new Exception("Pessoa não cadastrada");
        }
        if(pessoa.getSenha() != Criptografar.Executar(filmeAdmin.getSenha())){
            throw new Exception("Senha errada");
        }
        if(pessoa.getPerfil() != Perfil.ADMIN){
            throw new Exception("Não é administrador");
        }

        return repository.save(filmeAdmin.getFilme());
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
