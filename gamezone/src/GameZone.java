/**
 * This program lets the user play two games, a modified version of blackjack and rock, paper, scissors
 * @author Max Lewis 
 *
 */
import java.util.Scanner;
import java.util.Random;

public class GameZone {
	/**
	 * This function simply prints out the welcome screen
	 */
	public static void Welcome() {
		System.out.print("*************************\n");
		System.out.print("   Welcome to GameZone   \n");
		System.out.print("*************************\n");
	}
	/*
	 * This function prints out the menu for the user to choose from 
	 */
	public static void Menu() {
		System.out.print("Please pick a game or quit!\n");
		System.out.print("1. 21\n");
		System.out.print("2. Rock, Paper, Scissors\n");
		System.out.print("3. Quit\n");
		System.out.print("Choice(Type the number): \n");
	}
	/*
	 * This function determines the Rock Paper or scissors for the user and the computer. based on a random integer
	 * @param num is the random integer that was generated
	 * @return a string that states what part of RPS was chosen
	 */
	public static String DetermineChoice(int num) {
		String str = "";
		if (num==1) {
			str = "Paper";
		}
		else if (num==2) {
			str = "Rock";
		}
		else if (num==3) {
			str = "Scissors";
		}
		return str;
	}
	/*
	 * This function determines the winner for the RPS game
	 * @param comp is the computer choice
	 * @param user is the user choice
	 * @return the verdict in a string 
	 */
	public static String RpsWinner(String comp, String user) {
		String str = "";
		if (comp.equalsIgnoreCase("Paper") & user.equalsIgnoreCase("Rock")) {
			return str = "Paper wins!";
		}
		else if (comp.equalsIgnoreCase("Paper") & user.equalsIgnoreCase("Scissors")){
			return str = "Scissors wins!";
		}
		else if (comp.equalsIgnoreCase("Scissors") & user.equalsIgnoreCase("Rock")) {
			return str = "Rock wins!";
		}
		if (comp.equalsIgnoreCase("Rock") & user.equalsIgnoreCase("Paper")) {
			return str = "Paper wins!";
		}
		else if (comp.equalsIgnoreCase("Scissors") & user.equalsIgnoreCase("Paper")){
			return str = "Scissors wins!";
		}
		else if (comp.equalsIgnoreCase("Rock") & user.equalsIgnoreCase("Scissors")) {
			return str = "Rock wins!";
		}
		else if (comp.equalsIgnoreCase("Rock") & user.equalsIgnoreCase("Rock")) {
			return str = "It is a tie!";
		}
		else if (comp.equalsIgnoreCase("Paper") & user.equalsIgnoreCase("Paper")) {
			return str = "It is a tie!";
		}
		else if (comp.equalsIgnoreCase("Scissors") & user.equalsIgnoreCase("Scissors")) {
			return str = "It is a tie!";
		}
		return "";
	}
	public static void main(String[] args) {
		int choice, runningTotal=0, compNum, rndNum; //initialize variables for 21 game
		String numChoice="y";
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		Welcome();
		Menu();
		choice = sc.nextInt();
		do {
		while (choice==1){
			runningTotal=0;
				compNum=rnd.nextInt(7)+13;
				while (numChoice.equalsIgnoreCase("y")){
					rndNum=rnd.nextInt(10)+1;
					runningTotal = runningTotal+ rndNum;
					if (runningTotal > 21) {
							System.out.printf("You drew a %d and your total is %d, that is past 21! You lost!\n", rndNum, runningTotal);
							Menu();
							choice = sc.nextInt();
							break;
					}
					else if (runningTotal == 21) {
						System.out.print("You drew a perfect 21! You won!\n");
						Menu();
						choice = sc.nextInt();
						break;
					}
					else if (runningTotal < 21) {
						System.out.printf("You drew a %d.\n", rndNum);
						System.out.printf("Your total is %d. Would you want to try to add more (y or n)?\n", runningTotal);
						numChoice=sc.next();
					}
				}
				while (numChoice.equalsIgnoreCase("n")) {
					System.out.printf("The computer's number was %d.\n",compNum);
					System.out.printf("Your total was %d.\n", runningTotal);
					if (compNum > runningTotal) {
						System.out.print("You lost!\n");
						Menu();
						choice = sc.nextInt();
						break;
					}
					else if (compNum < runningTotal) {
						System.out.print("You won!\n");
						Menu();
						choice = sc.nextInt();
						break;
					}
					else if (compNum == runningTotal) {
						System.out.print("It is a tie!\n");
						Menu();
						choice = sc.nextInt();
						break;
					}
				}
		}
		// RPS presets:
		// R and P. P wins
		// R and S. R wins
		// P and S. S wins
		// 1=Paper
		// 2=Rock
		// 3=Scissors
		int compChoice, userChoice;
		String compStrChoice = "";
		String userStrChoice = "";
		String winner= "";
		String rpsChoice= "y";
		while (choice==2) {
			while (rpsChoice.equalsIgnoreCase("y")) {
				compChoice=rnd.nextInt(2)+1;
				userChoice=rnd.nextInt(2)+1;
				compStrChoice= DetermineChoice(compChoice);
				userStrChoice= DetermineChoice(userChoice);
				winner=RpsWinner(compStrChoice, userStrChoice);
				System.out.print("The computer got a " + compStrChoice + ". You got a " + userStrChoice + "." + " " + winner + "\n");
				System.out.print("Do again (y or n)? ");
				rpsChoice = sc.next();
			}
			while (rpsChoice.equalsIgnoreCase("n")) {
				Menu();
				choice = sc.nextInt();
				rpsChoice = "";
				if (choice==1) {
				}
			}
		}
		while (choice==3) {
			System.out.print("Thank you for playing GameZone!\n");
			break;
		}
	}while (choice !=3);
	}
}