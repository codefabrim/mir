

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Student;
import util.JPAUtil;

/**
 *  JPA CRUD Operations
 * @author Ramesh Fadatare
 *
 */
public class CRUDOperations {
    public void insertEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
//        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        //Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        Student student = new Student("Fabrice", "Miredin", "fmiredin7@gmail.com");
        Student student2 = new Student("Oana", "Miredin", "fmiredin7@gmail.com");
        Student student3 = new Student("Ines", "Miredin", "fmiredin7@gmail.com");


        entityManager.persist(student);
        entityManager.persist(student2);
        entityManager.persist(student3);
//        entityManager.(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());

        // The entity object is physically updated in the database when the transaction
        // is committed
        student.setFirstName("Fabrice Jean-luc");
        //student.setLastName("Fabrice Jean-luc");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}