package persistencia;

import java.util.List;

import modelo.Ingrediente;

public interface IngredienteDao {

	public List<Ingrediente> findAll();
	
	public void save(Ingrediente i);
	
	public Ingrediente findByNombre (String nombre);
	
	public Ingrediente remove (int idIngrediente);
	

}
