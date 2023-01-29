package peaksoft.service.serviceImpl;

import peaksoft.models.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.repositoryImpl.TaskRepositoryImpl;
import peaksoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    public String saveTask(Task task,Long lessonId) {
        taskRepository.saveTask(task,lessonId);
        return "<<<Save Task!>>>";
    }

    @Override
    public void updateTask(Long taskId, Task newTask) {
        taskRepository.updateTask(taskId,newTask);
    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        return taskRepository.getTaskByLessonId(id);
    }

    @Override
    public void deleteByTaskId(Long id) {
        taskRepository.deleteByTaskId(id);
    }
}
