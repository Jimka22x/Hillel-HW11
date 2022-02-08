package com.unique.pack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
//        1. Создать класс Person который описывает человека, с полями: имя, фамилия, возраст, вес, рост.
//        Создать один или несколько конструкторов которые гарантирует что у каждого есть имя и фамилия.
//        Создать список из 100 обьектов типа Person заполненных случайными данными
//        (Например создать массив на несколько имен и выбирать из него случайным образом).
//        Код который создает список Person и заполняет его данными разместить в другом классе, не в Person,
//        например в PersonFactory.
//        Обеспечить чтобы случайные данные (вес, рост, возраст)выглядели правдоподобно:
//        не было человека весом 3 кг и ростом 180 итд.
        PersonFactory factory = new PersonFactory();
        List<Person> personList = factory.generatePersonList(100);
        System.out.println(personList);
    }

    public static void task2() {

//     2*. Написать класс для работы с матрицами (2-мерными массивами), методы:
//         print(int[][] matrix) - печатает матрицу:
//         swapColumns(int[][] matrix, i, j) - меняет 2 столбца местами
//         swapRows(int[][] matrix, i, j) - меняет 2 рядка местами
//         mul(int[][] matrix, int value) - умножает матрицу на число
//         toArray(int[][] matrix) - превращает матрицу в массив.
//         Например если была матрица на 3x4 то вернуть массив из 12 элементов
//         max(int[][] matrix) - возвращает максимальный элемент матрицы

        System.out.println("Task 2*");
        int[][] matrix = chooseMatrix();
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** print(int[][] matrix) - печатает матрицу:");
        ArrayUtils.print(matrix);
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** swapColumns(int[][] matrix, i, j) - меняет 2 столбца местами (0 <-> 1):");
        ArrayUtils.swapColumns(matrix, 0, 1);
        ArrayUtils.print(matrix);
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** swapRows(int[][] matrix, i, j) - меняет 2 рядка местами (1 <-> 2):");
        ArrayUtils.swapRows(matrix, 1, 2);
        ArrayUtils.print(matrix);
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** mul(int[][] matrix, int value) - умножает матрицу на число (x10):");
        ArrayUtils.multiplication(matrix, 10);
        ArrayUtils.print(matrix);
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** toArray(int[][] matrix) - превращает матрицу в массив:");
        int[] array = ArrayUtils.toArray(matrix);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("** max(int[][] matrix) - возвращает максимальный элемент матрицы:");
        System.out.println("Максимальный элемент матрицы: " + ArrayUtils.max(matrix));
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static int[][] chooseMatrix() {
        System.out.print("What matrix do you want to mess around with? Symmetrical or custom? (S/C): ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("S")) {
                System.out.println("Symmetrical matrix was created.");
                return MatrixFactory.createMatrix(3, 5);
            } else if (answer.equalsIgnoreCase("C")) {
                System.out.println("Custom matrix was created.");
                return MatrixFactory.createCustomMatrix();
            } else {
                System.out.print("Unknown answer. Please repeat: ");
            }
        }
    }
}