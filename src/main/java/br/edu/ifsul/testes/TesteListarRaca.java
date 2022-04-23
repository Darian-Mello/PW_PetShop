/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Raca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 *
 * @author 20201pf.cc0017
 */
public class TesteListarRaca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Raca> lista = em.createQuery("from Raca order by id").getResultList();
        for (Raca r : lista) {
            System.out.println("\nID: " + r.getId() + "\nNome: " + r.getNome());
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
        em.close();
        emf.close();
    }
}
