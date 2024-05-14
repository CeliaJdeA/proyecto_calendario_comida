package persistencia;

import java.util.List;

import modelo.Ingrediente;

/**
 * Retorna todos los productos registrados en la BBDD
 * @return lista de productos
 */
public interface IngredienteDao {
	public List<Ingrediente> findAll();
}
