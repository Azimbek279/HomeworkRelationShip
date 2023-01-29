package peaksoft.service;

import peaksoft.models.Task;

import java.util.List;

public interface TaskService {
    String saveTask(Task task,Long lessonId);
    void updateTask(Long taskId,Task newTask);
    List<Task> getTaskByLessonId(Long id);
    void deleteByTaskId(Long id);
}
