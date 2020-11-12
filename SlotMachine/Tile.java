
import java.util.Random;

public class Tile {
    private String firstColor;
    private String secondColor;
    private String thirdColor;
    private String fourthColor;
    private String firstShape;
    private String secondShape;
    private String thirdShape;
    private String fourthShape;
    
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
    public Tile(String firstColor){
        firstColor = "red";
    }
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
    // 3 colors and 2 shapes
    public void setRandomly(){
        setFirstColor(randomColor());
        setSecondColor(randomColor());
        setThirdColor(randomColor());
        setFourthColor(randomColor());
        setFirstShape(randomShape());
        setSecondShape(randomShape());
        setThirdShape(randomShape());
        setFourthShape(randomShape());
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s", firstColor, firstShape, secondColor, secondShape, thirdColor, thirdShape, fourthColor, fourthShape);
    }  
}