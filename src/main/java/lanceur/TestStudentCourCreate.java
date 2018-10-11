package lanceur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cour;
import model.Student;



public class TestStudentCourCreate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Cour c1 = new Cour();
			Cour c2 = new Cour();
			Student s1 =  new Student();
			Student s2 =  new Student();
			c1.setTitle("Java");
			c2.setTitle("Anglais");
			s1.setName("Patrick");
			s2.setName("Asma");
			c1.addStudents(s1);
			c2.addStudents(s2);
			em.persist(s1);
			em.persist(s2);
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

	}

}
