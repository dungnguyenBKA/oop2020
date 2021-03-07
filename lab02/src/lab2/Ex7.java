package lab2;

import java.util.Random;

public class Ex7 {
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        addMatrices(generateMatrix(3,2), generateMatrix(3,2));
    }

    public static int[][] generateMatrix(int col, int row) {
        int[][] matrix = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = generateRandomIntIntRange(1,10);
            }
        }
        return matrix;
    }

    public static void addMatrices(int[][] mtr1, int[][] mtr2) {
        if(mtr1.length != mtr2.length || mtr1[0].length != mtr2[0].length) {
            System.out.println("Invalid matrices");
            return;
        }
        int[][] res = new int[mtr1.length][mtr1[0].length];
        for (int i = 0; i < mtr1.length; i++) {
            for (int j = 0; j < mtr1[0].length; j++) {
                res[i][j] = mtr1[i][j] + mtr2[i][j];
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
