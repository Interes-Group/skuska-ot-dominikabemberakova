package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShapeHouse extends Rectangle {

    private Color color;

    public ShapeHouse(int x, int y, int width, int height, Color c){
        super (x, y, width, height);
        this.color = c;
    }

    public void drawShape(Graphics g) {
        g.setColor(color);

        g.fillRect((this.x)+(this.width/4), (this.y)+(this.width/2), this.width/2, this.height/2);
        int[] xPoints = new int[] {this.x+12, this.x+37, this.x+25};
        int[] yPoints = new int[] {this.y+25, this.y+25, this.y};
        g.fillPolygon(xPoints, yPoints, 3);

    }

}
