/**
 * This class writes the data from each slot of the slot machine
 * This includes the color and shape
 * @author Max Lewis
 */

import java.io.*;
import java.util.*;
import java.beans.*;

public class TileWriter {
	/**
	 * These functions determine the file format for the selected file and sends the duties to other functions 
	 * @param fname file name
	 * @param shapesAndColors the array list 
	 * @return
	 */
	public boolean write(String fname, ArrayList<String> shapesAndColors){
		File f = new File(fname);
		return write(f, shapesAndColors);
	}
	public boolean write(File f, ArrayList<String> shapesAndColors){
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")){
			return writeToText(f,shapesAndColors);
		}
		if (fname.endsWith(".BIN")){
			return writeToBinary(f, shapesAndColors);
		}
		if (fname.endsWith(".XML")){
			return writeToXML(f, shapesAndColors);
		}
		return false;
	}
	/**
	 * These functions write the contents of each slot in text format 
	 * @param fname file name
	 * @param shapesAndColors arraylist to be written to 
	 * @return delegates
	 */
    public boolean writeToText(String fname, ArrayList<String> shapesAndColors) {
		File f = new File(fname);
		return writeToText(f, shapesAndColors);   
	}
	public boolean writeToText(File f, ArrayList<String> shapesAndColors) {
		try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for (String line : shapesAndColors){
                pw.println(line);
            }
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	/**
	 * These functions write the contents of each slot in binary format 
	 * @param fname file name
	 * @param shapesAndColors arraylist to be written to 
	 * @return delegates 
	 */
	public boolean writeToBinary(String fname, ArrayList<String> shapesAndColors){
		File f = new File(fname);
		return writeToBinary(f, shapesAndColors);
	}
	public boolean writeToBinary(File f, ArrayList<String> shapesAndColors){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(shapesAndColors);
			oos.close();
			return true;
		}catch (Exception ex){
			return false;
		}
	}
	/**
	 * These functions write the contents of each slot in XML format
	 * @param fname file name
	 * @param shapesAndColors arraylist to be written to
	 * @return delegates
	 */
	public boolean writeToXML(String fname, ArrayList<String> shapesAndColors){
		File f = new File(fname);
		return writeToXML(f, shapesAndColors);
	}
	public boolean writeToXML(File f, ArrayList<String> shapesAndColors){
		try{
			XMLEncoder enc = new XMLEncoder(new FileOutputStream(f));
			enc.writeObject(shapesAndColors);
			enc.close();
			return true;
		}catch (Exception ex){
			return false;
		}
	}
}