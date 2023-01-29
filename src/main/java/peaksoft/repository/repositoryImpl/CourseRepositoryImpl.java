package peaksoft.repository.repositoryImpl;

import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.models.Course;
import peaksoft.repository.CourseRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    private static EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public void saveCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("SAVE COURSE ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Course getCourseById(Long courseId) {
        try{
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("GET COURSE ##$$");
            return course;
        }catch (HibernateException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<List<Course>> getAllCourse(String ascOrDesc) {
        List<List<Course>> returnList = new ArrayList<>();
        try {
            switch (ascOrDesc){
                case "asc" -> {
                    entityManager.getTransaction().begin();
                    List<Course> coursesAsc = entityManager.createQuery("select c from Course c order by c.createAt asc ", Course.class).getResultList();
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    System.out.println("GET ALL COURSE ASC ##$$");
                    returnList.add(coursesAsc);

                }
                case "desc" -> {
                    entityManager.getTransaction().begin();
                    List<Course> coursesDesc = entityManager.createQuery("select c from Course c order by c.createAt desc ", Course.class).getResultList();
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    System.out.println("GET ALL COURSE DESC ##$$");
                    returnList.add(coursesDesc);
                }
            }
        }catch (HibernateException e) {
            throw new RuntimeException();
        }
        return returnList;
    }

    @Override
    public void updateCourse(Long courseId,Course newCourse) {
        try{
            entityManager.getTransaction().begin();
            Course course1 = entityManager.find(Course.class, courseId);
            course1.setCourseName(newCourse.getCourseName());
            course1.setDuration(newCourse.getDuration());
            course1.setCreateAt(newCourse.getCreateAt());
            course1.setImageLink(newCourse.getImageLink());
            course1.setDescription(newCourse.getDescription());
            entityManager.merge(course1);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("UPDATE COURSE ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteByCourseId(Long courseId) {
        try{
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("DELETE COURSE-BY-ID ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Course getCourseName(String name) {
        try{
            entityManager.getTransaction().begin();
            List<Course> list = entityManager.createQuery("select c from Course c",Course.class).getResultList();
            entityManager.getTransaction().commit();
            for (Course c: list) {
                if (c.getCourseName().equals(name)){
                    return c;
                }
            }
            return null;
        }catch (HibernateException e){
            throw  new RuntimeException();
        }
    }
}
