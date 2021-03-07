package lab2;

public class Ex4 {
    public static void main(String[] args) {
        printTriangleStar(5);
    }

    public static void printTriangleStar(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n+1; j++) {
                if( j >= n-i &&  j <= n+i){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
