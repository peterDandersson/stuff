package com.company;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.*;

/**
 * Created by Peter on 2017-01-23.
 */
public class Quiz {
    List<Question> questions;

    public Quiz() {
        Question[] q = {
                new Question(
                        "Vilken är världens minsta hästras?",
                        'd',
                        new String[]{" -Shetlandsponny", " -Haflinger", " -Appalosa", " -Falabela"}
                ),
                new Question(
                        "Från vilket land kommer flygbolaget Norwegian ifrån?",
                        'b',
                        new String[] {" -Sverige", " -Norge", " -Danmark", " -Finland"}
                )
        };
        questions = new ArrayList<Question>(Arrays.asList(q));
        run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("Välkommen till Peters underbara quiz! \nSvara genom att skriva in A, B, C, eller D. För att avsluta skriver du in Q");
        for (Question q :questions){
            System.out.println("\n \n" + q.getQuestion() + "\n");
            Map a = q.getAnswers();
            a.forEach((k,v) -> System.out.println(k + "" + v));

            char c = sc.next().charAt(0);

            if(c == 'q' || c == 'Q'){
                System.out.println("Du slutade på " + score + " poäng!");
                System.exit(0);
            }

            if(q.checkAnswer(c)){
                score++;
                System.out.println("Rätt!");
            } else {
                System.out.println("Fel! :(");
            }
            System.out.println("\nDu har " + score + " poäng!");
        }
    }

    public class Question {
        private String question;
        private Map answers;
        private char correctAnswer;

        public Map getAnswers() {
            return answers;
        }

        public Question(String quiz, char correctAnswer, String[] answers) {
            this.question = quiz;
            this.correctAnswer = correctAnswer;
            this.answers = new HashMap();

            char c = 'A';
            for(String s : answers){
                this.answers.put(c, s);
                c++;
            }
        }

        public String getQuestion() {
            return question;
        }
        public boolean checkAnswer(char answer) {
            return answer == correctAnswer || answer == Character.toUpperCase(correctAnswer);
        }
    }
}

