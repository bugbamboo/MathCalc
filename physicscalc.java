import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import java.util.Scanner;

class physicscalc extends JFrame
{
    private static Graphics gBuf = null;
    private static GraphPaperCanvas canvas = null;
    private static Image vm = null;
    private int x, y;
    private int w, h;

    public physicscalc( int x, int y )
    {
        if ( canvas == null )
        {
            setTitle("Projectile Trajectory Graph");
            setSize(625,645);
            setLocation(20,50);

            canvas = new GraphPaperCanvas(null);
            getContentPane().add(canvas);
            setVisible(true);

            vm = canvas.createImage(2200,1900);
            gBuf = vm.getGraphics();
            canvas.setVm(vm);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        this.x = x;
        this.y = y;
        w = 600;
        h = 600;

        drawBounds();
        gBuf.setColor( Color.BLUE );
    }

    public void drawBounds()
    {
        Color cur = gBuf.getColor();
        gBuf.setColor( Color.LIGHT_GRAY );
        for ( int d=0; d<w; d+=w/50 )
            gBuf.drawLine( x+d, y+0, x+d, y+h );
        for ( int d=0; d<h; d+=h/50 )
            gBuf.drawLine( x+0, y+d, x+h, y+d );

        gBuf.setColor( Color.BLACK );
        gBuf.drawRect( x, y, w+1, h+1 );
        gBuf.drawLine( x+w/2, y+0, x+w/2, y+h );
        gBuf.drawLine( x+0, y+h/2, x+w, y+h/2 );
        gBuf.setColor( cur );
        canvas.repaint();
    }
    public void setColor( Color c )
    {
        gBuf.setColor(c);
    }

    public void drawPoint( double px, double py )
    {
        if ( px > 50 || px < -50 || py > 50 || py < -50 )
            return;

        px *= w/50;
        py *= h/50;
        px += w/2 + 1;
        py = h/2 - py + 1;

        gBuf.drawLine( x+(int)px, y+(int)py, x+(int)px, y+(int)py );
        canvas.repaint();
    }
}
