package negocio;
import java.util.List;
import java.util.Set;

import modelo.Categoria;
import modelo.Ingrediente;

public interface Calendario {

	public List<Ingrediente> getIngredientes();
	public List<Categoria> getCategorias();
	public void addIngrediente (Ingrediente i);
	public void addCategoria (Categoria c);
	public void removeIngrediente (int idIngrediente);
	public List<Ingrediente> getIngConHidratos();
	public List<Ingrediente> getIngConProteinas();
	public List<Ingrediente> getIngConVegetales();
	public List<Ingrediente> getIngConGrasas();
	public Ingrediente getIngredienteById(int id);
	public List <Ingrediente> ordenarIngPorCat ();
}
