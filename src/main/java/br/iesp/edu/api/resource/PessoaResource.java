package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.entity.UserLogin;
import br.iesp.edu.api.service.PessoaService;
import br.iesp.edu.api.util.PessoaFilmesSeries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {


    private final PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> getUsers() {
        return (List<Pessoa>) pessoaService.listar();
    }

    @PostMapping
    public void addUser(@RequestBody Pessoa usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        pessoaService.salvar(usuario);
    }

    @DeleteMapping
    public void excluir(@RequestBody Pessoa pessoa) throws Exception{
        pessoaService.deletar(pessoa.getId());
    }

    @PutMapping
    public Pessoa atualizar(@RequestBody Pessoa pessoa) throws Exception{
        return pessoaService.atualizar(pessoa);
    }

    @GetMapping("/favoritos")
    public List<Filme> getFavoritos(@RequestParam PessoaFilmesSeries pessoaFilmesSeries){
        return pessoaService.getFavoritos(pessoaFilmesSeries);
    }

    // @PostMapping
    // public void login(@RequestBody UserLogin userLogin) throws Exception{
    //     return pessoaService.Login()
    // }
}
