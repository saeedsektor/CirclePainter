import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * The type Circle viewer.
 */
public class CircleViewer
{


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        final CircleComponent component = new CircleComponent();
        JFrame frame = new JFrame();


        class MousePressListener implements MouseListener, MouseMotionListener {
            int counter = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                // shoot a point on the canvas to a function in Circle component
                component.addCircle(e.getX(),e.getY());
                frame.repaint();
                counter++;
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                // draw a line from center to new x and y
                if(counter % 2 != 0){
                    component.changeRad(e.getX(), e.getY());
                    frame.repaint();
                }

            }
            @Override
            public void mouseDragged(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }


        }


        MousePressListener listener = new MousePressListener();
        frame.addMouseListener(listener);
        frame.addMouseMotionListener(listener);

        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 800;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Draw Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(component);

        frame.setVisible(true);
    }
}
