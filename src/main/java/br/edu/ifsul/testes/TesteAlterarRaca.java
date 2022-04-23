/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0017
 */
public class TesteAlterarRaca {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 2);
        r.setNome("Pastor Alemão");
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
