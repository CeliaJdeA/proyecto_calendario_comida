package modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nutrientes")
public class Nutriente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nutriente")
	private int idNutriente;
	private String nombre;
	@OneToMany(mappedBy = "nutriente")
	private Set<Categoria> categorias;
	
	public Nutriente(){};	
	
	public Nutriente(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdNutriente() {
		return idNutriente;
	}
	public void setIdNutriente(int idNutriente) {
		this.idNutriente = idNutriente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Nutriente [idNutriente=" + idNutriente + ", nombre=" + nombre + "]";
	}
	
	
}
