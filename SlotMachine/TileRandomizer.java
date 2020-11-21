import java.util.Random;

public class TileRandomizer {
    /**
     * This function generates a random color
     * @return result. This is the random color in the form of a String 
     */
    public String randomColor(){
        Random rnd = new Random();
        int num = rnd.nextInt(5);
        String result = "";
        if (num == 0){
            result = "red";
        }else if (num == 1){
            result = "orange";
        }else if (num == 2){
            result = "blue";
        }else if (num == 3){
            result = "yell";
        }else if (num == 4){
            result = "green";
        }
        return result;
    }
    /**
     * This function generates a random shape
     * @return result. The is the random shape in the form of a String
     */
    public String randomShape(){
        Random rnd = new Random();
        int num = rnd.nextInt(2);
        String result = "";
        if (num == 0){
            result = "rect";
        }else if (num == 1){
            result = "oval";
        }
        return result;
    }
}
