package com.mycompany.noteappjava;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

/**
 *
 * @author Michel Hijazin
 */

public class NotePad extends JFrame implements ActionListener{
    
    JTextArea textArea;
    JFrame frame;
    
    NotePad(){
        frame = new JFrame("editor"); //new frame
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }
        
        textArea = new JTextArea(); //text component
        JMenuBar menuBar = new JMenuBar(); //menu bar
        JMenu menuFile = new JMenu("File"); //menu for menu
        
        //menu items
        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemPrint = new JMenuItem("Print");
        
        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemPrint.addActionListener(this);
        
        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemPrint);
        
        JMenu menuEdit = new JMenu("Edit");
        
        JMenuItem itemCut = new JMenuItem("Cut");
        JMenuItem itemCopy = new JMenuItem("Copy");
        JMenuItem itemPaste = new JMenuItem("Paste");
        
        itemCut.addActionListener(this);
        itemCopy.addActionListener(this);
        itemPaste.addActionListener(this);
        
        JMenuItem menuClose = new JMenuItem("Close");
        menuClose.addActionListener(this);
        
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuClose);
        
        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(500,500);
        frame.show();
    }
    
    public void actionPerformed(ActionEvent event){
        
        String command = event.getActionCommand();
        
        if(command.equals("Cut")){
            textArea.cut();
        } else if(command.equals("Cut")){
            textArea.copy();
            
        } else if(command.equals("Cut")){
            textArea.paste();
            
        } else if(command.equals("Save")){
            JFileChooser j = new JFileChooser("f:");
            
            int r = j.showSaveDialog(null);
            if(r == JFileChooser.APPROVE_OPTION){
                File file = new File(j.getSelectedFile().getAbsolutePath());
                
                try {
                    // Create a file writer
                    FileWriter wr = new FileWriter(file, false);
 
                    // Create buffered writer to write
                    BufferedWriter w = new BufferedWriter(wr);
 
                    // Write
                    w.write(textArea.getText());
 
                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            } else { //if operation cancelled 
                JOptionPane.showMessageDialog(frame, "Operation cancelled");
            }
        } else if(command.equals("Print")){
            try {
                // print the file
                textArea.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        } else if(command.equals("Open")){
            JFileChooser j = new JFileChooser("f:");
            
            int r = j.showOpenDialog(null);
            
            if(r == JFileChooser.APPROVE_OPTION){
                File file = new File(j.getSelectedFile().getAbsolutePath());
                
                try {
                    // String
                    String s1 = "", sl = "";
 
                    // File reader
                    FileReader fr = new FileReader(file);
 
                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);
 
                    // Initialize sl
                    sl = br.readLine();
 
                    // Take the input from the file
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }
 
                    // Set the text
                    textArea.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            } else {
            JOptionPane.showMessageDialog(frame,"Operation cancelled");
            
            }
        } else if(command.equals("New")){
            textArea.setText("");
        } else if (command.equals("Close")){
            frame.setVisible(false);
        }
    }
    
//    public static void main(String[] args){
//        NotePad pad = new NotePad();
//    }
    
}