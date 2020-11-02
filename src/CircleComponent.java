import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * A component that draws the circles.
 */
public class CircleComponent extends JComponent
{
    /**
     * The Circles.
     */
    ArrayList<Circle> circles;
    private int circleCounter;
    private Line2D newLine;

    /**
     * Instantiates a new Circle component.
     */
    public CircleComponent()
    {
        circles = new ArrayList<>();
        circleCounter = 0;

    }

    /**
     * Add circle.
     *
     * @param x the x
     * @param y the y
     */
    public void addCircle(double x, double y){
        circles.add(new Circle(x,y,0));
        this.newLine = new Line2D.Double(0,0,0,0);
        circleCounter++;
    }

    /**
     * Change rad.
     *
     * @param x the x
     * @param y the y
     */
    public void changeRad(double x, double y){
        double cx = circles.get(circleCounter-1).centre.getX();
        double cy = circles.get(circleCounter-1).centre.getY();
        this.newLine = new Line2D.Double(cx, cy, x, y);
        circles.get(circleCounter-1).set(calculateRad(newLine));
    }


    /**
     * Calculate radius double.
     *
     * @param line the line
     * @return the double
     */
    public double calculateRad(Line2D line){
        double x = line.getX1() - line.getX2();
        double y = line.getY1() - line.getY2();
        return Math.sqrt(x * x + y * y);
    }


    /**
     * Draws the circles
     */
    public void paintComponent(Graphics g)
    {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{6}, 0);
        BasicStroke noDash = new BasicStroke(2);

        // draw circles
        for(Circle ci: circles){
            g2.setColor(Color.red);
            g2.setStroke(dashed);
            g2.draw(newLine);
            repaint();
            g2.setColor(Color.blue);
            g2.setStroke(noDash);
            ci.draw(g2);
        }

    }

}
