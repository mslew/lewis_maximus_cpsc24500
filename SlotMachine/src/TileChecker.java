/**
 * This class has determines if the tiles have the same color or shape
 * Has two functions to achieve this process.
 * @author Max Lewis 
 */
import java.util.ArrayList;

public class TileChecker {
    /**
     * This determines if the slot's colors match
     * @param listOfColors list of each color in the slots
     * @return a boolean value of true or false. True being all the slots are the same color
     * or false, meaning not all the tiles are the same color 
     */
    public boolean colorMatch(ArrayList<String> listOfColors){
        int i = 0;
        String nextColor;
        int total = 0;
        for (String color : listOfColors){
            if (i == 3){
                nextColor = listOfColors.get(i);
            }else{
                nextColor = listOfColors.get(i+1);
            }
            if (color.equalsIgnoreCase(nextColor)){
                total++;
            }else{
                continue;
            }
            i++;
        }
        if (total == 4){
            return true;
        }else{
            return false;
        }
    }
    /**
     * This determines if the slot's shapes match
     * @param listOfShapes list of each shape in the slots
     * @return a boolean value of true or false. True being all the slots are the same shape
     * or false, meaning not all the tiles are the same shape 
     */
    public boolean shapeMatch(ArrayList<String> listOfShapes){
        int i = 0;
        String nextShape;
        int total = 0;
        for (String shape : listOfShapes){
            if (i == 3){
                nextShape = listOfShapes.get(i);
            }else{
                nextShape = listOfShapes.get(i+1);
            }
            if (shape.equalsIgnoreCase(nextShape)){
                total++;
            }else{
                continue;
            }
            i++;
        }
        if (total == 4){
            return true;
        }else{
            return false; 
        }
    }
}