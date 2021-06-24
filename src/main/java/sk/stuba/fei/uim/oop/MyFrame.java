package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Application");
        this.setLocation(80, 80);
        this.setSize(800, 800);
        this.setLayout(new BorderLayout());
        MyCanvas canvas = new MyCanvas();
        ButtonPanel buttonPanel = new ButtonPanel(canvas);
        this.add("Center", canvas);
        this.add("North", buttonPanel);
        this.setVisible(true);
    }

}
