package peaksoft.service.serviceImpl;

import peaksoft.models.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.repositoryImpl.LessonRepositoryImpl;
import peaksoft.service.InstructorService;
import peaksoft.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository =  new LessonRepositoryImpl();
    @Override
    public String saveLesson(Lesson lesson,Long courseId) {
        lessonRepository.saveLesson(lesson,courseId);
        return "<<<Save Lesson!>>>";
    }

    @Override
    public void updateLesson(Long lessonId, Lesson newLesson,Long courseId) {
        lessonRepository.updateLesson(lessonId,newLesson,courseId);
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.getLessonById(lessonId);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        return lessonRepository.getLessonByCourseId(id);
    }
}
