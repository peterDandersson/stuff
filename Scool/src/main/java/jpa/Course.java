package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private Date startDate;
    private Date endDate;


    private Set<Day> days;
}
