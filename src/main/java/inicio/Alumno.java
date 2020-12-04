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
import org.hibernate.annotations.Type;

@Entity
@Table
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumno;
	@Column 
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@OneToOne (cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Matricula matricula;
	
	public Alumno(String nombre, String apellido, int edad, Matricula matricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.matricula=matricula;
	}
	
	/**
	 * constructor vacio
	 */
	public Alumno() {
	
	}
	
	/**
	 * getters and setters
	 * @return
	 */
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public void setIdAlumno(int id) {
		this.idAlumno = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	
}
