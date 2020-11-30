/**
 * This class just runs the application
 * @author Max Lewis
 */

import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {
    public static void welcome(){
        System.out.println("********************************");
        System.out.println("      OOP Concepts Quizzer      ");
        System.out.println("********************************");
    }
    public static int printMenuAndGetChoice(Scanner sc){
        System.out.println("Here are your choices:");
        System.out.println("1. Take a quiz");
        System.out.println("2. See Questions and Answers");
        System.out.println("3. Exit");
        System.out.println("Enter the number of your choice: ");
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        welcome();
        do{
            choice = printMenuAndGetChoice(sc);
        }while (choice != 3);
        System.out.println("Thanks for using the program.");
    }
}
