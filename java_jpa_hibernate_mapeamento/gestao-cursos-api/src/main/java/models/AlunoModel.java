package org.example.models;

import org.example.entities.Aluno;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {
    public static void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno alunoBuscado = em.find(Aluno.class, id);
        return alunoBuscado;
    }

    public static List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database_admin_jpa.db");
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM " + Aluno.class.getName()).getResultList();
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database_admin_jpa.db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluno atualizacao = em.merge(aluno);
        em.getTransaction().commit();
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database_admin_jpa.db");
        EntityManager em = emf.createEntityManager();
        Aluno alunoBuscado = em.find(Aluno.class, aluno);
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
    }
}
