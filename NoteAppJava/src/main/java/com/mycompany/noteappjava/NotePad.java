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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    JTextArea textArea;
    JFrame frame;
    
    NotePad(){
        frame = new JFrame("editor");
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }
        
        textArea = new JTextArea();
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        
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
        
        menuBar.add()
    }
    
}