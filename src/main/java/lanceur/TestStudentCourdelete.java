package lanceur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cour;
import model.Student;

public class TestStudentCourdelete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Cour c = em.find(Cour.class, 1L);
			Student s= em.find(Student.class, 1L);
			s.getCours().remove(c);
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
