package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Categoria;
import modelo.Ingrediente;
import persistencia.IngredienteDao;
import negocio.CalendarioImpl;

public class CalendarioImplTest {

    private CalendarioImpl calendario;
    private IngredienteDao ingredienteDao;

    @BeforeEach
    void setUp() {
        // Configura el mock para el IngredienteDao
        ingredienteDao = mock(IngredienteDao.class);

        // Crea una instancia de CalendarioImpl con el mock de IngredienteDao
        calendario = new CalendarioImpl(ingredienteDao);
    }

    @Test
    void testGetIngredientes() {
    	// Crear algunas categorías
        Categoria categoria1 = new Categoria("Lácteos");

        // Prepara datos de prueba simulados
        List<Ingrediente> ingredientesEsperados = new ArrayList<>();
        ingredientesEsperados.add(new Ingrediente("Huevos",categoria1));


        // Configura el comportamiento del mock IngredienteDao
        when(ingredienteDao.findAll()).thenReturn(ingredientesEsperados);

        // Llama al método que quieres probar
        List<Ingrediente> ingredientesObtenidos = calendario.getIngredientes();

        // Verifica que el resultado obtenido sea el esperado
        assertEquals(ingredientesEsperados, ingredientesObtenidos);
    }
}

