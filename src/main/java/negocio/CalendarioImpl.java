package negocio;

import java.text.Collator;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import modelo.CalendarioClase;
import modelo.Categoria;
import modelo.Ingrediente;
import modelo.Usuario;
import persistencia.CalendarioDaoClase;
import persistencia.CategoriaDao;
import persistencia.IngredienteDao;
import persistencia.UsuarioDao;

public class CalendarioImpl implements Calendario{

	private IngredienteDao iDao;
    private CategoriaDao cDao;
    private UsuarioDao uDao;
    private CalendarioDaoClase calDao;
    
    public CalendarioImpl(IngredienteDao iDao, CategoriaDao cDao, UsuarioDao uDao) {
        this.iDao = iDao;
        this.cDao = cDao;
        this.uDao = uDao;
    } 
	
	@Override
	public List<Ingrediente> getIngredientes() {
		return iDao.findAll();
	}

	@Override
	public List<Categoria> getCategorias() {
		return cDao.findAll();
	}

	@Override
	public void addIngrediente(Ingrediente i) {
		iDao.save(i);
	}

	@Override
	public void addCategoria(Categoria c) {
		cDao.save(c);
	}

	@Override
	public void removeIngrediente(int idIngrediente) {
		iDao.remove(idIngrediente);
		
	}

	@Override
	public List<Ingrediente> getIngConHidratos() {
		return iDao.getIngConNutrientes("Hidratos de carbono");
	}

	@Override
	public List<Ingrediente> getIngConProteinas() {
		return iDao.getIngConNutrientes("Proteínas");
	}

	@Override
	public List<Ingrediente> getIngConVegetales() {
		return iDao.getIngConNutrientes("Vitaminas y minerales");
	}

	@Override
	public List<Ingrediente> getIngConGrasas() {
		return iDao.getIngConNutrientes("Grasas");
	}

	@Override
	public Ingrediente getIngredienteById(int id) {
		return iDao.findById(id);
	}

/*	Si se desea eliminar duplicados automáticamente y no se requiere un orden específico, un Set puede ser apropiado. 
    Sin embargo, si se necesita mantener el orden de los elementos o permitir duplicados en diferentes categorías, un List 
    sería más adecuado. En este caso, parece que un List sería más apropiado, ya que es posible que quieras mantener el orden
    original de los ingredientes y permitir ingredientes duplicados en diferentes categorías.*/	
	
	@Override
	public List<Ingrediente> ordenarIngPorCat() {
/*      Se obtiene una lista de todos los ingredientes utilizando el método 'findAll' del IngredienteDao (iDao), 
 		que parece ser una fuente de datos que proporciona acceso a los ingredientes almacenados. La lista de ingredientes se 
 		almacena en la variable ingredientes.*/		
		List<Ingrediente> ingredientes = iDao.findAll();
/*		Aquí se ordena la lista de ingredientes utilizando el método sort, que toma un comparador como argumento para 
 		definir el orden de clasificación. Se crea un nuevo comparador anónimo que compara dos ingredientes (o1 y o2) basándose en 
 		el nombre de la categoría a la que pertenecen.*/		
	    ingredientes.sort(new Comparator<Ingrediente>() {
	        @Override
	        public int compare(Ingrediente o1, Ingrediente o2) { // Este método devuelve un entero (int)
/*				Se crea un objeto Collator para realizar la comparación de cadenas. Collator se usa aquí para comparar 
 				los nombres de las categorías en español.*/	        	
	            Collator col = Collator.getInstance(new Locale("es"));
	            return col.compare(o1.getCategoria().getNombre(), o2.getCategoria().getNombre());
	        }
	    });
	    return ingredientes;
	}

	@Override
	public void addUsuario(Usuario u) {
		uDao.save(u);
		
	}

	@Override
	public Usuario getUsuarioByUsername(String username) {
		return uDao.findByUsername(username);
	}

	@Override
	public void guardarIngredienteEnCalendario(Usuario usuario, String dia, String comidaCena, String tipoNutriente,
			String ingrediente) {
		Ingrediente ingrediente1 = iDao.findByNombre(ingrediente);
        if (ingrediente1 != null) {
            CalendarioClase calendario = new CalendarioClase();
            calendario.setUsuario(usuario);
            calendario.setDia(dia);
            calendario.setComidaCena(comidaCena);
            calendario.setTipoNutriente(tipoNutriente);
            calendario.setIngrediente(ingrediente1);
            calDao.save(calendario);
        }
		
	}

	@Override
	public List<CalendarioClase> obtenerCalendarioPorUsuario(Usuario usuario) {
		return calDao.findByUsuario(usuario);
	}

}
