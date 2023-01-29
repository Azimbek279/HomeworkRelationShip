package peaksoft.service;

import peaksoft.models.Lesson;

import java.util.List;

public interface LessonService {
    String saveLesson(Lesson lesson,Long courseId);
    void updateLesson(Long lessonId,Lesson newLesson,Long courseId);
    Lesson getLessonById(Long lessonId);
    List<Lesson> getLessonByCourseId(Long id);
}
