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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author 20201pf.cc0017
 */
public class TestePersistirPet {
    public static void main(String[] args) throws ParseException {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dtNascimento = Calendar.getInstance();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        Pet p = new Pet();
        p.setNome("Gaudêncio");
        p.setRaca(r);
        dtNascimento.setTime(formato.parse("19/08/2005"));
        p.setData_nascimento(dtNascimento);
        p.setPeso(6.0);
        p.setEspecie("Cachorro");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
