/**
 * This program will plot COVID-19 deaths per country that the user selects
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

//C:\Users\epicx\OneDrive - Lewis University\School\Object Programming\
//lewis_maximus_cpsc24500\CovidPlotter\countries_deaths.txt

public class CovidPlotter {
	public static void buildWindow() {
		Plot2DPanel plot = new Plot2DPanel();
		JFrame frm = new JFrame();
		frm.setBounds(100,100,500,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	public static LinkedHashMap<String, double[]> readFile(Scanner fsc){
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		String line = fsc.nextLine();
		String[] parts = line.split("\t");
		String name;
		double[] deaths;
		int dayCount = parts.length - 1;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];
			deaths = new double[dayCount];
			for (int i = 1; i < parts.length; i++) {
				deaths[i-1] = Double.parseDouble(parts[i]);
			}
			result.put(name,deaths);
		}
		return result;
		
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter the name of the file: \n");
		String fname = sc.nextLine();
		LinkedHashMap<String,double[]> countryDeathSet = null;
		try {
			Scanner fsc = new Scanner(new File(fname));
			countryDeathSet = readFile(fsc);
		}catch (Exception ex) {
			System.out.print("This file cannot be found.\n");
		}
		System.out.print("Enter the country you want to see: \n");
		String country = sc.nextLine();
		double[] countryDeaths = countryDeathSet.get(country);
		Plot2DPanel plot = new Plot2DPanel();
		BaseLabel title =  new BaseLabel("COVID-19 Deaths for " + country, Color.RED, 0.5,1.1);
		plot.addLinePlot(country, countryDeaths);
		plot.addPlotable(title);
		plot.setAxisLabels("Day", "Deaths");
		JFrame frm = new JFrame();
		frm.setBounds(100,100,500,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
}
