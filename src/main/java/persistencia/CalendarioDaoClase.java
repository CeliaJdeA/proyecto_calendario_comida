package persistencia;

import java.util.List;
import java.util.Map;

import modelo.CalendarioClase;
import modelo.Usuario;

public interface CalendarioDaoClase {

	public void save(CalendarioClase calendario);
    public List<CalendarioClase> findByUsuario(Usuario usuario);
    public List<CalendarioClase> findByUsuarioAndDiaAndComidaCenaAndTipoNutriente(Usuario usuario, String dia, String comidaCena, String tipoNutriente);
}
