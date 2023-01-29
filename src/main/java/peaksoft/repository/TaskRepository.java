package peaksoft.repository;

import peaksoft.models.Lesson;
import peaksoft.models.Task;

import java.util.List;

public interface TaskRepository {
    void saveTask(Task task,Long lessonId);
    void updateTask(Long taskId,Task newTask);
    List<Task> getTaskByLessonId(Long id);
    void deleteByTaskId(Long id);
}
