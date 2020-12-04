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
    	
    	Matricula matricula = new Matricula(1,500.0f,"2º DAM", new Alumno());
    	sesion.save(matricula);
    	Alumno miAlumno1 = new Alumno(2,"Nacho","Lorenzo",45,matricula);
    	sesion.save(matricula);
    	
    	matricula.setAlumno(miAlumno1);
    	Alumno miAlumno2 = new Alumno(25,"Pepe","Jordido",43, matricula);
    	matricula.setAlumno(miAlumno2);
    	sesion.save(matricula);

    	sesion.save(miAlumno1);
    	sesion.save(miAlumno2);
    	sesion.getTransaction().commit();
    	
    	sesion.close();
    	sf.close();
    	System.out.println("fin");
	}

}
