package br.edu.ifsul.pw2022.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_servico")
public class ItemServico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_item_servico", sequenceName = "seq_item_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(6,3)")
    private Double quantidade;

    @Min(value = 0, message = "O valor unitario não pode ser negativo")
    @NotNull(message = "O valor unitario deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(6,3)")
    private Double valorUnitario;

    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(6,3)")
    private Double valorTotal;

    @NotNull(message = "A ordem de servico deve ser informada")
    @ManyToOne
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordemServico;

    public ItemServico () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
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
        final ItemServico other = (ItemServico) obj;
        return Objects.equals(this.id, other.id);
    }
}
