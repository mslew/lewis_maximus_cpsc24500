//Max Lewis
//This program will help in the flooring calculate process for a specific room 

public class Flooring {
	public static double packCalc(double num) {
		double total = num / 6;
		return total;
	}
	public static void main(String[] Args) {
		double floorArea = 25 * 20; //get total area in ft^2
		double boardArea = (30 * 6) / 144; //calc board area and divide by 144 to get the value to ft^2
		double totalBoards = (500 / 1.25) *.2 + (500 / 1.25); //multiply by .2 since we need 20% more boards because of the slant, add to total
		double totalPacks = packCalc(totalBoards); //call function to divide the total boards by 6, 6 boards per package
		System.out.printf("You will need to buy %.2f packs of boards for your floor.", totalPacks);
	}
}

