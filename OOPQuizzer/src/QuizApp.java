/**
 * This class just runs the application
 * @author Max Lewis
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {
    public static void welcome(){
        System.out.println("********************************");
        System.out.println("      OOP Concepts Quizzer      ");
        System.out.println("********************************");
    }
    public static int printMenuAndGetChoice(Scanner sc){
        System.out.println("\nHere are your choices:");
        System.out.println("1. Take a quiz");
        System.out.println("2. See Questions and Answers");
        System.out.println("3. Exit");
        System.out.println("Enter the number of your choice: ");
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
    public static void main(String[] args){
        welcome();
        QuestionReader qr = new QuestionReader();
        QuestionPrinter qp = new QuestionPrinter();
        Quizzer qz = new Quizzer();
        ArrayList<Question> questions = new ArrayList<Question>();
        Scanner sc = new Scanner(System.in);
        int choice;
        int numberCorrect = 0;
        String path;
        System.out.println("Enter the name of your file containing the questions: ");
        path = sc.nextLine();
        questions = qr.readFromJSON(path);
        if (questions == null){
            System.out.println("Could not read the file.");
        }else {
            System.out.println("Read the file successfully.");
        }
        do{
            choice = printMenuAndGetChoice(sc);
            if (choice == 1){
                System.out.println("\nEnter the amount of questions you would want: ");
                int numberOfQuestions = sc.nextInt();
                numberCorrect = qz.showQuestion(numberOfQuestions, questions);
                System.out.printf("\nYou got %d questions correct out of %s questions", numberCorrect, numberOfQuestions);
            }else if (choice == 2){
                qp.printQuestions(questions);
            }else if (choice == 3){
                break;
            }
        }while (choice != 3);
        System.out.println("Thanks for using the program.");
    }
}
