package ejb;


import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateful
public class QuestionsImpl implements Questions {
    private List<Question> questions;

    public int getExistingNumber() {
        return questions.size();
    }

    public List getQuestions(int numberOfQuestions) {
        List<Question> list = new ArrayList<Question>();

        for (int i = 0; i < numberOfQuestions; i++){
            while (true){
                int d = (int) Math.floor(Math.random() * numberOfQuestions);
                if(!list.contains(questions.get(d))){
                    list.add(questions.get(d));
                    break;
                }
            }

        }

        return list;
    }

    @PostConstruct
    public void Q() {
        questions = Arrays.asList(
                new Question(
                        "Which of the following statements are true? Select 1 option",
                        Arrays.asList(
                                "A. For any non-null reference o1, the expression (o1 instanceof o1) will always yield true.",
                                "B. For any non-null reference o1, the expression (o1 instanceof Object) will always yield true.",
                                "C. For any non-null reference o1, the expression (o1 instanceof o1) will always yield false.",
                                "D. For any non-null reference o1, the expression (o1 instanceof Object) may yield false."
                        ),
                        "B. For any non-null reference o1, the expression (o1 instanceof Object) will always yield true."),
                new Question(
                        "o1 and o2 denote two object references to two different objects of the same class. Which of the following statements are tru?",
                        Arrays.asList(
                                "A. o1.equals(o2) will always be false.",
                                "B. o1.hashCode() == o2.hashCode() will always be false",
                                "C. o1 == o2 will always be false.",
                                "D. Nothing can be said about o1 == o2."
                        ),
                        "C. o1 == o2 will always be false."),
                new Question(
                        "How many objects are being instantiated in the following code?\n \n" +
                        "10:    String alpha = \"\"; \n" +
                        "11:    for(char current = 'a'; current <= 'z'; current++) \n" +
                        "12:        alpha += current; \n" +
                        "13:    System.out.println(alpha);",
                        Arrays.asList(
                                "A. 1",
                                "B. 2",
                                "C. 3",
                                "D. 27",
                                "E. 26",
                                "F. No objects is being instantiated."
                        ),
                        "D. 27"),
                new Question(
                        "Which of the following statements are true? Select 1 option",
                        Arrays.asList(
                                "A. For any non-null reference o1, the expression (o1 instanceof o1) will always yield true.",
                                "B. For any non-null reference o1, the expression (o1 instanceof Object) will always yield true.",
                                "C. For any non-null reference o1, the expression (o1 instanceof o1) will always yield false.",
                                "D. For any non-null reference o1, the expression (o1 instanceof Object) may yield false."
                        ),
                        "B. For any non-null reference o1, the expression (o1 instanceof Object) will always yield true."),
                new Question(
                        "o1 and o2 denote two object references to two different objects of the same class. Which of the following statements are tru?",
                        Arrays.asList(
                                "A. o1.equals(o2) will always be false.",
                                "B. o1.hashCode() == o2.hashCode() will always be false",
                                "C. o1 == o2 will always be false.",
                                "D. Nothing can be said about o1 == o2."
                        ),
                        "C. o1 == o2 will always be false."),
                new Question(
                        "How many objects are being instantiated in the following code? \n \n" +
                                "10:    String alpha = \"\";\n" +
                                "11:    for(char current = 'a'; current <= 'z'; current++) \n" +
                                "12:        alpha += current; \n" +
                                "13:    System.out.println(alpha);",
                        Arrays.asList(
                                "A. 1",
                                "B. 2",
                                "C. 3",
                                "D. 27",
                                "E. 26",
                                "F. No objects is being instantiated."
                        ),
                        "D. 27"),
                new Question(
                        "7How many objects are being instantiated?",
                        (Arrays.asList("1", "2", "3", "27")),
                        "27"),
                new Question(
                        "8hejehe",
                        Arrays.asList("0", "1", "2", "3"),
                        "2"));
    }
}
