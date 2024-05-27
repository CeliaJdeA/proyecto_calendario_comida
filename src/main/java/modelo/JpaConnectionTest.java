package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistencia.EMF;

public class JpaConnectionTest {
    public static void main(String[] args) {
        EntityManager em = EMF.getInstance().createEntityManager();

        try {
            // Consultar todos los ingredientes
            String jpql = "SELECT i FROM Ingrediente i";
            TypedQuery<Ingrediente> query = em.createQuery(jpql, Ingrediente.class);
            List<Ingrediente> ingredientes = query.getResultList();

            // Imprimir cada ingrediente junto con su categoría y nutriente
            for (Ingrediente ingrediente : ingredientes) {
                Categoria categoria = ingrediente.getCategoria();
                Nutriente nutriente = categoria != null ? categoria.getNutriente() : null;
                System.out.println("Ingrediente: " + ingrediente.getNombre());
                System.out.println("  Categoria: " + (categoria != null ? categoria.getNombre() : "N/A"));
                System.out.println("  Nutriente: " + (nutriente != null ? nutriente.getNombre() : "N/A"));
            }
        } finally {
            em.close();
        }
    }
}
