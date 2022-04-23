/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20201pf.cc0017
 */
@Entity
@Table(name = "pet")
public class Pet implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pet", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres!")
    @NotBlank(message = "O nome não pode estar em branco!")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de nascimento deve ser informada!")	
    @Column(name = "data_nascimento", nullable = false)
    private Calendar data_nascimento;
    
    @NotBlank(message = "O peso não pode estar em branco!")
    @Column(name = "peso", nullable = false)
    private Double peso;
    
    @Length(max = 40, message = "A Especie não pode ter mais de {max} caracteres!")
    @NotBlank(message = "A Especie não pode estar em branco!")
    @Column(name = "especie", length = 40, nullable = false)
    private String especie;
    
    @NotNull(message = "A Raca deve ser informada!")
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable = false)
    private Raca raca;
    
    public Pet () {
        
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

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
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
        final Pet other = (Pet) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
