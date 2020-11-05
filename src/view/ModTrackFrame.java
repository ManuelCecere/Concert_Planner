package com.concertPlanner.view;

import com.concertPlanner.controller.Controller;
import com.concertPlanner.model.Condition;
import com.concertPlanner.model.Instruments;
import com.concertPlanner.model.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ModTrackFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JList list1;
    private JButton rimuoviButton;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JButton aggiungiButton;
    private JButton modificaButton;
    private JButton confermaButton;
    private List<Condition> conditions;

    public ModTrackFrame(Controller controller, int trackIndex) {
        super("Modifica");
        setContentPane(mainPanel);
        setSize(750, 600);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (Instruments instrument : Instruments.values()) {
            comboBox1.addItem(instrument);
        }
        conditions = controller.getConditionList(trackIndex);
        textField1.setText(controller.getTrackName(trackIndex));
        refresh();

        rimuoviButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(list1.getSelectedIndex()!=-1) {
                    conditions.remove(list1.getSelectedIndex());
                    refresh();
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(),"Seleziona un elemento da eliminare","Errore",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        aggiungiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if ((int)spinner1.getValue() > 0) {
                    Condition condition = new Condition((int) spinner1.getValue(), (Instruments) comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                    conditions.add(condition);
                    refresh();
                }
                else{
                    JOptionPane.showMessageDialog(new Frame(),"Valori nei campi non validi","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        modificaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (list1.getSelectedIndex()!=-1) {
                    if ((int) spinner1.getValue() > 0) {
                        Condition condition = conditions.get(list1.getSelectedIndex());
                        condition.setCountInstruments((int) spinner1.getValue());
                        condition.setTypeOfInstrument((Instruments) comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                        refresh();
                    } else {
                        JOptionPane.showMessageDialog(new Frame(), "Valori nei campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(), "Seleziona una condizione", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        list1.addListSelectionListener(e -> {
            if(list1.getSelectedIndex()!=-1){
                spinner1.setValue(conditions.get(list1.getSelectedIndex()).getCountInstruments());
                comboBox1.setSelectedItem(conditions.get(list1.getSelectedIndex()).getTypeOfInstrument());
            }
        });


        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(!textField1.getText().equals("")) {
                    Track track = new Track(textField1.getText(), conditions);
                    controller.modifyTrack(track, trackIndex);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(), "Valori nei campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void refresh(){
        list1.setListData(getConditionsList());
    }
    public Object[] getConditionsList(){
        List<String> list=new ArrayList<>();
        for (Condition c:conditions) {
            list.add("N°: " +c.getCountInstruments()+" tipo: "+c.getTypeOfInstrument());
        }
        return list.toArray();
    }
}