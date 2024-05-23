package persistencia;

import java.util.List;

import modelo.Categoria;


public interface CategoriaDao {

	public List<Categoria> findAll();
	
	public void save (Categoria c);
	
	public Categoria findById(int id);
}
