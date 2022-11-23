package br.iesp.edu.api.entity;

import java.time.YearMonth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cartao {

    @Id
    @GeneratedValue
    private Integer id;
    @CreditCardNumber
    private String numeroCartao;
    @JsonFormat(pattern = "MM/yyyy")
    private YearMonth validade;
    private String codigoSeguranca;
    private String nome;
    // @Null
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
