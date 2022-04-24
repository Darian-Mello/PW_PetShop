package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Produto;
import br.edu.ifsul.pw2022.model.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirProdutoServico {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Servico s = em.find(Servico.class, 1);
        Produto p1 = em.find(Produto.class, 1);
        Produto p2 = em.find(Produto.class, 2);
        s.getProdutos().add(p1);
        s.getProdutos().add(p2);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
