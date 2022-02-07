package com.unique.pack;

import java.util.Random;

public class MatrixFactory {

    private static final Random RANDOM = new Random();

    public static int[][] createMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = RANDOM.nextInt(101);
            }
        }
        return matrix;
    }

    public static int[][] createCustomMatrix() {
        int[][] matrix = new int[5][];
        matrix[4] = new int[1];
        matrix[3] = new int[3];
        matrix[2] = new int[3];
        matrix[1] = new int[4];
        matrix[0] = new int[5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = RANDOM.nextInt(101);
            }
        }
        return matrix;
    }
}
