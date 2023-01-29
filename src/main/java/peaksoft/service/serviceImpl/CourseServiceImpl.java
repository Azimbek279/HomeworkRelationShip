package peaksoft.service.serviceImpl;

import peaksoft.models.Course;
import peaksoft.models.Task;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.repositoryImpl.CourseRepositoryImpl;
import peaksoft.repository.repositoryImpl.TaskRepositoryImpl;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private  CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String saveCourse(Course course) {
       courseRepository.saveCourse(course);
        return "<<<Save Course!>>>";
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<List<Course>> getAllCourse(String ascOrDesc) {
        return courseRepository.getAllCourse(ascOrDesc);
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        courseRepository.updateCourse(courseId,course);
    }

    @Override
    public void deleteByCourseId(Long courseId) {
        courseRepository.deleteByCourseId(courseId);
    }

    @Override
    public Course getCourseName(String name) {
        return courseRepository.getCourseName(name);
    }
}
