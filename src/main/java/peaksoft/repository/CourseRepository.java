package peaksoft.repository;

import peaksoft.models.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<List<Course>> getAllCourse(String ascOrDesc);
    void updateCourse(Long courseId,Course course);
    void deleteByCourseId(Long courseId);

    Course getCourseName(String name);
}
