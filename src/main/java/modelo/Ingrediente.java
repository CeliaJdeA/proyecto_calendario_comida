package modelo;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private int idIngrediente;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "fk_categoria")
	private Categoria categoria;
	@OneToMany(mappedBy = "ingrediente")
	private List<CalendarioClase> calendario;


	 // Constructor sin argumentos requerido por JPA
    public Ingrediente() {
        // Constructor vacío
    }
	
	// Constructor con parámetros para nombre de ingrediente y objeto de tipo Categoria
    public Ingrediente(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }
	

   
	public List<CalendarioClase> getCalendario() {
		return calendario;
	}

	public void setCalendario(List<CalendarioClase> calendario) {
		this.calendario = calendario;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
    public String toString() {
        return "Ingrediente{id=" + idIngrediente + ", nombre='" + nombre + '\'' +
                ", categoria=" + (categoria != null ? categoria.getNombre() : "null") + '}';
    }
}
