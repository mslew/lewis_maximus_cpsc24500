/**
 * This program will plot COVID-19 deaths per country that the user selects. Daily or Cumulative. 
 * @author Max Lewis 
 */
import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

public class CovidPlotter {
	public static void Welcome(){
		System.out.print("**************************************\n");
		System.out.print("INTERNATIONAL COVID-19 MORTALITY RATES\n");
		System.out.print("**************************************\n");

	}
	public static double[] getDays(int amount){
		double[] result = new double [amount];
		for (int i = 0; i < amount; i++){
			result[i] = i;
		}
		return result;
	}
	public static void buildWindow(Plot2DPanel plot, String titleGraph) {
        JFrame frm = new JFrame();
		frm.setTitle(titleGraph);
		BaseLabel title = new BaseLabel(titleGraph,Color.BLACK,0.5,1.1);
		plot.addPlotable(title);
        frm.setBounds(100,100,500,500);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		plot.setAxisLabels("Days", "Deaths");
        frm.setVisible(true);
	}
	public static LinkedHashMap<String, double[]> readFile(Scanner fsc){
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		String line = fsc.nextLine();
		String[] parts = line.split("\t");
		String country;
		double[] deaths;
		int dayCount = parts.length - 1;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			country = parts[0];
			deaths = new double[dayCount];
			for (int i = 1; i < parts.length; i++) {
				deaths[i-1] = Double.parseDouble(parts[i]);
			}
			result.put(country,deaths);
		}
		return result;
	}
	public static LinkedHashMap<String, double[]> makeDaily(LinkedHashMap<String, double[]> list){
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		double[] deaths;
		for(String country : list.keySet()){
			deaths = list.get(country);
			int dayCount = deaths.length - 1;
			for (int i = 1; i < dayCount; i++){
				double daily = deaths[i] - deaths[i-1];
				if (daily < 0 || daily > 10000){
					continue;
				}else{
					deaths[i-1] = daily;
				}
			}
			result.put(country,deaths);
		}
		return result;
	}
	public static void main(String[] args) {
		Welcome();
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter the name of the file: \n");
		String fname = sc.nextLine();
		String country;
		String[] parts;
		double[] countryDeaths;
		double[] countryDailyDeaths;
		int num = 0;
		int proceed = 0;
		LinkedHashMap<String, double[]> countryDeathSet = new LinkedHashMap<String, double[]>();
		LinkedHashMap<String, double[]> countryDailyDeathSet = new LinkedHashMap<String, double[]>();
		LinkedHashMap<String, double[]> temp = new LinkedHashMap<String, double[]>();
		try {
			Scanner fsc = new Scanner(new File(fname));
			countryDeathSet = readFile(fsc);
			fsc.close();
		}catch (Exception ex){
			num = 1;
		}
		if(num == 1){
			System.out.print("This file cannot be found.\n");
		}else{
			temp = countryDeathSet;
			countryDailyDeathSet = makeDaily(temp);
			do{
				System.out.print("Enter the country(s) you want to see. Seperate countries by commas or quit: \n");
				country = sc.nextLine();
				if (!country.equalsIgnoreCase("quit")){
					System.out.print("[C]umulative of [D]aily? \n");
					String cOrD = sc.nextLine();
					if (cOrD.equalsIgnoreCase("c")){
						proceed = 1;
						Plot2DPanel plot = new Plot2DPanel();
						plot.addLegend("SOUTH");
						parts = country.split(",");
						for (String part : parts){
							part = part.trim();
							if(countryDeathSet.containsKey(part) == false){
								System.out.printf("%s was not found.\n", part);
								System.out.print("You may need to check you spelling and capitalization\n");
								proceed = 0;
							}else{	
								countryDeaths = countryDeathSet.get(part); 
								plot.addLinePlot(part, getDays(countryDeaths.length), countryDeaths);
							}
						}
						if (proceed == 0){
							continue;
						}else{
							buildWindow(plot, "Cumulative Deaths");
						}
					}else if (cOrD.equalsIgnoreCase("d")){
						proceed = 1;
						Plot2DPanel plot = new Plot2DPanel();
						plot.addLegend("SOUTH");
						parts = country.split(",");
						for (String part : parts){
							part = part.trim();
							if(countryDailyDeathSet.containsKey(part) == false){
								System.out.printf("%s was not found.\n", part);
								System.out.print("You may need to check you spelling and capitalization\n");
								proceed = 0;
							}else{
								countryDailyDeaths = countryDailyDeathSet.get(part);
								plot.addLinePlot(part, getDays(countryDailyDeaths.length), countryDailyDeaths);
							}
						}
						if (proceed == 0){
							continue;
						}else{
							buildWindow(plot, "Daily Deaths");
						}
					}else{
						System.out.print("Please type a C or D for cumulative of daily.\n");
					}
				}
			}while (!country.equalsIgnoreCase("quit"));
			System.out.print("Thank you for using this program!\n");
		}
	}
}