public class TileChecker {
    private int firstColor;
    private int secondColor;
    private int thirdColor;
    private int fourthColor;
    private int firstShape;
    private int secondShape;
    private int thirdShape;
    private int fourthShape;
    private Tile tl = new Tile();
    public int colorToInt(String color){
        int result = 0;
        if (color.equalsIgnoreCase("red")){
            result = 1;
        }else if (color.equalsIgnoreCase("orange")){
            result = 2;
        }else if (color.equalsIgnoreCase("blue")){
            result = 3;
        }else if (color.equalsIgnoreCase("yell")){
            result = 4;
        }else if (color.equalsIgnoreCase("green")){
            result = 5;
        }
        return result;
    }
    public int shapeToInt(String shape){
        int result = 0;
        if (shape.equalsIgnoreCase("rect")){
            result = 1;
        }else if (shape.equalsIgnoreCase("oval")){
            result = 2;
        } 
        return result;
    }
    public boolean colorMatch(){
        int total;
        boolean result;
        firstColor = colorToInt(tl.getFirstColor());
        secondColor = colorToInt(tl.getSecondColor());
        thirdColor = colorToInt(tl.getThirdColor());
        fourthColor = colorToInt(tl.getFourthColor());
        total = firstColor + secondColor + thirdColor + fourthColor;
        if (total == 4){
            result = true; 
        }else if (total == 8){
            result = true;
        }else if (total == 12){
            result = true;
        }else if (total == 16){
            result = true;
        }else if (total == 20){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    public boolean shapeMatch(){
        int total;
        boolean result;
        firstShape = shapeToInt(tl.getFirstShape());
        secondShape = shapeToInt(tl.getSecondShape());
        thirdShape = shapeToInt(tl.getThirdShape());
        fourthShape = shapeToInt(tl.getFourthShape());
        total  = firstShape + secondShape + thirdShape + fourthShape;
        if (total == 4){
            result = true;
        }else if (total == 8){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
}
