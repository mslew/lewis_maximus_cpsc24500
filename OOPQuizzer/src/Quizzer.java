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
        String choiceExpanded = "";
        String answerLetter;
        String correctAnswerLetter;
        Question rndQuestion;
        for (int i = 0; i < numberOfQuestions; i++){
            questionNum = rnd.nextInt(questions.size()+1);
            rndQuestion = questions.get(questionNum);
            System.out.println();
            System.out.println("Enter the letter of your choice: ");
            letterChoice = sc.nextLine();
            if (letterChoice.equalsIgnoreCase("a")){
                choiceExpanded = rndQuestion.getA();
            }else if(letterChoice.equalsIgnoreCase("b")){
                choiceExpanded = rndQuestion.getB();
            }else if(letterChoice.equalsIgnoreCase("c")){
                choiceExpanded = rndQuestion.getC();
            }else if(letterChoice.equalsIgnoreCase("d")){
                choiceExpanded = rndQuestion.getD();
            }
            if (choiceExpanded.equalsIgnoreCase(rndQuestion.getAnswer())){
                numberCorrect++;
            }
        }
        return numberCorrect;
    }
}
