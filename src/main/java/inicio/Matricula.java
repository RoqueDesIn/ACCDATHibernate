package inicio;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class Matricula {

	
	@Id 
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name="foreigngen", parameters = @Parameter(name="property", value = "alumno") )
	//@OneToOne(cascade = CascadeType.ALL) 
	//@PrimaryKeyJoinColumn
	private int idAlumno;
	@Column
	private float coste;
	@Column
	private String nombre;
	@OneToOne(mappedBy = "matricula")
	private Alumno alumno;
	
	/**
	 * constructor
	 * @param idAlumno
	 * @param coste
	 * @param nombre
	 * @param alumno
	 */
	public Matricula(float coste, String nombre, Alumno alumno) {
		super();

		this.coste = coste;
		this.nombre = nombre;
		this.alumno = alumno;
	}
	
	/**
	 * constructor vacio
	 */
	protected Matricula() {
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
	/**
	 * Getters and setters
	 * @return
	 */

	public float getCoste() {
		return coste;
	}
	public void setCoste(float coste) {
		this.coste = coste;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
