package com.concertPlanner.view;

import com.concertPlanner.controller.Controller;
import com.concertPlanner.model.Instruments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModPlayerFrame extends JFrame{
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JComboBox comboBox1;
    private JCheckBox checkBox1;
    private JButton confermaButton;
    private JPanel mainPanel;

    public ModPlayerFrame(Controller controller, int playerIndex){
        super("Modifica");
        setContentPane(mainPanel);
        setSize(500, 600);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (Instruments instrument:Instruments.values()) {
            comboBox1.addItem(instrument);
        }
        textFieldName.setText(controller.getPlayerName(playerIndex));
        textFieldSurname.setText(controller.getPlayerSurname(playerIndex));
        comboBox1.setSelectedItem(controller.getPlayerInstrument(playerIndex));
        checkBox1.setSelected(controller.isPlayerAvailable(playerIndex));

        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!textFieldName.getText().equals("") && !textFieldSurname.getText().equals("") && comboBox1.getSelectedIndex()!=-1) {
                    controller.modifyPlayer(textFieldName.getText(), textFieldSurname.getText(), (Instruments) comboBox1.getItemAt(comboBox1.getSelectedIndex()), checkBox1.isSelected(),playerIndex);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(),"Valori nei campi non validi","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
