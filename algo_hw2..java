Pavel Gorulya (Java-37m)

//1) Реализовать алгоритм бинарного поиска,
// который находит данный key в данном отстортированном массиве
// public int binarySearch(int[] arr, int key)
//        Описание алгоритма из лекции
//        binary search
//        problem: find key in sorted array
//        returns index of key
//        arr = [1,4,7,9,12,15], key = 9
//        take element from the middle 7
//        compare to key 7 == 9 false
//        compare to key 7 < 9
//        if middle element less than key repeat procedure for right half of array
//        if middle element more  than key repeat procedure for left half of arr
package org.example;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,7,9,12,15};
        int key = 9;
        int left = 0;
        int right = arr.length - 1;
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Key = " + key);

        int index = binarySearch(arr, left, right, key);

        System.out.println("Index = " + index);
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (left > right) return -1;
        int middle = (left + right)/2;
        if (arr[middle] == key) return middle;
        if (arr[middle] < key)
            return binarySearch(arr, middle + 1, right, key);
        else return binarySearch(arr, left, middle - 1, key);
    }
}


//2)Задача заключается в следующем.
// Имеется три стержня — левый, средний и правый.
// На левом стержне находятся n дисков, диаметры которых различны.
// Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
// Требуется перенести диски с левого стержня на правый,
// используя средний стержень как вспомогательный.
//        Головоломка имеет следующие два правила:
//      1. Вы не можете поместить больший диск на меньший диск.
//      2. За один раз можно перемещать только один диск.
//      Задача  - придумать и описать алгоритм. Можно текстом, можно псевдокодом.

//      Задача со звёздочкой
//      Нужно реализовать  метод moveRing(firstPole, secondPole, thirdPole, numOfRings) .
//      Параметры firstPole, secondPole, thirdPole - стеки, которые представляют  стержни.
//      Числа внутри - диски, диаметр диска - число
//      Например, стек firstPole = [3,2,1] содержит три диска диаметром 3 - в самом внизу, 2 - в середине, 1 - на самом верху.
//      numOfRings - количество колец, которые нужно передвинуть.
package org.example;

import java.util.Stack;
public class Hanoi {
    private final int numOfRings;
    public Stack<Integer> firstPole = new Stack<>();
    public Stack<Integer> secondPole = new Stack<>();
    public Stack<Integer> thirdPole = new Stack<>();

    public Hanoi(int discs) {
        numOfRings = discs;
        for (int i = discs; i > 0; i--) {
            firstPole.push(i);
        }
    }

    private void moveRing(Stack<Integer> begin, Stack<Integer> end, Stack<Integer> temp, int n) {
        if (n == 1) {
            end.push( begin.pop() );

        } else {
            moveRing(begin, temp, end, n - 1);
            moveRing(begin, end, temp, 1);
            moveRing(temp, end, begin, n - 1);
        }
    }

    public void resolve() {
        moveRing(firstPole, thirdPole, secondPole, numOfRings);
    }

    public void printPosition(Hanoi hanoi) {
        System.out.println("firstPole " + hanoi.firstPole);
        System.out.println("secondPole" + hanoi.secondPole);
        System.out.println("thirdPole " + hanoi.thirdPole);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(3);

        System.out.println("Start position:");
        hanoi.printPosition(hanoi);

        hanoi.resolve();

        System.out.println();
        System.out.println("End position:");
        hanoi.printPosition(hanoi);

    }

}
