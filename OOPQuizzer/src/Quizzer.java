import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class randomly chooses and presents the questions to the student and keeps track of
 * and returns how many questions the student answered correctly
 * @author Max Lewis
 */
public class Quizzer {
    public int showQuestion(int numberOfQuestions, ArrayList<Question> questions) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int questionNum;
        int numberCorrect = 0;
        String letterChoice;
        String answerLetter;
        String correctAnswerLetter;
        for (int i = 0; i < numberOfQuestions; i++){
            questionNum = rnd.nextInt(questions.size()+1);
            System.out.println(questions.get(questionNum));
            System.out.println("Enter the letter of your choice: ");
            letterChoice = sc.nextLine();
            if (letterChoice.equalsIgnoreCase("a")){
                correctAnswerLetter = question.getA();
            }else if(letterChoice.equalsIgnoreCase("b")){
                correctAnswerLetter = question.getB();
            }else if(letterChoice.equalsIgnoreCase("c")){
                correctAnswerLetter = question.getC();
            }else if(letterChoice.equalsIgnoreCase("d")){
                correctAnswerLetter = question.getD();
            }
            if (letterChoice.equalsIgnoreCase(questions.getAnswer())){

            }
        }
        return numberCorrect;
    }
}
