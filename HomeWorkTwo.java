/**
 * Java 1. HomeWork 2
 * 
 * @author Alexey Krutikov
 * @version 14.01.2022 - 17.01.2022 (last correction)
*/
class HomeWorkTwo {
    public static void main(String[] args) {
        System.out.println("--- Section 1 ---");
        System.out.println(intSumm10to20(5, -15));
        System.out.println("\n--- Section 2 ---");
        positiveOrNegative(0);
        System.out.println("\n--- Section 3 ---");
        System.out.println(booleanPositiveOrNegative(-10));
        System.out.println("\n--- Section 4 ---");
        printNStrings("So cool", 3);
        System.out.println("\n--- Section 5* ");
        System.out.println("This year is leap: " + leapYear(2100));
    }

    static boolean intSumm10to20(int a, int b) {
        // сумма лежит в пределах от 10 до 20 (включительно)? Если да – вернуть true, в противном случае – false
        return ((a + b) > 9 && (a + b) <21);
    }
    
    static void positiveOrNegative(int c) {
        // напечатаем в консоль, положительное ли число передали или отрицательное
        System.out.println (c > -1 ? "Positive" : "Negative");
    }
    
    static boolean booleanPositiveOrNegative(int c) {
        // вернуть true, если число отрицательное, и вернуть false если положительное
        return c > -1 ;
    }
    
    static void printNStrings(String text, int n) {
        // отпечатать в консоль указанную строку, указанное количество раз;
        for (int i = 0; i < n; i++) {
            System.out.println (text);
        }
    }
    
    static boolean leapYear(int year) {
        boolean leap = false;
        float div4 = year / 4f; // делим год на 4
        int ceiling4 = (int)div4; //целая часть
        float floor4 = div4 - ceiling4; //дробная часть
        float div100 = year / 100f; // делим год на 100
        int ceiling100 = (int)div100; //целая часть
        float floor100 = div100 - ceiling100; //дробная часть
        float div400 = year / 400f; // делим год на 400
        int ceiling400 = (int)div400; //целая часть
        float floor400 = div400 - ceiling400; //дробная часть
        if (floor4 == 0 && floor100 != 0 ) { // является ли год четвёртым и не сотым?
            leap =true;
        } else if (floor100 == 0 && floor400 == 0) { // является ли год каждым сотым и четырехсотым?
            leap =true;
        }
        return leap;
    }
}