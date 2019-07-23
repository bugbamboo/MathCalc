import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class NumberReverser {
    private static int input = 0;
    public static void main( String[] args )

    {

        Scanner in = new Scanner(System.in);

        try {

            System.out.println("Please Enter the integer you want to reverse");

            input = in.nextInt();



        }catch (java.util.InputMismatchException e){

            System.out.println( "Please only Enter Integers");

            System.exit(0);


    }
        System.out.println(reverse(input));
    }
    private static  int reverse(int x){
        int num1 = abs(x);
        int num2=num1;
        int count=0;
        int n =0;
        int y = 0;

        int digit = 0;
        for(; num1 >0; num1/=10, ++digit) {
        }
        int digit2=digit;

        int[] digits=new int[digit];
        for(; digit >0; --digit,++n) {


            for (; num2 >= Math.pow(10,digit-1);num2-= Math.pow(10,digit-1), ++count) {
            }
            digits[n]=count;
            count = 0;
        }
        for(;digit2>y;y++){
            digits[y]*=Math.pow(10,y);
        }

        double reversed = 0;
        for (int value : digits) {
            reversed += value;


        }
        if(x<0){
            reversed= reversed*-1;
        }
       if (reversed>2147483647 ||reversed<-2147483647){
            return 0;
        }
        int g = (int)reversed;


        return g;
    }
