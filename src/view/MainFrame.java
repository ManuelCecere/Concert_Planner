package com.concertPlanner.view;

import com.concertPlanner.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JList playersList;
    private JList tracksList;
    private JButton addButton;
    private JButton removeButton;
    private JButton modButton;
    private Controller controller;
    private boolean trackListSelected=false;

    public MainFrame(String title){
        super(title);
        controller = new Controller(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.getContentPane().setPreferredSize(new Dimension(800, 300));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.pack();
        setLocation(dim.width / 2 - this.getSize().width/2 , dim.height / 2 - this.getSize().height/2);


        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(!trackListSelected) {
                    JFrame addPlayerFrame = new AddPlayerFrame(controller);
                    addPlayerFrame.setVisible(true);
                }
                else {
                    JFrame addTrackFrame = new AddTrackFrame(controller);
                    addTrackFrame.setVisible(true);
                }
            }
        });
        removeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int index = (trackListSelected ? tracksList.getSelectedIndex() : playersList.getSelectedIndex());
                if (trackListSelected ? tracksList.getSelectedIndex() == -1 : playersList.getSelectedIndex()==-1) { JOptionPane.showMessageDialog(new Frame(),"Seleziona un elemento da eliminare","Errore",JOptionPane.ERROR_MESSAGE);}

                else {
                    JDialog confirmDialog = new ConfirmDialog(controller, index, trackListSelected);
                    confirmDialog.setVisible(true);
                }
            }
        });
        modButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(!trackListSelected) {
                    if (playersList.getSelectedIndex() != -1) {
                        JFrame modPlayerFrame = new ModPlayerFrame(controller, playersList.getSelectedIndex());
                        modPlayerFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(new Frame(), "Seleziona un elemento da modificare", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    if(tracksList.getSelectedIndex()!=-1){
                        JFrame modTrackFrame = new ModTrackFrame(controller, tracksList.getSelectedIndex());
                        modTrackFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new Frame(), "Seleziona un elemento da modificare", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        playersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                trackListSelected=false;
                tracksList.clearSelection();
            }
        });
        tracksList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                trackListSelected=true;
                playersList.clearSelection();
            }
        });
        controller.modelInit();
        refresh();
    }

    public void refresh() {

        playersList.setListData(controller.getPlayerInfos());
        tracksList.setListData(controller.getTrackNames());
        tracksList.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (controller.istrackDoable(index)){c.setBackground(new Color(0x9566E034, true));}
                else {c.setBackground(new Color(0x8BB60F0F, true));}
                return c;
            }
            });

    }



}
