package modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private int idCategoria;
	private String nombre;
	@OneToMany(mappedBy = "categoria")
    private Set<Ingrediente> ingredientes;
	@ManyToOne
	@JoinColumn(name = "fk_nutriente")
	private Nutriente nutriente;
	

	// Constructor sin argumento
	public Categoria() {}
	// Constructor con argumento para el nombre
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	 public Nutriente getNutriente() {
		return nutriente;
	}
	public void setNutriente(Nutriente nutriente) {
		this.nutriente = nutriente;
	}
	@Override
	public String toString() {
		return "Categoria{idCategoria=" + idCategoria + ", nombre='" + nombre + '\'' +
	               ", nutriente=" + (nutriente != null ? nutriente.getNombre() : "null") + '}';
	}
}
