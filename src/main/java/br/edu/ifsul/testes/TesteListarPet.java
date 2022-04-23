/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Pet;
import br.edu.ifsul.pw2022.model.Raca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author 20201pf.cc0017
 */
public class TesteListarPet {
    public static void main(String[] args) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList();
        for (Pet p : lista) {
            System.out.println("\nID: " + p.getId() + "\nNome: " + p.getNome() + "\nEspecie: " + p.getEspecie()
            + "\nData de Nascimento: " + formato.format(p.getData_nascimento().getTime()) + "\nPeso: " + p.getPeso()
            + "\nRaça: " + p.getRaca().getNome());
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
        em.close();
        emf.close();
    }
}
