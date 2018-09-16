public class slopecalc {
    static double b=0;

    public static void main(String[] args) {
double[][] c = {{0,0},{0,0}};
        System.out.println(slopecalc1(c));
    }
    public static String slopecalc1(double[][] a){
        double m = (a[1][1]-a[0][1])/(a[1][0]-a[0][0]);
         b = a[0][1]- (a[0][0]*m);

      return "y = "+ m + "x + " + b;

    }
}
