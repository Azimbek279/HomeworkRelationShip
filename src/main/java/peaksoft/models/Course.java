package peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
@Getter
@Setter
@Table(name = "courses")
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate createAt;
    private String imageLink;
    private String description;

    @ManyToMany(cascade = {PERSIST,MERGE,DETACH,REFRESH},fetch = FetchType.EAGER)
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<>();

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
