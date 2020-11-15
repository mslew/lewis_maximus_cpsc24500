
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
    private String firstColor;
    private String secondColor;
    private String thirdColor;
    private String fourthColor;
    private String firstShape;
    private String secondShape;
    private String thirdShape;
    private String fourthShape;
    /**
     * this function is a constructor and simply sets each private String initially
     */
    public Tile(){
        firstColor = "red";
        firstShape = "rect";
        secondColor = "blue";
        secondShape = "rect";
        thirdColor = "orange";
        thirdShape = "oval";
        fourthColor = "red";
        fourthShape = "oval"; 
    }
    /**
     * second constructor 
     * @param firstColor
     */
    public Tile(String firstColor){
        firstColor = "red";
    }
    /**
     * These are all of the getters and setters for the private String values. 
     * comments seperated for each slot
     * @return
     */

    //first
    public String getFirstColor(){
        return firstColor;
    }
    public void setFirstColor(String firstColor){
        this.firstColor = firstColor;
    }
    public String getFirstShape(){
        return firstShape;
    } 
    public void setFirstShape(String firstShape){
        this.firstShape = firstShape;
    }
    //first

    //second
    public String getSecondColor(){
        return secondColor;
    }
    public void setSecondColor(String secondColor){
        this.secondColor = secondColor;
    }
    public String getSecondShape(){
        return secondShape;
    } 
    public void setSecondShape(String secondShape){
        this.secondShape = secondShape;
    }
    //second

    //third
    public String getThirdColor(){
        return thirdColor;
    }
    public void setThirdColor(String thirdColor){
        this.thirdColor = thirdColor;
    }
    public String getThirdShape(){
        return thirdShape;
    } 
    public void setThirdShape(String thirdShape){
        this.thirdShape = thirdShape;
    }
    //third

    //fourth
    public String getFourthColor(){
        return fourthColor;
    }
    public void setFourthColor(String fourthColor){
        this.fourthColor = fourthColor;
    }
    public String getFourthShape(){
        return firstShape;
    } 
    public void setFourthShape(String fourthShape){
        this.fourthShape = fourthShape;
    }
    //fourth

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
    /**
     * This function sets each private String to a random value
     */
    public void setRandomly(){
        setFirstColor(randomColor());
        setFirstShape(randomShape());
        setSecondColor(randomColor());
        setSecondShape(randomShape());
        setThirdColor(randomColor());
        setThirdShape(randomShape());
        setFourthColor(randomColor());
        setFourthShape(randomShape());
    }
    /**
     * This changes the first color and shape only
     */
    public void changeFirstColorAndShape(){
        setFirstColor(randomColor());
        setFirstShape(randomShape());
    }
    /**
     * This changes the second color and shape only 
     */
    public void changeSecondColorAndShape(){
        setSecondColor(randomColor());
        setSecondShape(randomShape());
    }
    /**
     * This changes the third color and shape only 
     */
    public void changeThirdColorAndShape(){
        setThirdColor(randomColor());
        setThirdShape(randomShape());
    }
    /**
     * This changes the fourth color and shape only 
     */
    public void changeFourthColorAndShape(){
        setFourthColor(randomColor());
        setFourthShape(randomShape());
    }
    /**
     * This is the toString function that is used for saving the data
     */
    @Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s", firstColor, firstShape, secondColor, secondShape, thirdColor, thirdShape, fourthColor, fourthShape);
    }  
}