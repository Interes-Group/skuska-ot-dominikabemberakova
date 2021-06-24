package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShapeRoad extends Rectangle {

    private Color color;
    int xEnd;
    int yEnd;

    public ShapeRoad (int x, int y, int w, int h, Color c){
        super(x, y, w, h);
        xEnd = w;
        yEnd = h;
        this.color = c;
    }

    public void drawShape(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(this.x, this.y, this.xEnd, this.yEnd);
    }

}