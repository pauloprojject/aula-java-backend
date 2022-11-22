package br.iesp.edu.api.service;


import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.repository.CartaoRepository;
import br.iesp.edu.api.repository.PessoaRepository;
import br.iesp.edu.api.util.Criptografar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public Pessoa salvar(Pessoa pessoa) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        String senhaCriptografada = Criptografar.Executar(pessoa.getSenha());

        pessoa.setSenha(senhaCriptografada);

        cartaoRepository.save(pessoa.getCartao());

        return repository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) throws Exception {
        if(pessoa.getId()==null){
            throw new Exception("ID não encontrado");
        }
        return repository.save(pessoa);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public List<Pessoa> listar(){
        return repository.findAll();
    }
}
