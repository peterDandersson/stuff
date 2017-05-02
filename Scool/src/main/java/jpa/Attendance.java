package jpa;

import javax.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private StudentCourse student;
  
    private Day day;

    private boolean present;
}
