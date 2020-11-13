
import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class TileReader {
    public ArrayList<String> read(String fname){
        File f = new File(fname);
        return read(f);
    }
    public ArrayList<String> read(File f){
        String fname = f.getName().toUpperCase();
        if (fname.endsWith(".TXT")){
            return readFromText(f);
        }
        if (fname.endsWith(".BIN")){
            return readFromBinary(f);
        }
        if (fname.endsWith(".XML")){
            return readFromXML(f);
        }
        return null;
    }
    public ArrayList<String> readFromText(String fname){
        File f = new File(fname);
        return readFromText(f);
    }
    public ArrayList<String> readFromText(File f){
        try{
            ArrayList<String> result = new ArrayList<String>();
            Scanner fsc = new Scanner(f);
            String line;
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                result.add(line);
            }
            fsc.close();
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> readFromBinary(String fname){
        File f = new File(fname);
        return readFromBinary(f);
    }
    public ArrayList<String> readFromBinary(File f){
        try{
            ArrayList<String> result;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            result = (ArrayList<String>)ois.readObject();
            ois.close();
            return result;
        }catch (Exception ex){
            return null;
        }
    }
    public ArrayList<String> readFromXML(String fname){
        File f = new File(fname);
        return readFromXML(f);
    }
    public ArrayList<String> readFromXML(File f){
        try{
            ArrayList<String> result;
            XMLDecoder edc = new XMLDecoder(new FileInputStream(f));
            result = (ArrayList<String>)edc.readObject();
            edc.close();
            return result;
        }catch (Exception ex){
            return null;
        }
    }
}