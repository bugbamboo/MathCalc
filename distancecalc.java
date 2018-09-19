import java.lang.Math;
public class distancecalc {


    public static void main(String[] args) {
        double[][] c = {{0,0},{0,4}};
        System.out.println(distancecalc(c));
    }
    public static String distancecalc(double[][] a){
        double x = (Math.abs(a[1][0]-a[0][0]));
        double y = (Math.abs(a[1][1]-a[0][1]));
        double z = (Math.sqrt(x*x+y*y));


    return "Distance is " + z;



    }
}
