/**
 * This class handles the drawing of each slot on the slot machine
 * This also handles the data from the TileWriter and TileReader class, taken freom SlotMachineFrame
 * Also allows the user to click a specific slot to randomly change color and shape 
 * @author Max Lewis 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;

class TilePanel extends JPanel implements Serializable, MouseListener{
    private String firstColor;
    private String firstShape;
    private String secondColor;
    private String secondShape;
    private String thirdColor;
    private String thirdShape;
    private String fourthColor;
    private String fourthShape;
    private int x;
    private int y;
    /**
     * Default constructor to intialize the values for each slot 
     */
    public TilePanel(){
        Tile tl = new Tile();
        tl.setRandomly();
        addMouseListener(this);
        firstColor = tl.getFirstColor();
        firstShape = tl.getFirstShape();
        secondColor = tl.getSecondColor();
        secondShape = tl.getSecondShape();
        thirdColor = tl.getThirdColor();
        thirdShape = tl.getThirdShape();
        fourthColor = tl.getFourthColor();
        fourthShape = tl.getFourthShape();
    }
    /**
     * this function is used for the TileReader class. this makes a list of each slot's color and shape
     * @return result. this is the arraylist of strings. its format is color, then shape
     */
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
    /**
     * This function is used for the TileWriter class. this grabs each value from an arraylist 
     * @param list the array list of values for each slot. color, then shape. 
     */
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
    /**
     * This paints each slot. Utilizes switch, cases to determine each slot's 
     * color and shape. 
     */
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
    /**
     * getter and setters for x and y. used for the mouse click 
     * @return
     */
    public int myGetX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    } 
    public int myGetY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    /**
     * This is a MouseListener for a mouse press
     * it sets the x and y. using its inherited "get" function
     * This also calls the changeColor() function and repaints 
     */
    @Override
    public void mousePressed(MouseEvent e){
        setX(e.getX());
        setY(e.getY());
        changeColorAndShape();
        repaint();
    }
    /**
     * this function grabs the value for x and y.
     * it determines where exactly the mouse was pressed
     * if it was pressed within the range of each slot,
     * then it calls each slot's respective change color and shape function 
     * in the tile class. grabs the data from tile. and sets each in the TilePanel class 
     * repaints when done
     */
    public void changeColorAndShape(){
        int x = myGetX();
        int y = myGetY();
        Tile tl = new Tile();
        if ((x >= 25  && x <= 125) && (y>=150 && y<=250)){
            tl.changeFirstColorAndShape();
            firstColor = tl.getFirstColor();
            firstShape = tl.getFirstShape();
            repaint();
        }
        if ((x >= 150  && x <= 250) && (y>=150 && y<=250)){
            tl.changeSecondColorAndShape();
            secondColor = tl.getSecondColor();
            secondShape = tl.getSecondShape();
            repaint();
        }
        if ((x >= 275  && x <= 375) && (y>=150 && y<=250)){
            tl.changeThirdColorAndShape();
            thirdColor = tl.getThirdColor();
            thirdShape = tl.getThirdShape();
            repaint();
        }
        if ((x >= 400  && x <= 500) && (y>=150 && y<=250)){
            tl.changeFourthColorAndShape();
            fourthColor = tl.getFourthColor();
            fourthShape = tl.getFourthShape();
            repaint();
        }
    }
    /**
     * Code would not run without these. they do absolutely nothing 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}