package peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lessons")
@ToString(exclude = "course")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String videoLink;

    @ManyToOne(cascade = {REFRESH,DETACH,MERGE,PERSIST},fetch = FetchType.LAZY)
    private Course course;

    @OneToMany(cascade = {ALL},fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

//    private Course getCourse(Long id){
//        try{
//            EntityManager entityManager = HibernateConfig.getEntityManager();
//            entityManager.getTransaction().begin();
//            Course course1 = entityManager.find(Course.class, id);
//            entityManager.getTransaction().commit();
//            entityManager.close();
//            return course1;
//        }catch (HibernateException e){
//            throw  new RuntimeException();
//        }
//    }
}
