package com.concertPlanner;

import com.concertPlanner.view.MainFrame;

import javax.swing.*;



public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        MainFrame mainFrame= new MainFrame("Concert Planner");
        mainFrame.setVisible(true);
    }
}
