import java.lang.Math;


public class anglebetweenvectors {
    static String b="";


        public static void main(String[] args) {
            double[][] c = {{2,1},{-1,2}};
            System.out.println(anglebetweenvectorscalc(c));
        }
        private static String anglebetweenvectorscalc(double[][] a){


            double f = (((a[0][0] * a[1][0]) + (a[0][1] * a[1][1])) /  (Math.sqrt(((a[0][0]*a[0][0])+(a[0][1]*a[0][1]))*((a[1][0]*a[1][0])+(a[1][1]*a[1][1])))));
            double g = Math.toDegrees(Math.acos(f));

            if(g==180 || g==0){
                b="parallel";
            }
            else if (g==90){
                b = "orthoganal";
            }
            else {
                b = "not orthagonal or parallel";

            }
             return "The angle between the two vectors is" +g+" so these two vectors are " + b + " to each other";




        }


}
