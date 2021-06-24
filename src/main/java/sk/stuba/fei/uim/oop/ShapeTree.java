package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShapeTree extends Rectangle {

    private Color color;

    public ShapeTree(int x, int y, int width, int height, Color c){
        super (x, y, width, height);
        this.color = c;
    }

    public void drawShape(Graphics g) {
        g.setColor(color);

        g.fillOval(this.x,this.y,this.width,2*this.height/3);
        g.fillRect(this.x+this.width/3,this.y+this.height/2,width/3,height/2);

    }

}
