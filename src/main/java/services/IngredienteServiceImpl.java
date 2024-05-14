package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Ingrediente;

public class IngredienteServiceImpl implements IngredienteService{


	@Override
	public List<Ingrediente> listar() {
		return Arrays.asList(new Ingrediente(1, "tomate"),
	             new Ingrediente(2, "garbanzos"),
	             new Ingrediente(3, "leche"));
	}
}