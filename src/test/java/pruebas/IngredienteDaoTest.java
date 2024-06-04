package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Categoria;
import modelo.Ingrediente;
import persistencia.IngredienteDao;
import persistencia.UsuarioDao;
import persistencia.CategoriaDao;
import negocio.CalendarioImpl;

public class IngredienteDaoTest {

    private IngredienteDao ingredienteDao;
    private CategoriaDao categoriaDao;
    private UsuarioDao usuarioDao;
    private CalendarioImpl calendario;

    @BeforeEach
    public void setUp() {
        // Crear instancias de IngredienteDao y CategoriaDao mock
        ingredienteDao = mock(IngredienteDao.class);
        categoriaDao = mock(CategoriaDao.class);

        // Crear una instancia de CalendarioImpl con los DAOs mock
        calendario = new CalendarioImpl(ingredienteDao, categoriaDao, usuarioDao);
    }

    @Test
    public void testGetIngredientes() {
        // Crear algunas categorías
        Categoria categoria1 = new Categoria("Legumbres");
        Categoria categoria2 = new Categoria("Frutas");

        // Crear algunos ingredientes con sus respectivas categorías
        Ingrediente ingrediente1 = new Ingrediente("Lentejas", categoria1);
        Ingrediente ingrediente2 = new Ingrediente("Manzana", categoria2);
        List<Ingrediente> ingredientes = Arrays.asList(ingrediente1, ingrediente2);

        // Configurar el comportamiento del dao mock para que devuelva la lista de ingredientes
        when(ingredienteDao.findAll()).thenReturn(ingredientes);

        // Llamar al método que queremos probar en la clase CalendarioImpl
        List<Ingrediente> resultado = calendario.getIngredientes();

        // Verificar que el método devuelve la lista esperada
        assertEquals(2, resultado.size());
        assertEquals("Lentejas", resultado.get(0).getNombre());
        assertEquals("Frutas", resultado.get(1).getCategoria().getNombre());
    }
}



