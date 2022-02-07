package com.unique.pack;

import java.util.Scanner;

public class ArrayUtils {

    private static final String ERROR_01 = "Impossible to complete swap! Selected items are out of the matrix." +
            "\nNothing has changed!";
    private static final String ERROR_02 = "Cant complete swap due to the same target location! Nothing has changed.";
    private static final String ERROR_03 = "Impossible to correctly swap items due to the different length of places "
            + "they locate on!\nNothing has changed!";
    private static final String ASK_PERMISSION = "Do you want to force a swap? (Y/N) ";
    private static final String USER_YES_ANSWER = "Y";
    private static final String USER_NO_ANSWER = "N";
    private static final String PERMISSION_ERROR = "Unknown command! Do you want to force a swap? (Y/N) ";
    private static final String PERMISSION_RECEIVED = "Permission received. Selected items were swapped.";
    private static final String PERMISSION_DENIED = "Swap permission denied by user. Nothing has changed!";

    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints.length == 1) {
                    System.out.printf("[%3d]\n", ints[j]);
                } else if (j == 0) {
                    System.out.printf("[%3d,", ints[j]);
                } else if (j + 1 == ints.length) {
                    System.out.printf("%3d]\n", ints[j]);
                } else {
                    System.out.printf("%3d,", ints[j]);
                }
            }
        }
    }

    public static void swapColumns(int[][] matrix, int columA, int columB) {
        int columALength = 0;
        int columBLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == Math.min(columA, columB)) {
                    columALength++;
                }
                if (j == Math.max(columA, columB)) {
                    columBLength++;
                    break;
                }
            }
        }
        if (swapColumnsPossibility(matrix, columA, columB, columALength, columBLength)) {
            for (int i = 0; i < Math.min(columBLength, columALength); i++) {
                int temp = matrix[i][columA];
                matrix[i][columA] = matrix[i][columB];
                matrix[i][columB] = temp;
            }
        }
    }

    private static boolean swapColumnsPossibility
            (int[][] matrix, int columA, int columB, int columALength, int columBLength) {
        int maxRowLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (maxRowLength < matrix[i].length) {
                maxRowLength = matrix[i].length - 1;
            }
        }
        if (columA < 0 || columB < 0 || maxRowLength < columA || maxRowLength < columB) {
            System.out.println(ERROR_01);
            return false;
        } else if (columA == columB) {
            System.out.println(ERROR_02);
            return false;
        } else if (columALength != columBLength) {
            System.out.println(ERROR_03);
            return userColumnsSwapPermission();
        } else {
            return true;
        }
    }

    private static boolean userColumnsSwapPermission() {
        System.out.print(ASK_PERMISSION);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(USER_YES_ANSWER)) {
                System.out.println(PERMISSION_RECEIVED);
                return true;
            } else if (answer.equalsIgnoreCase(USER_NO_ANSWER)) {
                System.out.println(PERMISSION_DENIED);
                return false;
            } else {
                System.out.print(PERMISSION_ERROR);
            }
        }
    }

    public static void swapRows(int[][] matrix, int rowA, int rowB) {
        if (rowsSwapPossibility(matrix, rowA, rowB)) {
            int minRowLength = Math.min(matrix[rowA].length, matrix[rowB].length);
            for (int i = 0; i < minRowLength; i++) {
                int temp = matrix[rowA][i];
                matrix[rowA][i] = matrix[rowB][i];
                matrix[rowB][i] = temp;
            }
        }
    }

    private static boolean rowsSwapPossibility(int[][] matrix, int rowA, int rowB) {
        if (rowA < 0 || rowB < 0 || rowA > matrix.length - 1 || rowB > matrix.length - 1) {
            System.out.println(ERROR_01);
            return false;
        } else if (rowA == rowB) {
            System.out.println(ERROR_02);
            return false;
        } else if (matrix[rowA].length != matrix[rowB].length) {
            System.out.println(ERROR_03);
            return userRowsSwapPermission();
        } else {
            return true;
        }
    }

    private static boolean userRowsSwapPermission() {
        System.out.print(ASK_PERMISSION);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(USER_YES_ANSWER)) {
                System.out.println(PERMISSION_RECEIVED);
                return true;
            } else if (answer.equalsIgnoreCase(USER_NO_ANSWER)) {
                System.out.println(PERMISSION_DENIED);
                return false;
            } else {
                System.out.print(PERMISSION_ERROR);
            }
        }
    }

    public static void multiplication(int[][] matrix, int multiplier) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= multiplier;
            }
        }
    }


    public static int[] toArray(int[][] matrix) {
        int arrayLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            arrayLength += matrix[i].length;
        }
        int[] array = new int[arrayLength];
        int pointer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[pointer] = matrix[i][j];
                pointer++;
            }
        }
        return array;
    }

    public static int max(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}