package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Pedro da Silva");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
