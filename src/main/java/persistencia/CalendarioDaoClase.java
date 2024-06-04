package persistencia;

import java.util.List;
import java.util.Map;

import modelo.Calendario;
import modelo.Usuario;

public interface CalendarioDaoClase {

	public void save(Calendario calendario);
    public List<Calendario> findByUsuario(Usuario usuario);
    public List<Calendario> findByUsuarioAndDiaAndComidaCenaAndTipoNutriente(Usuario usuario, String dia, String comidaCena, String tipoNutriente);
}
