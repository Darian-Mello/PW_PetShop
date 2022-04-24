package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirProduto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Produto p1 = new Produto();
        p1.setNome("perfume");
        p1.setValor(12.0);
        Produto p2 = new Produto();
        p2.setNome("shampoo");
        p2.setValor(20.0);
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
