/**
 * This class reads the data from each slot in the slot machine 
 * This only includes the color and the shape 
 * @author Max Lewis 
 */

import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class TileReader {
    /**
     * These functions are used to determine the file extension entered by user and send duties to other functions 
     * @param fname file name enetered by user
     * @return delegates to a further read function
     */
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
    /**
     * These two functions read the colors and shapes from a text file
     * @param fname file name
     * @return delegates 
     */
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
    /**
     * These two functions read the colors and shapes from a binary file 
     * @param fname file name
     * @return delegates
     */
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
    /**
     * These two functions read the colors and shapes form a XML file
     * @param fname file name
     * @return delegates 
     */
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