package lanceur;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cour;
import model.Student;

public class TestStudentCourReccupListe {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Student s = null;
		try {
			txn.begin();
			Cour c = em.find(Cour.class, 1L);
			 s= em.find(Student.class, 1L);
			Set<Student>students=c.getStudents();
			students.size();
			c.setTitle("Math");
			txn.commit();
			
		}catch(Exception e) {
			if(txn!=null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(em!=null) {
				em.close();
			}
			if(emf!=null) {
				emf.close();
			}
			
		}
		System.out.println(s.getCours());
	}

}
