import java.util.ArrayList;

public class TileChecker {
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