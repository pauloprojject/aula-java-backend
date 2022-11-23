package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.iesp.edu.api.enums.TipoPessoa;
import br.iesp.edu.api.interfaces.CnpjGroup;
import br.iesp.edu.api.interfaces.CpfGroup;
import br.iesp.edu.api.util.PessoaGroupSequenceProvider;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class Pessoa {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Email
    private String email;

    private String senha;

    // @Null
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "pessoa")
    private Set<Cartao> cartao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @Column(name = "cpf_cnpj")
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfOuCnpj;

    @ManyToMany
    @JoinTable(name = "pessoa_filme",
    joinColumns = 
            @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = true),
    inverseJoinColumns = 
            @JoinColumn(name = "filme_id", referencedColumnName = "id", nullable = true)
    )
    private Set<Filme> filmes;
}
