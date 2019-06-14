import java.util.Arrays;

public class jk {


    public static void main(String[] args) {

        int value = 5;

        int arr [] = {1,3,3,4,10,6,5,1,9,10};
        int ar2 []= new int[arr.length];
        int ar3 []= new int[arr.length];
        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++) {

            if(value>arr[i]) {

                ar2[i] = arr[i];
            }
        }
        for(int i = 0; i<ar2.length; i++) {
            if (ar2[i] !=0) {

                if (((value / ar2[i]) % 1) == 0) {

                    ar3[i] = ar2[i];
                }
            }
        }

        System.out.println(Arrays.toString(ar3));
    }
}



