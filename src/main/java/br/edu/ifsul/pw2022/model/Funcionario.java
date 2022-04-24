package br.edu.ifsul.pw2022.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {
    @NotBlank(message = "O nome de usuário não pode ser em branco")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false, unique = true)
    private String nomeUsuario;

    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 50, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    @NotNull(message = "O campo ativo não pode estar em branco!")
    @Column(name = "ativo", nullable = false, columnDefinition = "boolean default true")
    private Boolean ativo;

    public Funcionario () {

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
