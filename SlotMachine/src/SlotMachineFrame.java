/**
 * This class builds the frame for the user
 * @author Max Lewis 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.lang.Math;

class SlotMachineFrame extends JFrame {
    private TilePanel pan = new TilePanel();
    private double balance;
    private double wager;
    private final JButton btnMax = new JButton("Max");
    private final JButton btnMid = new JButton("Mid");
    private final JButton btnMin = new JButton("Min");
    private final JTextField txtBalance = new JTextField(6);
    /**
     * This is the getter and setter for the balance
     * @return balance
     */
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    /**
     * This is the getter and setter for the wager amount 
     * @return wager
     */
    public double getWager(){
        return wager;
    }
    public void setWager(double wager){
        this.wager = wager;
    }
    /**
     * This setups the look. adding the various panels, menu, labels, and buttons
     */
    public void setupLook(){
        setBounds(100, 100, 540, 500);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        pan = new TilePanel();
        c.add(pan, BorderLayout.CENTER);
        JPanel top = new JPanel();
        top.add(new JLabel("SLOTS"));
        c.add(top, BorderLayout.NORTH);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        txtBalance.setEditable(false);
        txtBalance.setText("5");
        /**
         * This is the code for the buttons. It calls the tile checker to determine if there are color matches or 
         * shape matches. The only difference being the wager differences between the three wagers. 
         */
        btnMax.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Double.parseDouble(txtBalance.getText()));
                setWager(getBalance());
                if (pan.getColorStatus() == true){
                    //25*
                    balance = wager * 25;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }else if (pan.getColorStatus() == false){
                    balance = 0;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                if ((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //100*
                    balance = wager * 100;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                checkBalance(balance);
            }
        });
        btnMid.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Double.parseDouble(txtBalance.getText()));
                setWager(.5 * getBalance());
                if (pan.getColorStatus() == true){
                    //10*
                    balance = (wager * 10) + balance;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }else if (pan.getColorStatus() == false){
                    //-10*
                    balance = balance - wager;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                if ((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //50*
                    balance = wager * 50;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                checkBalance(balance);
            }
        });
        btnMin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Double.parseDouble(txtBalance.getText()));
                setWager(.1 * getBalance());
                if (pan.getColorStatus() == true){
                    //5*
                    balance = (wager * 5) + balance;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }else if (pan.getColorStatus() == false){
                    //-5*
                    balance = balance - wager;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                if((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //10*
                    balance = (wager * 10) + wager;
                    setBalance(balance);
                    txtBalance.setText(Double.toString(Math.round(balance * 100.0) / 100.0));
                }
                checkBalance(balance);
            }
        });
        panSouth.add(btnMax);
        panSouth.add(btnMid);
        panSouth.add(btnMin);
        panSouth.add(new JLabel("$"));
        panSouth.add(txtBalance);
        c.add(panSouth,BorderLayout.SOUTH);
        setupMenu();
    }
    /**
     * This setups the menu. Adding a file and a help. 
     */
    public void setupMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem miSave =  new JMenuItem("Save Tiles");
        /**
         * Prints the contents of each slot in a .TXT, .BIN, or .XML file
         */
        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser jfc = new JFileChooser();
                TileWriter tw =  new TileWriter();
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    if (tw.write(jfc.getSelectedFile(), pan.getColorAndShape())){
                        JOptionPane.showMessageDialog(null, "Wrote color and shape for each slot.");
                    }else {
                        JOptionPane.showMessageDialog(null, "Could not write shape and color to file.");
                    }
                }
            }
        });
        JMenuItem miLoad = new JMenuItem("Load Tiles");
        /**
         * Loads the contents of each slot in a .TXT, .BIN, or .XML file
         */
        miLoad.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser jfc = new JFileChooser();
                TileReader tr = new TileReader();
                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    ArrayList<String> colorAndShapeRead = tr.read(jfc.getSelectedFile());
                    if (colorAndShapeRead == null){
                        JOptionPane.showMessageDialog(null, "Could not read color and shape from selected file.");
                    } else{
                        pan.setColorAndShape(colorAndShapeRead);
                    } 
                }
            }
        });
        JMenuItem miPrint = new JMenuItem("Print");
        /**
         * Prints out the values of each slot 
         */
        miPrint.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.print();
            }
        });
        JMenuItem miRestart = new JMenuItem("Restart");
        /**
         * Restarts the program. Sets the balance to 5 and randomizes the slots 
         */
        miRestart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                balance = 5.0;
                setBalance(balance);
                txtBalance.setText(Double.toString(balance));
                btnMax.setEnabled(true);
                btnMid.setEnabled(true);
                btnMin.setEnabled(true);
            }
        });
        JMenuItem miExit = new JMenuItem("Exit");
        /**
         * Exits the program 
         */
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }); 
        mnuFile.add(miSave);
        mnuFile.add(miLoad);
        mnuFile.add(miPrint);
        mnuFile.add(miRestart);
        mnuFile.add(miExit);
        JMenu mnuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        /**
         * This provides information about the program 
         */
        miAbout.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "This application was created by Maximus Lewis. https://github.com/mslew/lewis_maximus_cpsc24500. COPYRIGHT 2020");
            }
        });
        JMenuItem miBettingHelp = new JMenuItem("Betting Help");
        /**
         * This gives help to the user if they have a gambling problem 
         */
        miBettingHelp.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "If you have a gambling problem. Call 1-800-GAMBLER");
            }
        });
        mnuHelp.add(miBettingHelp);
        mnuHelp.add(miAbout);
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        setJMenuBar(mbar);
    }
    /**
     * this is the constructor. it simply sets up the look, close operation, and the title for the window
     */
    public SlotMachineFrame(){
        setupLook();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Vegas Baby");
    }
    /**
     * This is the code to determine if the user has gone bankrupt
     * This is called multiple times through each button 
     * @param balance the balance after the bet was placed 
     */
    public void checkBalance(Double balance){
        if (balance < 0.01 || balance < 0.05){
            JOptionPane.showMessageDialog(null, "Bankrupt!");
            btnMax.setEnabled(false);
            btnMid.setEnabled(false);
            btnMin.setEnabled(false);
        }else {
            btnMax.setEnabled(true);
            btnMid.setEnabled(true);
            btnMin.setEnabled(true);
        }
    }
}