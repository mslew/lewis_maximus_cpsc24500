/**
 * This class builds the frame for the user
 * @author Max Lewis 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class SlotMachineFrame extends JFrame {
    private TilePanel pan;
    private int balance;
    private JButton btnMax = new JButton("Max");
    private JButton btnMid = new JButton("Mid");
    private JButton btnMin = new JButton("Min");
    private JTextField txtBalance = new JTextField(6);
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
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
        //JTextField txtBalance = new JTextField(6);
        txtBalance.setEditable(false);
        txtBalance.setText("5");
        //JButton btnMax = new JButton("Max");
        btnMax.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Integer.parseInt(txtBalance.getText()));
                if (pan.getColorStatus() == true){
                    //25*
                    balance = balance * 25;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }else if (pan.getColorStatus() == false){
                    //-25*
                }
                if ((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //100*
                    balance = balance * 100;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }
            }
        });
        //JButton btnMid = new JButton("Mid");
        btnMid.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Integer.parseInt(txtBalance.getText()));
                if (pan.getColorStatus() == true){
                    //10*
                    balance = balance * 10;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }else if (pan.getColorStatus() == false){
                    //-10*
                }
                if ((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //50*
                    balance = balance * 50;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }
            }
        });
        //JButton btnMin = new JButton("Min");
        btnMin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                setBalance(Integer.parseInt(txtBalance.getText()));
                if (pan.getColorStatus() == true){
                    //5*
                    balance = balance * 5;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }else if (pan.getColorStatus() == false){
                    //-5*
                }
                if((pan.getColorStatus() == true) && (pan.getShapeStatus() == true)){
                    //10*
                    balance = balance * 10;
                    setBalance(balance);
                    txtBalance.setText(Integer.toString(balance));
                }
            }
        });
        if (Integer.parseInt(txtBalance.getText()) == 0){
            JOptionPane.showMessageDialog(null, "Bankrupt!");
            btnMax.setEnabled(false);
            btnMid.setEnabled(false);
            btnMin.setEnabled(false);
        }else {
            btnMax.setEnabled(true);
            btnMid.setEnabled(true);
            btnMin.setEnabled(true);
        }
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
        miPrint.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.print("First Slot:\nColor:\nShape:\n\nSecond Slot:\nColor:\nShape:\n\nThird Slot:\nColor:\nShape:\n\nFourth Slot:\nColor:\nShape:\n\n");
            }
        });
        JMenuItem miRestart = new JMenuItem("Restart");
        miRestart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                balance = 5;
                setBalance(balance);
                txtBalance.setText(Integer.toString(balance));
                btnMax.setEnabled(true);
                btnMid.setEnabled(true);
                btnMin.setEnabled(true);
            }
        });
        JMenuItem miExit = new JMenuItem("Exit");
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
        miAbout.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "This application was created by Maximus Lewis. https://github.com/mslew/lewis_maximus_cpsc24500. COPYRIGHT 2020");
            }
        });
        JMenuItem miBettingHelp = new JMenuItem("Betting Help");
        miBettingHelp.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "If you have a gambiling problem. Call 1-800-GAMBLER");
            }
        });
        mnuHelp.add(miBettingHelp);
        mnuHelp.add(miAbout);
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        setJMenuBar(mbar);
    }
    /**
     * this is the constructor. it simply setsup the look, close operation, and the title for the window
     */
    public SlotMachineFrame(){
        setupLook();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Vegas Baby");
    }
}