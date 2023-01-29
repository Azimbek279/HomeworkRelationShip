package peaksoft.repository.repositoryImpl;

import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.models.Lesson;
import peaksoft.models.Task;
import peaksoft.repository.TaskRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private static EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public void saveTask(Task task,Long lessonId) {
        List<Task> list = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            list.addAll(lesson.getTasks());
            list.add(task);
            lesson.setTasks(list);
            entityManager.persist(task);
            entityManager.merge(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("SAVE TASK ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTask(Long taskId,Task newTask) {
        try{
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, taskId);
            task.setName(newTask.getName());
            task.setDeadline(newTask.getDeadline());
            task.setTask(newTask.getTask());
            entityManager.merge(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("UPDATE TASK ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        try{
            entityManager.getTransaction().begin();
            List<Lesson> list = entityManager.createQuery("select l from Lesson l where l.id = :id", Lesson.class)
                    .setParameter("id", id).getResultList();
            Lesson lesson = list.get(0);
            List<Task> tasks = new ArrayList<>(lesson.getTasks());
            System.out.println("GET TASK BY LESSON ID ##$$");
            return tasks;
        }catch (HibernateException e){
            throw  new RuntimeException();
        }
    }

    @Override
    public void deleteByTaskId(Long id) {
        try{
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, id);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("DELETE BY TASK ID ##$$");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }
}
