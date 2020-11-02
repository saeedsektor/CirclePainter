import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


/**
 * The Circle class describes a class defined by its centre and radius.
 */
public class Circle
{
    /**
     * The constant PI.
     */
    public static final double PI = 3.14;
    /**
     * The Centre.
     */
    public Point2D centre;
    private double radius;

    /**
     * Constructs a Circle.
     */
    public Circle()
    {
        centre = new Point2D();
        radius=1;

    }

    /**
     * Constructs a Circle and initialize
     *
     * @param x coordinate of the centre
     * @param y coordinate of the centre
     * @param r radius of the cirlce
     */
    public Circle(double x, double y, double r)
    {
        centre = new Point2D(x,y);
        radius = r;
    }

    /**
     * set the radius of the cirlce
     *
     * @param r radius of the circle
     */
    public void set(double r)
    {
        radius = r;
    }

    /**
     override toString() method of the class
     */
    public String toString()
    {
        return "["+ centre.toString() +", r= " +radius+"]";
    }

    /**
     * draw circle using Graphics2D g2
     *
     * @param g2 the g 2
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double c= new Ellipse2D.Double(centre.getX()-radius,centre.getY()-radius,2*radius,2*radius);
        g2.draw(c);
    }
}
