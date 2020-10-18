/**
 * This program reads a file of MLB standings, calculates winning percentages and games behing. Gives the
 * user an option to select a specific division or all of the teams combined. 
 * @author Max Lewis 
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


//C:\Users\epicx\Downloads\baseball_standings.txt

public class Baseball {
	/**
	 * This function simply prints the welcome screen in a nice header
	 */
	public static void welcome() {
		System.out.print("**************************************************\n");
		System.out.print("                BASEBALL STANDINGS                \n");
		System.out.print("**************************************************\n");

	}
	/**
	 * This function prints out a menu and grabs the choice from the user
	 * @param sc scanner grabs the user's choice from the menu
	 * @return the choice, which is an int 
	 */
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
	/**
	 * This function takes a line from the various divisions and takes their wins and losses and calculates winning percentage
	 * @param team line from the various division arraylists
	 * @return the avg in double
	 */
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
	/**
	 * This functions takes the first team in the division and calculates the games behind for the teams lower than the team in first
	 * (team in first -  team below) / 2
	 * @param firstTeamTotal is the team in firsts total games
	 * @param secondTeamTotal is the team below the team in first total games
	 * @return the games behind in a double
	 */
	public static double gamesBehind(double firstTeamTotal, double secondTeamTotal) {
		double gamesBehind;
		gamesBehind = (firstTeamTotal - secondTeamTotal) / 2;
		return gamesBehind;
	}
	/**
	 * This function takes in a team's wins and losses and subtracts them, used to calculate games behind
	 * @param team line from the various division files
	 * @return total in double. which is the wins - losses
	 */
	public static double teamSubtracted(String team) {
		String[] parts;
		parts = team.split("\t");
		double total = Double.parseDouble(parts[1]) - Double.parseDouble(parts[2]);
		return total;
	}
	/**
	 * This function sorts all the teams by winning percentage 
	 * @param list the empty list that I will be adding to 
	 * @param line is the one line of the file with team, wins and losses
	 */
	public static void sortedByAverage(ArrayList<String> list, String line){
		double thisPerc = winningPercentage(line);
		double otherPerc;
		int pos = -1;
		for (int i=0; i < list.size(); i++) {
			otherPerc = winningPercentage(list.get(i));
			if (thisPerc > otherPerc) {
				pos = i;
				break;
			}
		}
		if (pos < 0) {
			list.add(line);
		}else {
			list.add(pos, line);
		}
	}
	
	/**
	 * This function prints out the standings 
	 * @param list is the list of teams per division
	 */
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
				System.out.printf("%15s\t%5.3f\t\n",line, avg);
			}else if (count > 1) {
				secondTeamSubtracted = teamSubtracted(line);
				avg = winningPercentage(line);
				behind = gamesBehind(firstTeamSubtracted, secondTeamSubtracted);
				System.out.printf("%15s\t%5.3f\t%8.2f\n",line, avg, behind);
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
					sortedByAverage(allTeams, line);
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
					System.out.print("AL EAST        Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(alEast);
				}else if (choice == 2) {
					System.out.print("AL CENTRAL     Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(alCentral);
				}else if (choice == 3) {
					System.out.print("AL WEST        Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(alWest);
				}else if (choice == 4) {
					System.out.print("NL EAST        Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(nlEast);
				}else if (choice == 5) {
					System.out.print("NL CENTRAL     Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(nlCentral);
				}else if (choice == 6) {
					System.out.print("NL WEST        Wins   Losses   Percent   Games Behind\n");
					System.out.print("--------------------------------------------------------\n");
					printStandings(nlWest);
				}else if (choice == 7) {
					System.out.print("Team           Wins   Losses\n");
					System.out.print("----------------------------\n");
					for(String allTeamsLine : allTeams) {
						System.out.printf("%15s\n", allTeamsLine);
					}
				}
			}while (choice != 8);
		}
		System.out.print("Thank you for using this program!\n");
	}
}
