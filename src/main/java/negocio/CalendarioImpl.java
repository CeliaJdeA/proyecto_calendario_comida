package negocio;

import java.util.List;


import modelo.Categoria;
import modelo.Ingrediente;
import persistencia.CategoriaDao;
import persistencia.IngredienteDao;

public class CalendarioImpl implements Calendario{

	private IngredienteDao iDao;
    private CategoriaDao cDao;
    
    public CalendarioImpl(IngredienteDao iDao, CategoriaDao cDao) {
        this.iDao = iDao;
        this.cDao = cDao;
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
}
