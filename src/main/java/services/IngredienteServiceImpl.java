package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Ingrediente;

public class IngredienteServiceImpl implements IngredienteService{

	   // Lista para almacenar los ingredientes
    private List<Ingrediente> ingredientes = new ArrayList<>();

    // Constructor donde se inicializan los ingredientes
    public IngredienteServiceImpl() {
        // Aquí puedes agregar los ingredientes que desees mostrar
        ingredientes.add(new Ingrediente(1, "Tomate"));
        ingredientes.add(new Ingrediente(2, "Lechuga"));
        ingredientes.add(new Ingrediente(3, "Pechuga de pollo"));
    }

    @Override
    public List<Ingrediente> listar() {
        // Devolvemos la lista de ingredientes
        return ingredientes;
    }
}
