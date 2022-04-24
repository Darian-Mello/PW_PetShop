package br.edu.ifsul.pw2022.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 50, message = "A descricao não pode ter mais de {max} caracteres!")
    @NotBlank(message = "O campo descricao não pode estar em branco!")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada!")
    @Column(name = "data", nullable = false)
    private Calendar data;

    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(6,3)")
    private Double valorTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itens_servico = new ArrayList<>();

    public OrdemServico () {

    }

    public void adicionarItemServico(ItemServico obj){
        obj.setOrdemServico(this);
        this.getItens_servico().add(obj);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ItemServico> getItens_servico() {
        return itens_servico;
    }

    public void setItens_servico(List<ItemServico> itens_servico) {
        this.itens_servico = itens_servico;
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
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }
}
