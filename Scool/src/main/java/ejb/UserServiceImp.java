package ejb;

import jpa.Student;
import jpa.Teacher;
import jpa.User_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;

@Stateless
public class UserServiceImp implements UserService {

    @PersistenceContext
    private EntityManager em;

    private String role;
    private Teacher teacher;
    private Student student;

    @Override
    public String strudentToString() {
        return student.toString();
    }

    @Override
    public void createStudent(String email, String password){
       // String email, String password, String firstName, String lastName, String address, Date birthDate
        Student s = new Student(email, password,"Peter","Andersson","Karlavagnsgatan 20", new Date());
        //Course c = new Course();
        em.persist(s);
    }

    @Override
    public String logIn(String email, String password) {

        try {
            TypedQuery<User_> query = em.createNamedQuery("LogIn", User_.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            User_ u = query.getSingleResult();
            System.out.println("___________________________________________________________This is the ROLE: " + u.getDecriminatorValue());

            switch (u.getDecriminatorValue()){
                case "STUDENT": TypedQuery<Student> qs = em.createNamedQuery("getStudent", Student.class);
                                qs.setParameter("id", u.getId());
                                student = qs.getSingleResult();
                                System.out.println("______________________________________________student: " + student.toString());
                                return "student";

                case "TEACHER": TypedQuery<Teacher> qt = em.createNamedQuery("getTeacher", Teacher.class);
                                qt.setParameter("id", u.getId());
                                teacher = qt.getSingleResult();
                                return "teachersPage";

                case "ADMIN":   //more stuff goes here...
                                return "adminsPage";

                default: return "wrong user details";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "something went wrong..";
        }
    }
}
