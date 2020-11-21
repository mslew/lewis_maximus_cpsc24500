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
    private TileChecker tc = new TileChecker();
    private boolean shapeStatus;
    private boolean colorStatus;
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
        JButton btnMax = new JButton("Max");
        btnMax.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                colorStatus = tc.colorMatch();
                shapeStatus = tc.shapeMatch();
                if (colorStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (colorStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
                if (shapeStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (shapeStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
            }
        });
        JButton btnMid = new JButton("Mid");
        btnMid.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                colorStatus = tc.colorMatch();
                shapeStatus = tc.shapeMatch();
                if (colorStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (colorStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
                if (shapeStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (shapeStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
            }
        });
        JButton btnMin = new JButton("Min");
        btnMin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pan.setForRandomize();
                colorStatus = tc.colorMatch();
                shapeStatus = tc.shapeMatch();
                if (colorStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (colorStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
                if (shapeStatus == true){
                    JOptionPane.showMessageDialog(null, "You have a match");
                }else if (shapeStatus == false){
                    //JOptionPane.showMessageDialog(null, "You suck");
                }
            }
        });
        JTextField txtBalance = new JTextField(6);
        txtBalance.setEditable(false);
        txtBalance.setText("5");
        if (Integer.parseInt(txtBalance.getText()) <= 0){
            JOptionPane.showMessageDialog(null, "You lost!");
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
                //DO SOMETHING LATER HERE 
            }
        });
        JMenuItem miRestart = new JMenuItem("Restart");
        miRestart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //DO SOMETHING LATER HERE 
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