
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;

class TilePanel extends JPanel implements Serializable{
    private String firstColor;
    private String firstShape;
    private String secondColor;
    private String secondShape;
    private String thirdColor;
    private String thirdShape;
    private String fourthColor;
    private String fourthShape;
    public TilePanel(){
        Tile t1 = new Tile();
        t1.setRandomly();
        firstColor = t1.getFirstColor();
        firstShape = t1.getFirstShape();
        secondColor = t1.getSecondColor();
        secondShape = t1.getSecondShape();
        thirdColor = t1.getThirdColor();
        thirdShape = t1.getThirdShape();
        fourthColor = t1.getFourthColor();
        fourthShape = t1.getFourthShape();
    }
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
    public void setColorAndShape(ArrayList<String> list){
        firstColor = list.get(0);
        firstShape = list.get(1);
        secondColor = list.get(2);
        secondShape = list.get(3);
        thirdColor = list.get(4);
        thirdShape = list.get(5);
        fourthColor = list.get(6);
        fourthShape = list.get(7);
    }
   @Override
   public void paintComponent(Graphics g){
    super.paintComponent(g);
    switch (firstColor){
        case "red":
        g.setColor(Color.RED);
        repaint();
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        repaint();
        break;
        case "blue":
        g.setColor(Color.BLUE);
        repaint();
        break;
        case "yell":
        g.setColor(Color.YELLOW);
        repaint();
        break;
        case "green":
        g.setColor(Color.GREEN);
        repaint();
        break;
    }
    switch (firstShape){
        case "rect":
        g.fillRect(25, 150, 100, 100); 
        repaint();
        break;
        case "oval":
        g.fillOval(25, 150, 100, 100);
        repaint();
        break;
    }
    switch (secondColor){
        case "red":
        g.setColor(Color.RED);
        repaint();
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        repaint();
        break;
        case "blue":
        g.setColor(Color.BLUE);
        repaint();
        break;
        case "yell":
        g.setColor(Color.YELLOW);
        repaint();
        break;
        case "green":
        g.setColor(Color.GREEN);
        repaint();
        break;
    }
    switch (secondShape){
        case "rect":
        g.fillRect(150, 150, 100, 100); 
        repaint();
        break;
        case "oval":
        g.fillOval(150, 150, 100, 100);
        repaint();
        break;
    }
    switch (thirdColor){
        case "red":
        g.setColor(Color.RED);
        repaint();
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        repaint();
        break;
        case "blue":
        g.setColor(Color.BLUE);
        repaint();
        break;
        case "yell":
        g.setColor(Color.YELLOW);
        repaint();
        break;
        case "green":
        g.setColor(Color.GREEN);
        repaint();
        break;
    }
    switch (thirdShape){
        case "rect":
        g.fillRect(275, 150, 100, 100);
        repaint(); 
        break;
        case "oval":
        g.fillOval(275, 150, 100, 100);
        repaint();
        break;
    }
    switch (fourthColor){
        case "red":
        g.setColor(Color.RED);
        repaint();
        break;
        case "orange":
        g.setColor(Color.ORANGE);
        repaint();
        break;
        case "blue":
        g.setColor(Color.BLUE);
        repaint();
        break;
        case "yell":
        g.setColor(Color.YELLOW);
        repaint();
        break;
        case "green":
        g.setColor(Color.GREEN);
        repaint();
        break;
    }
    switch (fourthShape){
        case "rect":
        g.fillRect(400, 150, 100, 100); 
        repaint();
        break;
        case "oval":
        g.fillOval(400, 150, 100, 100);
        repaint();
        break;
    }
} 
}