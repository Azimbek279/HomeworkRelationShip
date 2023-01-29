package peaksoft;

import peaksoft.models.Course;
import peaksoft.models.Instructor;
import peaksoft.models.Lesson;
import peaksoft.models.Task;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;
import peaksoft.service.serviceImpl.CourseServiceImpl;
import peaksoft.service.serviceImpl.InstructorServiceImpl;
import peaksoft.service.serviceImpl.LessonServiceImpl;
import peaksoft.service.serviceImpl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
   methods();

    }
    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to save course");
        System.out.println("Press 2 to get course by ID");
        System.out.println("Press 3 to get all courses");
        System.out.println("Press 4 to delete course by ID");
        System.out.println("Press 5 to get course by name");
        System.out.println("Press 6 to update course");
        System.out.println();
        System.out.println("Press 7 to save instructor");
        System.out.println("Press 8 to update instructor");
        System.out.println("Press 9 to find instructor by ID");
        System.out.println("Press 10 to get all instructors by course ID");
        System.out.println("Press 11 to delete instructor by ID");
        System.out.println("Press 12 to assign instructor to course");
        System.out.println();
        System.out.println("Press 13 to save lesson");
        System.out.println("Press 14 to update lesson");
        System.out.println("Press 15 to get lesson by ID");
        System.out.println("Press 16 to get lesson by course ID");
        System.out.println();
        System.out.println("Press 17 to save task");
        System.out.println("Press 18 to update task");
        System.out.println("Press 19 to get all tasks by lesson ID");
        System.out.println("Press 20 to delete task by ID");
        System.out.println("---------------------------------------------");
    }
    static void methods(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Random random = new Random();
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService  taskService = new TaskServiceImpl();

        String number = "null";
        while (!number.equals("x")){
            commands();
            System.out.print("Choose a command: ");
            number = scanner2.nextLine();
            try{
                if (Character.isDigit(number.charAt(0))){
                    switch (number){
                        case "1" ->{
                            Scanner scanner11 = new Scanner(System.in);
                            Course course = new Course();
                            System.out.print("Write course name:");
                            course.setCourseName(scanner11.nextLine());
                            System.out.print("Write description: ");
                            course.setDescription(scanner.nextLine());
                            System.out.print("Write image link");
                            course.setImageLink(scanner1.nextLine());
                            System.out.print("Enter duration:");
                            course.setDuration(scanner11.nextInt());
                            System.out.print("Write year when course create at:");
                            int year = scanner1.nextInt();
                            while(year<1990){
                                year = scanner.nextInt();
                            }
                            int month = random.nextInt(12);
                            int day = random.nextInt(30);
                            course.setCreateAt(LocalDate.of(year, month, day));
                            courseService.saveCourse(course);
                        }
                        case "2" -> {
                            System.out.print("Write course's ID:");
                            Long id = scanner.nextLong();
                            System.out.println(courseService.getCourseById(id));
                        }
                        case "3" -> {
                            System.out.print("Write sort ascOrDesc: ");
                            String ascOrDesc = scanner.nextLine();
                            for (List<Course> i: courseService.getAllCourse(ascOrDesc)) {
                                System.out.println(i);
                            }
                        }
                        case "4" -> {
                            System.out.print("Write course ID:");
                            Long id = scanner1.nextLong();
                            courseService.deleteByCourseId(id);
                        }
                        case "5" -> {
                            Scanner scanner5 = new Scanner(System.in);
                            System.out.print("Write course name:");
                            String name = scanner5.nextLine();
                            System.out.println(courseService.getCourseName(name));
                        }
                        case "6" -> {
                            Scanner scanner6 = new Scanner(System.in);
                            System.out.print("Write ID of course which you want update:");
                            Long id = scanner6.nextLong();
                            Course course = new Course();
                            System.out.print("Write course name:");
                            String courseName = scanner.nextLine();
                            course.setCourseName(courseName);
                            System.out.print("Write description: ");
                            String desc = scanner1.nextLine();
                            course.setDescription(desc);
                            System.out.print("Write image link:");
                            String image = scanner6.nextLine();
                            course.setImageLink(image);
                            System.out.print("Enter duration: (int)");
                            int duration = scanner.nextInt();
                            course.setDuration(duration);
                            System.out.print("Write year when course create at:");
                            int year = scanner1.nextInt();
                            while(year<1990){
                                year = scanner.nextInt();
                            }
                            int month = random.nextInt(12);
                            int day = random.nextInt(30);
                            course.setCreateAt(LocalDate.of(year, month, day));
                            courseService.updateCourse(id, course);
                        }
                        case "7" -> {
                            Scanner scanner7 = new Scanner(System.in);
                            Scanner scanner3 = new Scanner(System.in);
                            Instructor instructor = new Instructor();
                            System.out.print("Write instructor name:");
                            instructor.setFirstName(scanner7.nextLine());
                            System.out.print("Write instructor last name:");
                            instructor.setLastName(scanner1.nextLine());
                            System.out.print("Write instructor email:");
                            instructor.setEmail(scanner.nextLine());
                            System.out.print("Write instructor phone number:");
                            instructor.setPhoneNumber(scanner7.nextLine());
                            instructorService.saveInstructor(instructor);
                        }
                        case "8" -> {
                            Scanner scanner8 = new Scanner(System.in);
                            System.out.println("Write ID of instructor who you want update:");
                            Long id = scanner8.nextLong();
                            Instructor instructor = new Instructor();
                            System.out.print("Write instructor name:");
                            instructor.setFirstName(scanner.nextLine());
                            System.out.print("Write instructor last name:");
                            instructor.setLastName(scanner1.nextLine());
                            System.out.print("Write instructor email:");
                            instructor.setEmail(scanner.nextLine());
                            System.out.print("Write instructor phone number");
                            instructor.setPhoneNumber(scanner8.nextLine());
                            instructorService.updateInstructor(id, instructor);
                        }
                        case "9" ->{
                            System.out.print("Write instructor's ID");
                            Long id = scanner.nextLong();
                            System.out.println(instructorService.getInstructorById(id));
                        }
                        case "10" -> {
                            System.out.print("Write course ID to get all instructors: ");
                            Long id = scanner1.nextLong();
                            for (Instructor i: instructorService.getInstructorByCourseId(id)) {
                                System.out.println(i);
                            }
                        }
                        case "11" -> {
                            System.out.print("Write ID to delete:");
                            Long id = scanner.nextLong();
                            instructorService.deleteInstructorById(id);
                        }
                        case "12" -> {
                            System.out.print("Write course id:");
                            Long idCourse = scanner1.nextLong();
                            System.out.print("Write instructor id:");
                            Long idIns = scanner.nextLong();
                            instructorService.assignInstructorToCourse(idIns, idCourse);
                        }
                        case "14" -> {
                            Scanner scanner3 = new Scanner(System.in);
                            Scanner scanner4 = new Scanner(System.in);
                            System.out.print("Write LessonId: ");
                            Long id = scanner3.nextLong();
                            System.out.println("NEW LESSON!");
                            System.out.print("Write name: ");
                            String name= scanner4.nextLine();
                            System.out.print("Write videoLink:");
                            String videoLink = scanner4.nextLine();
                            System.out.print("Write CourseId:");
                            Long courseId =scanner3.nextLong();
                            lessonService.updateLesson(id,new Lesson(name,videoLink),courseId);
                        }
                        case "13" -> {
                            Scanner scanner13 = new Scanner(System.in);
                            System.out.print("Write lesson name:");
                            String name = scanner13.nextLine();
                            System.out.print("Write video link");
                            String video = scanner.nextLine();
                            System.out.print("Write course ID:");
                            Long id = scanner13.nextLong();
                            lessonService.saveLesson(new Lesson(name, video),id);
                        }
                        case "15" -> {
                            System.out.print("Write lesson ID:");
                            Long id = scanner1.nextLong();
                            System.out.println(lessonService.getLessonById(id));
                        }
                        case "16" -> {
                            System.out.print("Write course ID to get all lessons:");
                            Long id = scanner.nextLong();
                            for (Lesson i:lessonService.getLessonByCourseId(id)) {
                                System.out.println(i);
                            }
                        }
                        case "17" -> {
                            System.out.print("Write task name:");
                            String name = scanner.nextLine();
                            System.out.print("Write deadline:");
                            int year = scanner1.nextInt();
                            while(year<1990){
                                year = scanner.nextInt();
                            }
                            int month = random.nextInt(12);
                            int day = random.nextInt(30);
                            LocalDate localDate = LocalDate.of(year, month, day);
                            System.out.print("Write task:");
                            String taskName = scanner.nextLine();
                            System.out.print("Write lesson id:");
                            Long lessonId = scanner1.nextLong();
                            taskService.saveTask(new Task(name, localDate, taskName),lessonId);
                        }
                        case "18" ->{
                            Scanner scanner18 = new Scanner(System.in);
                            Task task = new Task();
                            System.out.print("Write task id:");
                            Long id = scanner18.nextLong();
                            System.out.print("Write task name:");
                            task.setName(scanner.nextLine());
                            int year = random.nextInt(2022);
                            int month = random.nextInt(12);
                            int day = random.nextInt(30);
                            LocalDate localDate = LocalDate.of(year, month, day);
                            task.setDeadline(localDate);
                            System.out.print("Write task:");
                            task.setTask(scanner1.nextLine());
                            taskService.updateTask(id, task);
                        }
                        case "19" -> {
                            Scanner scanner19 = new Scanner(System.in);
                            System.out.print("Write lesson ID to get all tasks:");
                            Long id = scanner19.nextLong();
                            for (Task i:taskService.getTaskByLessonId(id)) {
                                System.out.println(i);
                            }
                        }
                        case "20" -> {
                            Scanner scanner20 = new Scanner(System.in);
                            System.out.print("Write tasks id to delete:");
                            Long id = scanner.nextLong();
                            taskService.deleteByTaskId(id);
                        }
                    }
                }else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("It is not a button");
            }
        }
    }
}
