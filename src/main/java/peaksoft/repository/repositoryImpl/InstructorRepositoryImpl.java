package peaksoft.repository.repositoryImpl;

import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.models.Course;
import peaksoft.models.Instructor;
import peaksoft.repository.InstructorRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository {
    private static EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public void saveInstructor(Instructor instructor) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("SAVE INSTRUCTOR ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateInstructor(Long id,Instructor newInstructor) {
        try{
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            instructor.setFirstName(newInstructor.getFirstName());
            instructor.setLastName(newInstructor.getLastName());
            instructor.setEmail(newInstructor.getEmail());
            instructor.setPhoneNumber(newInstructor.getPhoneNumber());
            instructor.setCourses(newInstructor.getCourses());
            entityManager.merge(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("UPDATE INSTRUCTOR ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        try{
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("GET INSTRUCTOR BY ID ##$$");
            return instructor;
        }catch (HibernateException e){
            throw  new RuntimeException();
        }
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        try{
            entityManager.getTransaction().begin();
            List<Course> courses = entityManager.createQuery("select c from Course c where c.id = :id", Course.class)
                    .setParameter("id", id).getResultList();
            Course course = courses.get(0);
            List<Instructor> instructors = new ArrayList<>(course.getInstructors());
            System.out.println("GET INSTRUCTOR BY COURSE ID ##$$");
            return instructors;
        }catch (HibernateException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteInstructorById(Long instructorId) {
        try{
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("DELETE INSTRUCTOR BY ID ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        try{
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            Course course = entityManager.find(Course.class,courseId);
            instructor.getCourses().add(course);
            course.getInstructors().add(instructor);
            entityManager.merge(instructor);
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("ASSIGN INSTRUCTOR TO COURSE ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }
}
