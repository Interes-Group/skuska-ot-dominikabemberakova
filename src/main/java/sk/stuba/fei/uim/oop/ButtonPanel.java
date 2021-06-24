package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@EqualsAndHashCode(callSuper = true)
@Data

public class ButtonPanel extends JPanel implements ActionListener {

    private JButton tree;
    private JButton house;
    private JButton road;
    private JLabel label;
    private MyCanvas canvas;
    private int currentColor;


    public ButtonPanel(MyCanvas canvas){

        this.tree = new JButton("Strom");
        this.house = new JButton("Dom");
        this.road = new JButton("Cesta");
        this.label = new JLabel("Strom");
        this.label.setOpaque(true);
        this.label.setBackground(Color.GREEN);
        this.canvas = canvas;
        this.currentColor = 0;

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(tree, constraints);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(house, constraints);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 0;
        this.add(road, constraints);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 0;
        this.add(label, constraints);
        tree.addActionListener(this);
        house.addActionListener(this);
        road.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tree){
            canvas.setDrawingTree(true);
            canvas.setDrawingHouse(false);
            canvas.setDrawingRoad(false);
            label.setText("Strom");
        }
        if (e.getSource() == house){
            canvas.setDrawingTree(false);
            canvas.setDrawingHouse(true);
            canvas.setDrawingRoad(false);
            label.setText("Dom");
        }
        if (e.getSource() == road){
            canvas.setDrawingTree(false);
            canvas.setDrawingHouse(false);
            canvas.setDrawingRoad(true);
            label.setText("Cesta");
        }

    }
}
