package br.iesp.edu.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

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
    private Long id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Email
    private String email;

    private String senha;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @Column(name = "cpf_cnpj")
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfOuCnpj;
}
