package modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calendario_comidas")
public class IngredienteMySQL {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private int idIngrediente;
	private String nombre;
	@Column(name = "fk_lista_compra")
	private int lista;
	
	
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
	public int getLista() {
		return lista;
	}
	public void setLista(int lista) {
		this.lista = lista;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idIngrediente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredienteMySQL other = (IngredienteMySQL) obj;
		return idIngrediente == other.idIngrediente;
	}
	
	
}
