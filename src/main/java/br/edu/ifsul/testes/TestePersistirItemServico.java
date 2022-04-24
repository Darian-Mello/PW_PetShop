package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.ItemServico;
import br.edu.ifsul.pw2022.model.OrdemServico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirItemServico {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        OrdemServico o = em.find(OrdemServico.class, 2);
        ItemServico i = new ItemServico();
        i.setQuantidade(1.0);
        i.setValorTotal(1.0);
        i.setValorUnitario(1.0);
        o.adicionarItemServico(i);
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
