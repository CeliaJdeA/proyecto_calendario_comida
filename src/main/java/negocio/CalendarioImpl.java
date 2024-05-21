package negocio;

import java.util.List;


import modelo.Ingrediente;
import persistencia.IngredienteDao;

public class CalendarioImpl implements Calendario{

	private IngredienteDao iDao;
	
	public CalendarioImpl(IngredienteDao iDao) {
        this.iDao = iDao;
    } 
	
	@Override
	public List<Ingrediente> getIngredientes() {
		return iDao.findAll();
	}
}
