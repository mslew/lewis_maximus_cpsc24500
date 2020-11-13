import java.io.*;
import java.util.*;
import java.beans.*;

public class TileWriter {
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