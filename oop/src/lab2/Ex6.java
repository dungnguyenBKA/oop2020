package lab2;

import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        sortArray(new int[]{10,4,3,5});
    }

    public static void sortArray(int[] arr){
        if(arr != null && arr.length > 0) {
            Arrays.sort(arr);
            System.out.println("Array after sorted: " + Arrays.toString(arr));
            int sum = 0;
            for (int ele : arr) {
                sum += ele;
            }
            System.out.println("Sum: "+ sum + ", avg: "+ (float)sum/arr.length);
        } else  {
            System.out.println("Invalid array");
        }
    }
}
