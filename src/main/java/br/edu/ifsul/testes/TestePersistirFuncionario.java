package br.edu.ifsul.testes;

import br.edu.ifsul.pw2022.model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirFuncionario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Funcionario f = new Funcionario ();
        f.setNome("João novo");
        f.setAtivo(true);
        f.setNomeUsuario("joao_novo");
        f.setSenha("1234");
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
