package inicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainHibernate {

	public static void main(String[] args) {

		// abrir sesion Hibernate
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	
    	Session sesion = sf.openSession();
    	sesion.getTransaction().begin();
    	
    	Matricula matricula = new Matricula(500.0f,"2º DAM", new Alumno());
    	Alumno miAlumno1 = new Alumno("Nacho1","Lorenzo",45,matricula);
    	matricula.setAlumno(miAlumno1);
    	sesion.save(matricula);
    	
    	matricula = new Matricula(500.0f,"2º DAM", new Alumno());
    	Alumno miAlumno2 = new Alumno("Pepe2","Jordido",43, matricula);
    	matricula.setAlumno(miAlumno2);
    	sesion.save(matricula);

    	sesion.getTransaction().commit();
    	
    	sesion.close();
    	sf.close();
    	System.out.println("fin");
	}

}
