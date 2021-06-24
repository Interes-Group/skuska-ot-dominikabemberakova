package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener{

    private ArrayList<ShapeTree> trees;
    private ArrayList<ShapeHouse> houses;
    private ArrayList<ShapeRoad> roads;
    private ShapeTree currentTree;
    private ShapeHouse currentHouse;
    private ShapeRoad currentRoad;
    private int xPosition;
    private int yPosition;
    private int xMoving;
    private int yMoving;
    private int currentColorPos;
    private int startType;
    private Color currentColor;
    private ArrayList<Color> colors;
    private boolean drawingTree;
    private boolean drawingHouse;
    private boolean drawingRoad;

    public MyCanvas(){
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.xPosition = 0;
        this.yPosition = 0;
        this.xMoving = 0;
        this.yMoving = 0;
        this.currentColorPos = 0;
        this.startType = 0;
        this.currentColor = Color.GREEN;
        this.drawingTree = true;
        this.drawingHouse = false;
        this.drawingRoad = false;
        this.trees = new ArrayList<>();
        this.houses = new ArrayList<>();
        this.roads = new ArrayList<>();
        this.colors = new ArrayList<>();
        this.colors.add(Color.GREEN);
        this.colors.add(Color.ORANGE);
        this.colors.add(Color.RED);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.CYAN);
        this.colors.add(Color.MAGENTA);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);

        for (ShapeTree tree : trees){
            tree.drawShape(g);
        }
        for (ShapeHouse house : houses){
            house.drawShape(g);
        }
        for (ShapeRoad road : roads){
            road.drawShape(g);
        }
        if (currentRoad != null){
            currentRoad.drawShape(g);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        xPosition = e.getX();
        yPosition = e.getY();
        if (drawingTree){
            currentTree = new ShapeTree(xPosition-25, yPosition-25, 50, 50, currentColor);
        }
        if (drawingHouse){
            currentHouse = new ShapeHouse(xPosition-25, yPosition-25, 50, 50, currentColor);
        }
        if (drawingRoad){

            Tree:
            for(ShapeTree tree : trees){
                if(tree.contains(xPosition, yPosition)){
                    currentRoad = new ShapeRoad((int)(tree.getX()+25), (int)(tree.getY()+25), xPosition, yPosition, Color.BLACK);
                    startType = 1;
                    break Tree;
                }
            }
            House:
            for(ShapeHouse house : houses){
                if(house.contains(xPosition, yPosition)){
                    currentRoad = new ShapeRoad((int)(house.getX()+25), (int)(house.getY()+25), xPosition, yPosition, Color.BLACK);
                    startType = 2;
                    break House;
                }
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        xPosition = e.getX();
        yPosition = e.getY();

        if (drawingTree && currentTree != null) {
            trees.add(currentTree);
        }
        if (drawingHouse && currentHouse != null) {
            houses.add(currentHouse);
        }

        if (drawingRoad && currentRoad != null) {
            if (startType == 1){
                for(ShapeHouse house : houses){
                    if (house.contains(xPosition, yPosition)){
                        currentRoad.xEnd = (int)(house.getX()+25);
                        currentRoad.yEnd = (int)(house.getY()+25);
                        roads.add(currentRoad);
                    }
                }
            }
            if (startType == 2){
                for(ShapeTree tree : trees){
                    if (tree.contains(xPosition, yPosition)){
                        currentRoad.width = (int)(tree.getX()+25);
                        currentRoad.height = (int)(tree.getY()+25);
                        roads.add(currentRoad);
                    }
                }
            }

        }

        currentColorPos++;
        if (currentColorPos + 1 > colors.size()){
            currentColorPos = 0;
        }
        currentColor = colors.get(currentColorPos);
        repaint();
        currentTree = null;
        currentHouse = null;
        currentRoad = null;
        startType = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int dx = e.getX();
        int dy = e.getY();

        if (drawingRoad && currentRoad != null){
            currentRoad.xEnd = dx;
            currentRoad.yEnd = dy;

        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
