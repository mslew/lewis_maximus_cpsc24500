import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class randomly chooses and presents the questions to the student and keeps track of
 * and returns how many questions the student answered correctly
 * @author Max Lewis
 */
public class Quizzer {
    /**
     * This function quizzes the user by picking random questions from the arraylist of questions
     * created in QuizApp. It prints the questions and all the choices,
     * avoiding the answer. It checks and sees if the user's choice matches with the answer
     * within the json file. If it does, it keeps track of correct answers and prints correct.
     * If not incorrect is printed and nothing is added to the running total.
     * @param numberOfQuestions number of questions provided by the user
     * @param questions the arraylist of questions made by the QuestionReader class
     * @return an int of questions correct. used in the QuizApp class to tell the
     * user how many questions they got correct opposed to the number of questions they wanted.
     */
    public int showQuestion(int numberOfQuestions, ArrayList<Question> questions) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int questionNum;
        int numberCorrect = 0;
        String letterChoice;
        String choiceExpanded = "";
        Question rndQuestion;
        for (int i = 0; i < numberOfQuestions; i++){
            questionNum = rnd.nextInt(questions.size());
            rndQuestion = questions.get(questionNum) ;
            System.out.println(rndQuestion.getQuestion());
            System.out.println("a. " + rndQuestion.getA());
            System.out.println("b. " + rndQuestion.getB());
            System.out.println("c. " + rndQuestion.getC());
            System.out.println("d. " + rndQuestion.getD() + "\n");
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
                System.out.println("Correct!\n");
            }else {
                System.out.println("Incorrect!");
                System.out.printf("The answer is %s\n", rndQuestion.getAnswer());
            }
        }
        return numberCorrect;
    }
}
