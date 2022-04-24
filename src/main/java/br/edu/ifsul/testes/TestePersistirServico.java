package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Produto;
import br.edu.ifsul.pw2022.model.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirServico {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Servico s = new Servico();
        s.setNome("banho");
        s.setValor(20.0);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
