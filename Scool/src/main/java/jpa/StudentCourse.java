package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

/**
 * Created by Elev1 on 2017-03-31.
 */
@Entity
public class StudentCourse {
    @Id
    @GeneratedValue
    private Long id;

    private Student student;
    private Course course;
    private Set<Attendance> attendance;
    private boolean isActive;
}
