import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import java.util.Scanner;

class GraphPaperCanvas extends Canvas
{
    private Image vm;

    public GraphPaperCanvas( Image vm )
    {
        this.vm = vm;
        setBackground( Color.white );
    }

    public void setVm( Image vm )
    {
        this.vm = vm;
    }

    public void paint( Graphics g )
    {
        g.drawImage(vm,0,0,this);
    }

    public void update(Graphics g) { paint(g); }	// don't clear screen on repaint

}
