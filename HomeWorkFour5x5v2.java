/**
 * Java 1. HomeWork 4 (ver.3x3)
 * 
 * @author Alexey Krutikov
 * @version 21.01.2022
*/

import java.util.Random;
import java.util.Scanner;

class HomeWorkFour5x5v2 {
    Random rand;
    Scanner sc;
    
    final int SIZE = 5;
    final int DOTS_TO_WIN = 4;
    final char DOT_EMPTY = '*';
    final char DOT_X = 'X'; 
    final char DOT_O ='O';
    char[][] map;
    
    public static void main(String[] args) {
        new HomeWorkFour5x5v2().game();
    }
    
    HomeWorkFour5x5v2() {
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
            // aiTurn_0(); // изначальный алгоритм
            aiTurn_1(); // продвинутый алгоритм
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
    
    boolean checkWin(char symb) { // Проверка выигрышной комбинации (условно матричный способ)
        for(int k = 0; k <= (SIZE - DOTS_TO_WIN); k++) {
            for(int l = 0; l <= (SIZE - DOTS_TO_WIN); l++) {
                int count_d1 = 0; // счетчик искомых символов в диагонали 1
                int count_d2 = 0; // счетчик искомых символов в диагонали 2
                for (int i = 0; i <  DOTS_TO_WIN; i++) {
                    if (map[i+k][i+l] == symb) count_d1 += 1;
                    if (map[i+k][DOTS_TO_WIN-(i+1)+l] == symb) count_d2 += 1;
                    int count_l = 0; // счетчик искомых символов в строке
                    int count_c = 0; // счетчик искомых символов в столбце
                    for (int j = 0; j < DOTS_TO_WIN; j++) {
                        if (map[i+k][j+l] == symb) count_l += 1;
                        if (map[j+k][i+l] == symb) count_c += 1;
                    }
                    if (count_l >= DOTS_TO_WIN) return true;
                    if (count_c >= DOTS_TO_WIN) return true;
                    if (count_d1 >= DOTS_TO_WIN) return true;
                    if (count_d2 >= DOTS_TO_WIN) return true;
                }
            }
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
    
    void aiTurn_0() { // Ход машины (исходный алгоритм)
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("The computer have made step into " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    
    void aiTurn_1() { // Ход машины (продвинутый алгоритм) 
        boolean smartStep = false; // признак наличия блокирующего хода
        for(int k = 0; k <= (SIZE - DOTS_TO_WIN); k++) { // вычисление комбинаций, когда человеку до победы 1 шаг
            for(int l = 0; l <= (SIZE - DOTS_TO_WIN); l++) {
                int x_d1 = -1; // переменные для хранения потенциального хода в диагоналях
                int x_d2 = -1;
                int y_d1 = -1;
                int y_d2 = -1;
                int count_d1 = 0; // счетчик ходов человека в диагонали 1
                int count_d2 = 0; // счетчик ходов человека в диагонали 2
                for (int i = 0; i <  DOTS_TO_WIN; i++) {            // аналогично проверке выигрышной комбинации,
                    if (map[i+k][i+l] == DOT_X) {                         // но ищем вариант с одним пустым полем (1 шаг человека до победы)
                        count_d1 += 1; 
                    } else if (map[i+k][i+l] == DOT_EMPTY) { // потенциальный ход машины (запоминаем координаты пустой ячейки)
                        x_d1 = i + k;
                        y_d1 = i + l;
                    }
                    if (map[i+k][DOTS_TO_WIN-(i+1)+l] == DOT_X) {
                        count_d2 += 1;
                    } else if (map[i+k][(DOTS_TO_WIN-(i+1)+l)] == DOT_EMPTY) {
                        x_d2 = i + k;
                        y_d2 = (DOTS_TO_WIN-(i+1)+l);
                    }
                    if (count_d1 == (DOTS_TO_WIN - 1) && x_d1 != -1 && !smartStep) { // Если до победы человеку 1 шаг - машинa занимает свободное  поле
                        map[x_d1][y_d1] = DOT_O;
                        System.out.println("The computer have made a SMART step into " + (x_d1 + 1) + " " + (y_d1 + 1));
                        smartStep = true;
                        break;
                    }
                    if (count_d2 == (DOTS_TO_WIN - 1) && x_d2 != -1 && !smartStep) {
                        map[x_d2][y_d2] = DOT_O;
                        System.out.println("The computer have made a SMART step into " + (x_d2+ 1) + " " + (y_d2 + 1));
                        smartStep = true;
                        break;
                    }
                    int count_l = 0; // счетчик ходов человека в строке
                    int count_c = 0; // счетчик ходов человека в столбце
                    int x_l = -1; // переменные для хранения потенциального хода в строках и столбцах
                    int x_c = -1;
                    int y_l = -1;
                    int y_c= -1;
                    for (int j = 0; j < DOTS_TO_WIN; j++) {
                        if (map[i+k][j+l] == DOT_X) {
                            count_l += 1;
                        } else if (map[i+k][j+l] == DOT_EMPTY) {
                        x_l = i + k;
                        y_l = j + l;
                        }
                        if (map[j+k][i+l] == DOT_X) {
                            count_c += 1;
                        } else if (map[j+k][i+l] == DOT_EMPTY) {
                        x_c = j + k;
                        y_c = i + l;
                        }
                    }
                    if (count_l == (DOTS_TO_WIN - 1) && x_l != -1 && !smartStep) {
                        map[x_l][y_l] = DOT_O;
                        System.out.println("The computer have made a SMART step into " + (x_l + 1) + " " + (y_l + 1));
                        smartStep = true;
                        break;
                    }
                    if (count_c == (DOTS_TO_WIN - 1) && x_c != -1 && !smartStep) {
                        map[x_c][y_c] = DOT_O;
                        System.out.println("The computer have made a SMART step into " + (x_c + 1) + " " + (y_c + 1));
                        smartStep = true;
                        break;
                    }
                }
            }
        }
        if (!smartStep) { // при отсутсвии блокирующего хода делаем рандомный
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("The computer have made a step into " + (x + 1) + " " + (y + 1));
            map[x][y] = DOT_O;
        }
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