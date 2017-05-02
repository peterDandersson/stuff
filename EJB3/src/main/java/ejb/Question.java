package ejb;

import java.util.List;


public class Question {
    private String question;
    private List<String> alternatives;
    private String answer;

    public Question(String question, List<String> alternatives, String answer) {
        this.question = question;
        this.alternatives = alternatives;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public boolean isAnswerRight(String answer){
        return this.answer.equals(answer);
    }
}
