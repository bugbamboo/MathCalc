//Import Statements for Math
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;


public class physicscalc {

//Variables
        static double dist = 0;//Horizontal distance travelled
        static double time = 0;//Time in air
        static double rad = 0;//Launch angle in radians
        static double apog = 0;//Apogee height
        static double tapog = 0;//Time to apogee
        static double dslide=0;//Sliding distance
        static double kenergy =0;//Kinetic energy

        public static void main(String[] args) {//Function call

            System.out.println(projectileCalc(10f,45f,10f,0.5f,10f));//Function with parameters
        }
        //Fuction Itself(Where the magic happens)
        public static String projectileCalc(Float initialVelocity,Float launchAngle, Float startHeight, Float coefFriction, Float mass){
            rad=launchAngle*Math.PI/180;//Converts degrees to radians
            time= ((-initialVelocity*sin(rad)-sqrt(((initialVelocity*sin(rad))*(initialVelocity*sin(rad)))+(4*4.9*startHeight)))/(-9.80665f));//Time in air
            dist=time*(initialVelocity*cos(rad));//Horizontal Distance Travelled
            apog=((initialVelocity*sin(rad)*initialVelocity*sin(rad))/(9.80665*2))+startHeight;//Apogee height
            tapog=(initialVelocity*sin(rad))/9.80665;//Time to apogee
            dslide = (initialVelocity*cos(rad)*initialVelocity*cos(rad))/(coefFriction*2*9.80665);// Sliding DIstance
            kenergy=initialVelocity*initialVelocity*mass;//Kinetic energy
//Return Statement
            return "This projectile has a kinetic energy of " + kenergy+" Joules It will land "+dist+" meters from the starting point and will slide for " +dslide+" meters after hitting the ground for a total of " +(dslide+dist)+" meters travelled horizontally. It will be in the air for "+time+" seconds. Its maximum height is "+apog+" meters and it will take "+tapog+" seconds to reach that maximum.";

        }

}
