package br.edu.ifsul.pw2022.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "servico")
public class Servico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres!")
    @NotBlank(message = "O nome não pode estar em branco!")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(6,3)")
    private Double valor;

    @ManyToMany
    @JoinTable(name = "produto_servico",
            joinColumns =
            @JoinColumn(name = "servico", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns =
            @JoinColumn(name = "produto", referencedColumnName = "id",
                    nullable = false)
    )
    private Set<Produto> produtos = new HashSet<>();

    public Servico () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        return Objects.equals(this.id, other.id);
    }
}
