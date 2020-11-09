
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class TilePanel extends JPanel{
    Tile tl = new Tile(); 
    private String firstColor = tl.getFirstColor();
    private String firstShape = tl.getFirstShape();
    private String secondColor = tl.getSecondColor();
    private String secondShape = tl.getSecondShape();
    private String thirdColor = tl.getThirdColor();
    private String thirdShape = tl.getThirdShape();
    private String fourthColor = tl.getFourthColor();
    private String fourthShape = tl.getFourthShape();
    public ArrayList<String> getColorAndShape(){
        ArrayList<String> result = new ArrayList<String>();
        result.add(firstColor);
        result.add(firstShape);
        result.add(secondColor);
        result.add(secondShape);
        result.add(thirdColor);
        result.add(thirdShape);
        result.add(fourthColor);
        result.add(fourthShape);
        return result;
    }
   @Override
   public void paintComponent(Graphics g){
    super.paintComponent(g);
    switch (firstColor){
        case "red":
        g.setColor(Color.RED);
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        break;
        case "blue":
        g.setColor(Color.BLUE);
        break;
    }
    switch (firstShape){
        case "rect":
        g.fillRect(25, 150, 100, 100); 
        break;
        case "oval":
        g.fillOval(25, 150, 100, 100);
        break;
    }
    switch (secondColor){
        case "red":
        g.setColor(Color.RED);
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        break;
        case "blue":
        g.setColor(Color.BLUE);
        break;
    }
    switch (secondShape){
        case "rect":
        g.fillRect(150, 150, 100, 100); 
        break;
        case "oval":
        g.fillOval(150, 150, 100, 100);
        break;
    }
    switch (thirdColor){
        case "red":
        g.setColor(Color.RED);
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        break;
        case "blue":
        g.setColor(Color.BLUE);
        break;
    }
    switch (thirdShape){
        case "rect":
        g.fillRect(275, 150, 100, 100); 
        break;
        case "oval":
        g.fillOval(275, 150, 100, 100);
        break;
    }
    switch (fourthColor){
        case "red":
        g.setColor(Color.RED);
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        break;
        case "blue":
        g.setColor(Color.BLUE);
        break;
    }
    switch (fourthShape){
        case "rect":
        g.fillRect(400, 150, 100, 100); 
        break;
        case "oval":
        g.fillOval(400, 150, 100, 100);
        break;
    }
} 
}