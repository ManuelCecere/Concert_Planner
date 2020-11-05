package com.concertPlanner.view;

import com.concertPlanner.controller.Controller;
import com.concertPlanner.model.Instruments;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddPlayerFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBoxInstruments;
    private JCheckBox checkBox1;
    private JButton confermaButton;


    public AddPlayerFrame(Controller controller)  {
        super("Aggiungi");
        setContentPane(mainPanel);
        setSize(500, 600);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (Instruments instrument:Instruments.values()) {
            comboBoxInstruments.addItem(instrument);
        }

        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!textField1.getText().equals("") && !textField2.getText().equals("") && comboBoxInstruments.getSelectedIndex()!=-1) {
                    controller.addPlayer(textField1.getText(), textField2.getText(), (Instruments) comboBoxInstruments.getItemAt(comboBoxInstruments.getSelectedIndex()), checkBox1.isSelected());
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(),"Valori nei campi non validi","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
