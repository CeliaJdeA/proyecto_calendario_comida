package negocio;
import java.util.List;

import modelo.CalendarioClase;
import modelo.Categoria;
import modelo.Ingrediente;
import modelo.Usuario;

public interface Calendario {

	public List<Ingrediente> getIngredientes();
	public List<Categoria> getCategorias();
	public void addIngrediente (Ingrediente i);
	public void addCategoria (Categoria c);
	public void addUsuario (Usuario u);
	public Usuario getUsuarioByUsername(String username);
	public void removeIngrediente (int idIngrediente);
	public List<Ingrediente> getIngConHidratos();
	public List<Ingrediente> getIngConProteinas();
	public List<Ingrediente> getIngConVegetales();
	public List<Ingrediente> getIngConGrasas();
	public Ingrediente getIngredienteById(int id);
	public List <Ingrediente> ordenarIngPorCat ();
	public void guardarIngredienteEnCalendario(Usuario usuario, String dia, String comidaCena, String tipoNutriente, String ingrediente);
    public List<CalendarioClase> obtenerCalendarioPorUsuario(Usuario usuario);
}
