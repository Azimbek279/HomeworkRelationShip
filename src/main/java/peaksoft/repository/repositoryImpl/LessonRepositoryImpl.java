package peaksoft.repository.repositoryImpl;

import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.models.Course;
import peaksoft.models.Lesson;
import peaksoft.repository.LessonRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {
    private static EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public void saveLesson(Lesson lesson,Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            lesson.setCourse(course);
            entityManager.persist(lesson);
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("SAVE LESSON ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateLesson(Long lessonId,Lesson newLesson,Long courseId) {
        try{
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            Course course = entityManager.find(Course.class, courseId);
            lesson.setName(newLesson.getName());
            lesson.setTasks(newLesson.getTasks());
            lesson.setCourse(newLesson.getCourse());
            lesson.setTasks(newLesson.getTasks());
            lesson.setCourse(course);
            entityManager.merge(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("UPDATE LESSON ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET LESSON BY ID ##$$");
        return lesson;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        try{
            entityManager.getTransaction().begin();
            List<Course> courses = entityManager.createQuery("select  c  from Course c where c.id = :id", Course.class)
                    .setParameter("id", id).getResultList();
            Course course= courses.get(0);
            List<Lesson> lessons = new ArrayList<>(course.getLessons());
            System.out.println("GET LESSON BY COURSE ID ##$$");
            return lessons;
        }catch (HibernateException e){
            throw  new RuntimeException();
        }
    }
}
