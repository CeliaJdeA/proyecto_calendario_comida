package persistencia;

import java.util.List;
import java.util.Map;

public interface CalendarioDao {

	public void guardarIngredientes(int usuarioId, String dia, String comidaCena, String tipo, List<Integer> ingredienteIds);
	public Map<String, Map<String, List<String>>> obtenerIngredientesSeleccionados(int usuarioId);
}
