package jsf;

import ejb.Question;
import ejb.Questions;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class QPage {

    @EJB
    Questions questions;

    private int numberOfQuestions;
    private int currentQuestionNumber;
    private String result;
    private String currentAnswer;
    private List<String> answers;
    private List<Question> questionList;

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public Question getCurrentQuestion(){
        return questionList.get(currentQuestionNumber);
    }

    public int getExistingNumberOfQuestions(){
        return questions.getExistingNumber();
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestionNumber = currentQuestion;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String start() {
        answers = new ArrayList<String>();
        questionList = questions.getQuestions(numberOfQuestions);
        return "questions";
    }

    public String next(){
        currentQuestionNumber++;
        answers.add(currentAnswer);

        if(currentQuestionNumber != questionList.size()){
            currentAnswer = null;
            return "questions";
        }else {
            return "score";
        }
    }

    public String prev(){

        if(currentQuestionNumber == 0){
            currentAnswer = null;

            return "index";
        }

        currentQuestionNumber--;
        answers.remove(answers.size() - 1);

        return "questions";
    }

    public String backToStart(){
        currentQuestionNumber = 0;
        currentAnswer = null;
        return "index";
    }

    public String getResults(){
        int correctAnswers = 0;
        System.out.println("ANSWER_ME_THIS " + questionList.size() + "   " +answers.size());
        for(int i = 0; i < questionList.size(); i++){
            correctAnswers = (questionList.get(i).isAnswerRight(answers.get(i))) ? (correctAnswers + 1) : correctAnswers;
        }
        result = correctAnswers + "/" + numberOfQuestions;
        return result;
    }
}
