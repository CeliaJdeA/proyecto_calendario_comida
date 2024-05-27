package negocio;
import java.util.List;

import modelo.Categoria;
import modelo.Ingrediente;

public interface Calendario {

	public List<Ingrediente> getIngredientes();
	public List<Categoria> getCategorias();
	public void addIngrediente (Ingrediente i);
	public void addCategoria (Categoria c);
	public void removeIngrediente (int idIngrediente);
	
}
