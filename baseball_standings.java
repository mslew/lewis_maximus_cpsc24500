/**
 * This program reads a file of MLB standings, calculates winning percentages and games behing. Gives the
 * user an option to select a specific division or all of the teams combined. 
 * @author Max Lewis 
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Collections;


public class Baseball {
	public static void welcome() {
		System.out.print("**************************************************\n");
		System.out.print("                BASEBALL STANDINGS                \n");
		System.out.print("**************************************************\n");

	}
	public static int menuChoice(Scanner sc) {
		System.out.print("Which league would you want to see?\n");
		System.out.print("1. AL East\n");
		System.out.print("2. AL Central\n");
		System.out.print("3. AL West\n");
		System.out.print("4. NL East\n");
		System.out.print("5. NL Central\n");
		System.out.print("6. NL West\n");
		System.out.print("7. Overall\n");
		System.out.print("8. Exit\n");
		System.out.print("Choice: \n");
		int choice = sc.nextInt();
		return choice;
	}
	public static double winningPercentage(String team) {
		double avg; 
		double total;
		String[] parts;
		parts= team.split("\t");
		double wins = Double.parseDouble(parts[1]);
		double losses = Double.parseDouble(parts[2]);
		total = wins + losses;
		avg = wins / total;
		return avg;
	}
	public static double gamesBehind(double firstTeamTotal, double secondTeamTotal) {
		double gamesBehind;
		gamesBehind = (firstTeamTotal - secondTeamTotal) / 2;
		return gamesBehind;
	}
	public static double teamSubtracted(String team) {
		String[] parts;
		parts = team.split("\t");
		double total = Double.parseDouble(parts[1]) - Double.parseDouble(parts[2]);
		return total;
	}
	public static ArrayList<String> sortAllTeams(ArrayList<String> list){
		String[] parts;
		ArrayList<Double> tempStandings = new ArrayList<Double>();
		ArrayList<String> correctedStandings = new ArrayList<String>();
		double winningPercentage;
		for (String line : list) {
			parts = line.split("\t");
			winningPercentage = winningPercentage(line);
			tempStandings.add(winningPercentage);
		}
		Collections.sort(tempStandings, Collections.reverseOrder());
		for(double num : tempStandings) {
			for(String line : list) {
				winningPercentage = winningPercentage(line); // i know this is sloppy since im calling a function each time i go through
				if (num == winningPercentage) {				 // the list, but i didnt know how else to do it
					correctedStandings.add(line);
				}else { 
					continue;
				}
			}
		}
		return correctedStandings;
	}
	public static void printStandings(ArrayList<String> list) {
		String[] parts;
		double avg;
		double behind;
		double firstTeamSubtracted = 0;
		double secondTeamSubtracted;
		int count = 0;
		for (String line : list) {
			count++;
			parts = line.split("\t");
			if (count == 1 ) {
				avg = winningPercentage(line);
				firstTeamSubtracted = teamSubtracted(line);
				System.out.printf("%15s\t%15.3f\t\n",line, avg);
			}else if (count > 1) {
				secondTeamSubtracted = teamSubtracted(line);
				avg = winningPercentage(line);
				behind = gamesBehind(firstTeamSubtracted, secondTeamSubtracted);
				System.out.printf("%15s\t%15.3f\t%15.2f\n",line, avg, behind);
			}
		}
	}
	public static void main(String[] args) {
		welcome();
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter the name of the file: \n");
		String fname = sc.nextLine();
		ArrayList<String> alEast = new ArrayList<String>();
		ArrayList<String> alCentral = new ArrayList<String>();
		ArrayList<String> alWest = new ArrayList<String>();
		ArrayList<String> nlEast = new ArrayList<String>();
		ArrayList<String> nlCentral = new ArrayList<String>();
		ArrayList<String> nlWest = new ArrayList<String>();
		ArrayList<String> allTeams = new ArrayList<String>();
		ArrayList<String> sortedAllTeams = new ArrayList<String>();
		ArrayList<String> target = null;
		String line;
		String[] parts;
		String league;
		int proceed = 0, choice = 0;
		try {
			Scanner fsc =  new Scanner(new File(fname));
			while (fsc.hasNextLine()) {
				line =  fsc.nextLine();
				parts = line.split("\t");
				if (parts[0].equalsIgnoreCase("League")) {
					league = parts[1];
						if (league.equalsIgnoreCase("AL East")) {
							target = alEast;
						}else if (league.equalsIgnoreCase("AL Central")) {
							target = alCentral;
						}else if (league.equalsIgnoreCase("AL West")) {
							target = alWest;
						}else if (league.equalsIgnoreCase("NL East")) {
							target = nlEast;
						}else if (league.equalsIgnoreCase("NL Central")) {
							target = nlCentral;
						}else if (league.equalsIgnoreCase("NL West")) {
							target = nlWest;
						}
				}else {
					target.add(line);
					allTeams.add(line);
				}
			}
			fsc.close();
			proceed = 1;
		}catch (Exception ex) {
			System.out.print("This file cannot be found.\n");
			proceed = 0;
		}
		if (proceed == 1) {
			do {
				choice = menuChoice(sc);
				if (choice == 1) {
					System.out.print("AL EAST\n");
					System.out.print("----------------------------\n");
					printStandings(alEast);
				}else if (choice == 2) {
					System.out.print("AL CENTRAL\n");
					System.out.print("----------------------------\n");
					printStandings(alCentral);
				}else if (choice == 3) {
					System.out.print("AL WEST\n");
					System.out.print("----------------------------\n");
					printStandings(alWest);
				}else if (choice == 4) {
					System.out.print("NL EAST\n");
					System.out.print("----------------------------\n");
					printStandings(nlEast);
				}else if (choice == 5) {
					System.out.print("NL CENTRAL\n");
					System.out.print("----------------------------\n");
					printStandings(nlCentral);
				}else if (choice == 6) {
					System.out.print("NL WEST\n");
					System.out.print("----------------------------\n");
					printStandings(nlWest);
				}else if (choice == 7) {
					sortedAllTeams=sortAllTeams(allTeams);
					System.out.print("Team\tWins\tLosses\n");
					System.out.print("----------------------------\n");
					for(String sortedAllTeamsLine : sortedAllTeams) {
						System.out.printf("%15s\n", sortedAllTeamsLine);
					}
				}
			}while (choice != 8);
		}
		System.out.print("Thank you for using this program!\n");
	}
}
