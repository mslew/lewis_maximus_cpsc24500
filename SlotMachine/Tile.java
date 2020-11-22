/**
 * This class builds the content of each tile in the slotmachine 
 * @author Max Lewis
 */
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
    private TileRandomizer tr = new TileRandomizer();
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

    /**
     * This function sets each private String to a random value
     */
    public void setRandomly(){
        setFirstColor(tr.randomColor());
        setFirstShape(tr.randomShape());
        setSecondColor(tr.randomColor());
        setSecondShape(tr.randomShape());
        setThirdColor(tr.randomColor());
        setThirdShape(tr.randomShape());
        setFourthColor(tr.randomColor());
        setFourthShape(tr.randomShape());
    }
    /**
     * This changes the first color and shape only
     */
    public void changeFirstColorAndShape(){
        setFirstColor(tr.randomColor());
        setFirstShape(tr.randomShape());
    }
    /**
     * This changes the second color and shape only 
     */
    public void changeSecondColorAndShape(){
        setSecondColor(tr.randomColor());
        setSecondShape(tr.randomShape());
    }
    /**
     * This changes the third color and shape only 
     */
    public void changeThirdColorAndShape(){
        setThirdColor(tr.randomColor());
        setThirdShape(tr.randomShape());
    }
    /**
     * This changes the fourth color and shape only 
     */
    public void changeFourthColorAndShape(){
        setFourthColor(tr.randomColor());
        setFourthShape(tr.randomShape());
    }
    /**
     * This is the toString function that is used for saving the data
     */
    @Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s", firstColor, firstShape, secondColor, secondShape, thirdColor, thirdShape, fourthColor, fourthShape);
    }  
}