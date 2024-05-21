package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import persistencia.EMF;

public class JpaConnectionTest {

	public static void main(String[] args) {
       
        EntityManager em = EMF.getInstance().createEntityManager();

        String jpql = "select i from Ingrediente i";
        TypedQuery<Ingrediente> q = em.createQuery(jpql, Ingrediente.class);
        
        List<Ingrediente> ingredientes = q.getResultList();
        
        for (Ingrediente ingrdiente : ingredientes) {
        	System.out.println(ingrdiente);
        }
        em.close();
	}
}