package peaksoft.service.serviceImpl;

import peaksoft.models.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.repositoryImpl.InstructorRepositoryImpl;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
        return "<<<Save Instructor!>>>";
    }

    @Override
    public void updateInstructor(Long id, Instructor newInstructor) {
        instructorRepository.updateInstructor(id,newInstructor);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorRepository.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long instructorId) {
        instructorRepository.deleteInstructorById(instructorId);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId,courseId);
    }
}
