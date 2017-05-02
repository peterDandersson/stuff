package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Day {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private Set<Attendance> attendances;
}
