package persistencia;

import java.util.List;

import modelo.Ingrediente;

public interface IngredienteDao {

	public List<Ingrediente> findAll();
	
	public void save(Ingrediente i);
	
	public Ingrediente findByNombre (String nombre);
	
	public Ingrediente remove (int idIngrediente);
	
	public List<Ingrediente> getIngConNutrientes(String nombreNutriente);

	public Ingrediente findById(int idIngrediente);

	// Utilizo String porque no quiero que me devuelva el objeto Ingrediente, sino el nombre del ingrediente (String)
	public String getNombreIngPorId(String idIngrediente);
}
