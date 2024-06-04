package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendario")
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calendario")
	private int idCalendario;
	private String dia;
	private String comidaCena;
	private String tipoNutriente;
	@OneToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	@OneToMany
	@JoinColumn(name = "fk_ingrediente")
	private List <Ingrediente> ingrediente;
	
	
	public int getIdCalendario() {
		return idCalendario;
	}
	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getComidaCena() {
		return comidaCena;
	}
	public void setComidaCena(String comidaCena) {
		this.comidaCena = comidaCena;
	}
	public String getTipoNutriente() {
		return tipoNutriente;
	}
	public void setTipoNutriente(String tipoNutriente) {
		this.tipoNutriente = tipoNutriente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Ingrediente> getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
}
