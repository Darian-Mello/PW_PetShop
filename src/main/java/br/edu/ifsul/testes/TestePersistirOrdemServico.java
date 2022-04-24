package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Funcionario;
import br.edu.ifsul.pw2022.model.OrdemServico;
import br.edu.ifsul.pw2022.model.Pessoa;
import br.edu.ifsul.pw2022.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class TestePersistirOrdemServico {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        OrdemServico o = new OrdemServico();
        o.setData(Calendar.getInstance());
        o.setDescricao("Teste");
        o.setValorTotal(0.0);
        o.setFuncionario(em.find(Funcionario.class, 3));
        o.setPessoa(em.find(Pessoa.class, 1));
        o.setPet(em.find(Pet.class, 1));
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
