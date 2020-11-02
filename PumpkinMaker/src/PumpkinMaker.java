/**
 * This program will enable users to draw pumpkins to their specific specifications.
 * @author Max Lewis
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is the JPanel that makes it so the program can draw
 */
class DrawingBoard extends JPanel{
    private int left; 
    private int top;
    private int pumpkinWidth;
    private int pumpkinHeight;
    private String eyeType; // C=circle S=square T=triangle
    private String noseType; // C=circle S=square T=triangle
    private String mouthType; //O=oval R=rectangle
    public void setPumpkinLeft(int leftP){
        left = leftP;
    }
    public int getPumpkinLeft(){
        return left;
    }
    public void setPumpkinTop(int topP){
        top = topP;
    }
    public int getPumpkinTop(){
        return top;
    }
    public void setPumpkinWidth(int widthP){
        pumpkinWidth = widthP;
    }
    public int getPumpkinWidth(){
        return pumpkinWidth;
    }
    public void setPumpkinHeight(int heightP){
        pumpkinHeight = heightP;
    }
    public int getPumpkinHeight(){
        return pumpkinHeight;
    }
    public void setEyeType(String eyeP){
        eyeType = eyeP;
    }
    public String getEyeType(){
        return eyeType;
    }
    public void setNoseType(String noseP){
        noseType = noseP;
    }
    public String getNoseType(){
        return noseType;
    }
    public void setMouthType(String mouthP){
        mouthType = mouthP;
    }
    public String getMouthType(){
        return mouthType;
    }
    /**
     * Default constructor to initialize values
     */
    public DrawingBoard(){
        top = 100;
        left = 100;
        pumpkinWidth = 100;
        pumpkinHeight = 100;
        eyeType = "O";
        noseType = "S";
        mouthType = "R";
    }
    /**
     * This paints the pumpkin to the user's specifications 
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int top = getPumpkinTop();
        int left = getPumpkinLeft();
        int width = getPumpkinWidth();
        int height = getPumpkinHeight();
        String eyeType = getEyeType();
        String noseType = getNoseType();
        String mouthType = getMouthType();
        g.setColor(Color.ORANGE); //pumpkin
        g.fillOval(left, top, width, height);
        g.setColor(Color.WHITE); //stem
        g.fillRect(left + (width * 4/10), top - (height * 4/24), width/5, height/5);
        if (eyeType.equalsIgnoreCase("C")){ 
            g.setColor(Color.WHITE);
            g.fillOval(left + (width * 2/8), top + (height * 1/8), width/8, height/8);
            g.setColor(Color.WHITE);
            g.fillOval(left + (width * 5/8), top + (height * 1/8), width/8, height/8);
        }else if (eyeType.equalsIgnoreCase("S")){
            g.setColor(Color.WHITE);
            g.fillRect(left + (width * 2/8), top + (height * 1/8), width/8, height/8);
            g.setColor(Color.WHITE);
            g.fillRect(left + (width * 5/8), top + (height * 1/8), width/8, height/8);
        }else if (eyeType.equalsIgnoreCase("T")){
            int[] xLeft = new int[3];
            int[] yLeft = new int[3];
            int[] xRight = new int[3];
            int[] yRight = new int[3];
            xLeft[0] = (left + (width * 2/8));
            xLeft[1] = (left + (width * 35/100));
            xLeft[2] = (left + (width * 45/100));
            yLeft[0] = (top + (height * 35/100));
            yLeft[1] = (top + (height * 25/100));
            yLeft[2] = (top + (height * 35/100));
            xRight[0] = (left + (width * 5/8));
            xRight[1] = (left + (width * 73/100));
            xRight[2] = (left + (width * 83/100));
            yRight[0] = (top + (height * 35/100));
            yRight[1] = (top + (height * 25/100));
            yRight[2] = (top + (height * 35/100));
            g.setColor(Color.WHITE);
            g.fillPolygon(xLeft, yLeft, 3);
            g.setColor(Color.WHITE);
            g.fillPolygon(xRight, yRight, 3);
        }
        if (noseType.equalsIgnoreCase("C")){
            g.setColor(Color.WHITE);
            g.fillOval(left + (width * 4/10), top + (height * 3/8), width/7, height/7);
        }else if (noseType.equalsIgnoreCase("S")){
            g.setColor(Color.WHITE);
            g.fillRect(left + (width * 4/10), top + (height * 3/8), width/7, height/7);
        }else if (noseType.equalsIgnoreCase("T")){
            int[] x = new int[3];
            int[] y = new int[3];
            x[0] = (left + (width * 4/10));
            x[1] = (left + (width * 1/2));
            x[2] = (left + (width * 60/100));
            y[0] = (top + (height * 86/150));
            y[1] = (top + (height * 61/150));
            y[2] = (top + (height * 86/150));
            g.setColor(Color.WHITE);
            g.fillPolygon(x, y, 3);
        }
        if (mouthType.equalsIgnoreCase("O")){
            g.setColor(Color.WHITE);
            g.fillOval(left + (width * 3/11), top + (height * 7/10), width/2, height/10);
        }else if (mouthType.equalsIgnoreCase("R")){
            g.setColor(Color.WHITE);
            g.fillRect(left + (width * 3/11), top + (height * 7/10), width/2, height/10);
        }
    }
}
/**
 * This is the JFrame that builds the window, button, textfield, and label
 */
class GameWindow extends JFrame{
    /**
     * This centers the frame in the user's window
     */
    public void centerFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();  
		int screenWidth = (int)dim.getWidth();
		int screenHeight = (int)dim.getHeight();
		int frameWidth = 800;
		int frameHeight = 480;
		int left = (screenWidth - frameWidth)/2;
		int top = (screenHeight - frameHeight)/2;
		setBounds(left, top, frameWidth, frameHeight);
    }
    /**
     * This sets the look of the frame
     * This frame also tests and makes sure all of the text boxes are filled correctly
     * @param title "Pumpkin Maker" title that I intialized earlier
     */
    public void setLook(String title){
        setTitle(title);
        centerFrame();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        DrawingBoard panCenter =  new DrawingBoard();
        JPanel btmLabel = new JPanel();
        btmLabel.setLayout(new FlowLayout());
        c.add(panCenter, BorderLayout.CENTER);
        c.add(btmLabel, BorderLayout.SOUTH);
        JLabel topLabel = new JLabel("Top:");
        JTextField topTxt = new JTextField(3);
        JLabel leftLabel = new JLabel("Left:");
        JTextField leftTxt = new JTextField(3);
        JLabel widthLabel = new JLabel("Width:");
        JTextField widthTxt = new JTextField(3);
        JLabel heightLabel = new JLabel("Height:");
        JTextField heightTxt = new JTextField(3);
        JLabel eyeLabel = new JLabel("Eye (C S T):");
        JTextField eyeTxt = new JTextField(3);
        JLabel noseLabel = new JLabel("Nose (C S T):");
        JTextField noseTxt = new JTextField(3);
        JLabel mouthLabel = new JLabel("Mouth (O R):");
        JTextField mouthTxt = new JTextField(3);
        JButton btnClick = new JButton("Draw");
        btmLabel.add(topLabel, BorderLayout.SOUTH);
        btmLabel.add(topTxt, BorderLayout.SOUTH);
        btmLabel.add(leftLabel, BorderLayout.SOUTH);
        btmLabel.add(leftTxt, BorderLayout.SOUTH);
        btmLabel.add(widthLabel, BorderLayout.SOUTH);
        btmLabel.add(widthTxt, BorderLayout.SOUTH);
        btmLabel.add(heightLabel, BorderLayout.SOUTH);
        btmLabel.add(heightTxt, BorderLayout.SOUTH);
        btmLabel.add(eyeLabel, BorderLayout.SOUTH);
        btmLabel.add(eyeTxt, BorderLayout.SOUTH);
        btmLabel.add(noseLabel, BorderLayout.SOUTH);
        btmLabel.add(noseTxt, BorderLayout.SOUTH);
        btmLabel.add(mouthLabel, BorderLayout.SOUTH);
        btmLabel.add(mouthTxt, BorderLayout.SOUTH);
        btmLabel.add(btnClick, BorderLayout.SOUTH);
        panCenter.setPumpkinTop(200);
        panCenter.setPumpkinLeft(100);
        panCenter.setPumpkinWidth(100);
        panCenter.setPumpkinHeight(100);
        panCenter.setEyeType("C");
        panCenter.setNoseType("S");
        panCenter.setMouthType("O");
        btnClick.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String eye = eyeTxt.getText().trim();
                String nose = noseTxt.getText().trim();
                String mouth = mouthTxt.getText().trim();
                String top = topTxt.getText().trim();
                String left = leftTxt.getText().trim();
                String width = widthTxt.getText().trim();
                String height= heightTxt.getText().trim();
                int topCounter = 0;
                int leftCounter = 0;
                int widthCounter = 0;
                int heightCounter = 0;   
                int eyeCounter = 0;
                int noseCounter = 0;
                int mouthCounter = 0;
                int proceed = 0;
                try{
                    Integer.parseInt(top);
                }catch (Exception ex){
                    topCounter = 1;
                }
                try{
                    Integer.parseInt(left);
                }catch (Exception ex){
                    leftCounter = 1;
                }
                try{
                    Integer.parseInt(width);
                }catch (Exception ex){
                    widthCounter = 1;
                }
                try{
                    Integer.parseInt(height);
                }catch (Exception ex){
                    heightCounter = 1;
                }
                try{
                    Integer.parseInt(eye);
                }catch(Exception ex){
                    eyeCounter = 1;
                }
                try{
                    Integer.parseInt(nose);
                }catch (Exception ex){
                    noseCounter = 1;
                }
                try{
                    Integer.parseInt(mouth);
                }catch (Exception ex){
                    mouthCounter = 1;
                }
                if (topCounter == 1 || top.length() == 0){
                    JOptionPane.showMessageDialog(null, "Enter an int for Top.");
                }else if (leftCounter == 1 || left.length() == 0){
                    JOptionPane.showMessageDialog(null, "Enter an int for Left.");
                }else if (widthCounter == 1 || width.length() == 0){
                    JOptionPane.showMessageDialog(null, "Enter an int for Width.");
                }else if (heightCounter == 1 || height.length() == 0){
                    JOptionPane.showMessageDialog(null, "Enter an int for Height.");
                }
                if (eyeCounter == 0 || eye.length() == 0 || (!eye.equalsIgnoreCase("c") && !eye.equalsIgnoreCase("s") && !eye.equalsIgnoreCase("t"))){
                    JOptionPane.showMessageDialog(null, "Enter a C, S, or T for Eye.");
                    eyeCounter = 0;
                }else if (noseCounter == 0 || nose.length() == 0 || (!nose.equalsIgnoreCase("c") && !nose.equalsIgnoreCase("s") && !nose.equalsIgnoreCase("t"))){
                    JOptionPane.showMessageDialog(null, "Enter a C, S, or T for Nose.");
                    eyeCounter = 0;
                }else if (mouthCounter == 0 || mouth.length() == 0 || (!mouth.equalsIgnoreCase("o") && !mouth.equalsIgnoreCase("r"))){
                    JOptionPane.showMessageDialog(null, "Enter an O or R for Mouth.");
                    eyeCounter = 0;
                }
                if (topCounter == 0){
                    proceed++;
                    panCenter.setPumpkinTop(Integer.parseInt(top));
                }
                if (leftCounter == 0){
                    proceed++;
                    panCenter.setPumpkinLeft(Integer.parseInt(left));
                }
                if (widthCounter == 0){
                    proceed++;
                    panCenter.setPumpkinWidth(Integer.parseInt(width));
                }
                if (heightCounter == 0){
                    proceed++;
                    panCenter.setPumpkinHeight(Integer.parseInt(height));
                }
                if (eyeCounter == 1){
                    proceed++;
                    panCenter.setEyeType(eye);
                }
                if (noseCounter == 1){
                    proceed++;
                    panCenter.setNoseType(nose);
                }
                if (mouthCounter == 1){
                    proceed++;
                    panCenter.setMouthType(mouth);
                }
                if (proceed == 7){
                    repaint();
                }else {
                    proceed = 0;
                }
                }
            });  
    }
    /**
     * Defualt constructor to specify title and exit status
     */
    public GameWindow(){
        setLook("Pumpkin Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Feeds title and close operatiom
     * @param title title for frame
     * @param closeOp how the frame will exit the program
     */
    public GameWindow(String title, int closeOp){
        setLook(title);
        setDefaultCloseOperation(closeOp);
    }
}
/**
 * makes a GameWindow frm and sets it visible
 */
public class PumpkinMaker {
    public static void main(String[] args){
        GameWindow frm = new GameWindow();
        frm.setVisible(true);
    }
}