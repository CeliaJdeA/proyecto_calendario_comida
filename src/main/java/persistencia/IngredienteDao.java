package persistencia;

import java.util.List;

import modelo.Ingrediente;

public interface IngredienteDao {

	public List<Ingrediente> findAll();
	
	public void save(Ingrediente i);
}
