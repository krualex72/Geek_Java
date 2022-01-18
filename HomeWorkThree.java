/**
 * Java 1. HomeWork 3
 * 
 * @author Alexey Krutikov
 * @version 18.01.2022
*/
import java.util.Arrays;
import java.util.Scanner;

class HomeWorkThree {
    public static void main(String[] args) {
        System.out.println("--- Section 1 ---");
        invertArray();
        System.out.println("\n--- Section 2 ---");
        fillArray();
        System.out.println("\n--- Section 3 ---");
        doubleArrayValue();
        System.out.println("\n--- Section 4 ---");
        fillDiagonal();
        System.out.println("\n--- Section 5 ---");
        System.out.println(Arrays.toString(initialArray(4, 589)));
        System.out.println("\n--- Section 6* ---");
        minMaxArrayElements();
        System.out.println("\n--- Section 7** ---");
        int[] balanceArr1 = { 2, 3, 2, 1, 2, 2, 10, 2 };
        System.out.println( "First Array Check:" + checkBalance(balanceArr1));
        int[] balanceArr2 = { 2, 1, 2, 1, 2, 2, 10, 2 };
        System.out.println( "Second Array Check:" + checkBalance(balanceArr2));
        System.out.println("\n--- Section 8*** ---");
        int[] baseArr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        moveArrayData(baseArr3);
    }
    
    // Task 1
    static void invertArray() {
        int[] binary = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        System.out.println("Original array   " + Arrays.toString(binary)); // В задании не указано, но сделал для проверки  работы
        for (int i = 0; i < binary.length; i++) {
            binary[i] = binary[i] == 1 ? 0 : 1;
        }
        System.out.println("Inverted array " + Arrays.toString(binary));
   }
   
    // Task 2
    static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println("Filled array " + Arrays.toString(arr)); // В задании не указано, но сделал для проверки  работы
   }
   
    // Task 3
    static void doubleArrayValue() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Original array   " + Arrays.toString(arr)); // В задании не указано, но сделал для проверки  работы
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
        System.out.println("Modified array " + Arrays.toString(arr));
   }
   
    // Task 4
    static void fillDiagonal() { 
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            arr[i] [i] = 1;
            arr[i] [6-i] = 1;
        }
        for (int i = 0; i < 7; i++) { // В задании не указано, но сделал  вывод массива для проверки  работы
            for (int j = 0; j < 7; j++) {
                System.out.print(arr[i][j] +"  ");
            }
            System.out.println();
        }
   }

    // Task 5
    static int[] initialArray(int len , int initialValue) {
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
    
    // Task 6*
    static void minMaxArrayElements() { 
        int[] array = { 1, 12, 39, 155, 104, -7, 15, 91, 14, 55, 19, 38, 85 };
        int maxElement = 0;
        int maxElementValue = array[0];
        int minElement = 0;
        int minElementValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if ( maxElementValue < array[i] ) {
                maxElement = i;
                maxElementValue = array[i];
            }
            if ( minElementValue > array[i] ) {
                minElement = i;
                minElementValue = array[i];
            }
        }
        System.out.println("Max Element No " + maxElement + " with Value " + maxElementValue);
        System.out.println("Min  Element No " + minElement + " with Value " + minElementValue);
    }
    
    // Task 7**
    static boolean checkBalance(int arr[]) {
        boolean balance = false;
        int summLeft ;
        int summRight;
        for(int i = 0; i < (arr.length-1); i++) { // Шагаем по массиву слева направо
            summLeft = 0;
            summRight = 0;
            for(int j = 0; j <= i; j++) {
                summLeft = summLeft +arr[j]; // Вычисляем сумму левой части
            }
            for(int k = i + 1; k <arr.length; k++) {
                summRight = summRight +arr[k]; // Вычисляем сумму правой части
            }
            if (summLeft == summRight) {
                balance = true;
                break; // Прерываем выполнение при первом совпадении
            }
        }
        return balance;
    }
    
    // Task 8***
    static void moveArrayData(int arr[]) {
        System.out.println("Original array   " + Arrays.toString(arr));
        int dim = arr.length; // определяем размерность массива
        int hold; // переменная для хранения 
        System.out.println ("If you want to move the Array Data to the left use '-' (minus)! ");
        Scanner sc = new Scanner(System.in);
        System.out.print ("How many steps do you want to do? :");
        int steps = sc.nextInt(); // запрашиваем количество смещений
        sc.close();
        if (steps > 0 ) {
            for (int st = 0; st < steps; st++) { // каждый цикл - одно смещение вправо
                hold = arr[dim-1];
                for (int i = dim - 2; i >= 0; i-- ) {
                    arr[i+1] = arr[i];
                }
                arr[0] = hold;
            }
        } else if (steps < 0) {
            for (int st = 0; st > steps; st-- ){ // каждый цикл - одно смещение влево
                hold = arr[0];
                for (int i=0; i < dim - 1; i++) {
                    arr[i] = arr[i+1];
                }
                arr[dim-1] = hold;
            }
        } else {
            System.out.println("Nothing to do!!!  "); // если 0 - не делаем ничего
        }
        System.out.println("Moved array    " + Arrays.toString(arr));
    }
}
