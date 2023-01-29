package peaksoft.service;

import peaksoft.models.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<List<Course>> getAllCourse(String ascOrDesc);
    void updateCourse(Long courseId,Course course);
    void deleteByCourseId(Long courseId);

    Course getCourseName(String name);
}
