/**
 * Java 1. HomeWork 4 (ver.3x3)
 * 
 * @author Alexey Krutikov
 * @version 21.01.2022
*/

import java.util.Random;
import java.util.Scanner;

class HomeWorkFour3x3v2 {
    Random rand;
    Scanner sc;
    
    final int SIZE = 3;
    final int DOTS_TO_WIN = 3;
    final char DOT_EMPTY = '*';
    final char DOT_X = 'X'; 
    final char DOT_O ='O';
    char[][] map;
    
    public static void main(String[] args) {
        new HomeWorkFour3x3v2().game();
    }
    
    HomeWorkFour3x3v2() {
        sc = new Scanner(System.in);
        rand = new Random();
    }
    
    void game() {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("You WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("DROW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Artificial Intelligence WON! :o)");
                break;
            }
            if (isMapFull()) {
                System.out.println("DROW!");
                break;
            }
        }
        System.out.println("The Game is Over");
    }
    
    boolean checkWin(char symb) { // Проверка выигрышной комбинации
        int count_d1 = 0; // счетчик искомых символов в диагонали 1
        int count_d2 = 0; // счетчик искомых символов в диагонали 2
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) count_d1 += 1;
            if (map[i][SIZE-(i+1)] == symb) count_d2 += 1;
            int count_l = 0; // счетчик искомых символов в строке
            int count_c = 0; // счетчик искомых символов в столбце
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) count_l += 1;
                if (map[j][i] == symb) count_c += 1;
            }
            if (count_l >= DOTS_TO_WIN) return true;
            if (count_c >= DOTS_TO_WIN) return true;
            if (count_d1 >= DOTS_TO_WIN) return true;
            if (count_d2 >= DOTS_TO_WIN) return true;
        }
        return false;
    }
    
    boolean isMapFull() { // Проверка отсутсвия возможности хода (заполеннное поле)
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    
    void aiTurn() { // Ход машины
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("The computer have made a step into " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }
    
    void humanTurn() { // Ход человека
        int x, y;
        do {
            System.out.print("Make your step (format X Y): ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }
    boolean isCellValid(int x, int y) { // проверка, что ячейка пуста
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }
    void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    void printMap() { // печать в консоль игрового поля
        System.out.println();
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

