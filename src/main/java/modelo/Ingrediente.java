package modelo;

public class Ingrediente {
	private int idIngrediente;
	private String nombre;
	
	public Ingrediente() {
		
	}

	public Ingrediente(int idIngrediente, String nombre) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
