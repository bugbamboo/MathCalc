import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import java.util.Scanner;

class GraphingParabolas
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);





        double initialVelocity = 0;
        double launchAngle =0;
        double initialHeight=0;
        double frictionCoefficient=0;
        double weight=0;

        try {
            System.out.println("Please Enter Projectile Initial Velocity in Meters per Second.");
            initialVelocity = in.nextDouble();

        }catch (java.util.InputMismatchException e){
            System.out.println( "Please only Enter Positive Numbers for the Initial Velocity.");
            System.exit(0);
        }
        if (initialVelocity<= 0){
            System.out.println( "Please only Enter Positive Numbers for the Initial Velocity.");
            System.exit(0);
        }
        try {
            System.out.println("Please Enter Projectile Launch Angle in Degrees.");
            launchAngle = in.nextDouble();

        }catch (java.util.InputMismatchException e){
            System.out.println( "Please only Enter Positive Numbers Between 0 and 90 for the Launch Angle.");
            System.exit(0);
        }
        if (launchAngle<= 0||launchAngle>90){
            System.out.println( "Please only Enter Positive Numbers Between 0 and 90 for the Launch Angle.");
            System.exit(0);
        }
        try {
            System.out.println("Please Enter the Initial Height of the Projectile in Meters.");
            initialHeight = in.nextDouble();

        }catch (java.util.InputMismatchException e){
            System.out.println( "Please only Enter Positive Numbers for the Initial Height.");
            System.exit(0);
        }
        if (initialHeight<= 0){
            System.out.println( "Please only Enter Positive Numbers for the Initial Height.");
            System.exit(0);
        }
        try {
            System.out.println("Please Enter the Frictional Coefficient of the Projectile, a positive value usually between 0 and 1.");
            frictionCoefficient = in.nextDouble();

        }catch (java.util.InputMismatchException e){
            System.out.println( "Please only Enter Positive Numbers for the Frictional Coefficient.");
            System.exit(0);
        }
        if (frictionCoefficient<= 0){
            System.out.println( "Please only Enter Positive Numbers for the Frictional Coefficient.");
            System.exit(0);
        }
        try {
            System.out.println("Please Enter the Weight of the Projectile, in Kilograms");
            weight = in.nextDouble();

        }catch (java.util.InputMismatchException e){
            System.out.println( "Please only Enter Positive Numbers for the Weight.");
            System.exit(0);
        }
        if (weight<= 0){
            System.out.println( "Please only Enter Positive Numbers for the Weight.");
            System.exit(0);
        }













System.out.print(projectileCalc(initialVelocity,launchAngle,initialHeight,frictionCoefficient,weight));




    }






    //Variables
    static double dist = 0;//Horizontal distance travelled
    static double time = 0;//Time in air
    static double rad = 0;//Launch angle in radians
    static double apog = 0;//Apogee height
    static double tapog = 0;//Time to apogee
    static double fapog = 0;//Time from apogee to contact with ground
    static double dslide=0;//Sliding distance
    static double kenergy =0;//Kinetic energy
    static double vx=0;
    static double vymax=0;
    static double vmax=0;
    //Fuction Itself(Where the magic happens)
    public static String projectileCalc(double initialVelocity,double launchAngle, double startHeight, double coefFriction, double mass){
        rad=launchAngle*Math.PI/180;//Converts degrees to radians
        time= ((-initialVelocity*sin(rad)-sqrt(((initialVelocity*sin(rad))*(initialVelocity*sin(rad)))+(4*4.9*startHeight)))/(-9.80665f));//Time in air
        dist=time*(initialVelocity*cos(rad));//Horizontal Distance Travelled
        apog=((initialVelocity*sin(rad)*initialVelocity*sin(rad))/(9.80665*2))+startHeight;//Apogee height
        tapog=(initialVelocity*sin(rad))/9.80665;//Time to apogee
        dslide = (initialVelocity*cos(rad)*initialVelocity*cos(rad))/(coefFriction*2*9.80665);// Sliding Distance
        kenergy=initialVelocity*initialVelocity*mass;//Kinetic energy
        fapog = time-tapog;//Time from apogee to contact with ground
        vx =initialVelocity*cos(rad);
        vymax= -(initialVelocity*sin(rad)-9.80665*time);
        vmax=sqrt(vx*vx+vymax*vymax);
        double sin,cos=0;
        double s = 0;
        if (initialVelocity>750)
        {
            s=10;
        }else{
            s=0.01;
        }


        sin = sin(launchAngle*Math.PI/180);
        cos = cos(launchAngle*Math.PI/180);
        double y=0;
        double a, b, c,h;
        physicscalc gp1 = new physicscalc(10,10);
        for ( double x = 0; x<=1000000000&y>=0; x+=s)//Graphing function
        {

            if (dist>10000000||apog >10000000){
               System.out.println("input too large to graph");
               h=0;
            }else if (dist>1000000||apog >1000000){
                h=0.000005;
            }else if (dist>100000||apog >100000){
                h=0.00005;
            }else if (dist>10000||apog >10000){
                h=0.0005;
            }else if (dist>1000||apog >1000){
                h=0.01;
            }else if (dist>100||apog >100){
                h=0.1;
            }else if (dist>50||apog>50){
                h=0.25;
            }else if (dist>25||apog>25){
                h=0.5;
            }else{
                h=1;
            }

            a = -9.80665/(sin*sin*initialVelocity*initialVelocity);
            b = sin/cos; c = startHeight;
            y = (a*Math.pow(x,2)+b*x + c);
            gp1.drawPoint(x*h*2,y*h);
        }
//Return Statement
        return "\n"+"\n"+"This projectile has a kinetic energy of " + kenergy+" Joules, enough to power an average American home for "+kenergy/5161+" seconds."+"\n"+"This projectile will land "+dist+" meters from the starting point and will slide for " +dslide+" meters after hitting the ground."+"\n"+ "This projectile will travel a total of " +(dslide+dist)+" meters travelled horizontally."+"\n"+ "This projectile will be in the air for "+time+" seconds."+"\n"+"The maximum height of this projectile is "+apog+" meters."+"\n"+"This projectile will take "+tapog+" seconds to reach that maximum and will fall for "+fapog+" seconds after reaching that apogee." +"\n"+"This projectile has a maximum velocity of "+vmax+" meters per second."+"\n"+"\n";

    }
}
