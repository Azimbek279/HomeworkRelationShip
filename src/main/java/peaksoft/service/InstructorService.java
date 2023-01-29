package peaksoft.service;

import peaksoft.models.Instructor;

import java.util.List;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    void updateInstructor(Long id,Instructor newInstructor);
    Instructor getInstructorById(Long instructorId);
    List<Instructor> getInstructorByCourseId(Long id);
    void deleteInstructorById(Long instructorId);
    void assignInstructorToCourse(Long instructorId,Long courseId);
}
