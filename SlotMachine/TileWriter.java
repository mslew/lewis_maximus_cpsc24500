import java.io.*;
import java.util.*;

public class TileWriter {
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
}
