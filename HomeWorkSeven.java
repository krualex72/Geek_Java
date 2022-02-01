 /**
 * Java 1. HomeWork 7
 * 
 * @author Alexey Krutikov
 * @version 01.02.2022
*/

public class HomeWorkSeven {
    public static void main(String[] args) {
        Cat [] cats = { // Task #4
            new Cat("Barsik", 5, false), new Cat("Murka", 7, false), new Cat("Shnurok", 4, false), new Cat("Princes", 5, false), new Cat("Pushok", 6, false)
        };
        Plate plate = new Plate(20);
        System.out.print ("New plate: ");
        System.out.println(plate.info()  + " food units are at the plate");
        System.out.println ("------------------------------------------------------");
        for (Cat cat : cats) { // All the cats are hungry
            cat.eat(plate);
            System.out.println (cat);
            System.out.println(plate.info()  + " food units are at the plate");
        }
        plate.addFood(15); // Adding 15 units to the plate
        System.out.println ("------------------------------------------------------");
        System.out.print ("Refreshed plate: ");
        System.out.println(plate.info()  + " food units are at the plate (Some cats are feeded)");
        System.out.println ("------------------------------------------------------");
        for (Cat cat : cats) { // Some cats are feeded
            cat.eat(plate);
            System.out.println (cat);
            System.out.println(plate.info()  + " food units are at the plate");
        }
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food = (food >= n) ? food - n : food; // Task #1
    }

    public void addFood(int n) {
    food = (n >0) ? food + n : food; // Task #5 - We can add the food ONLY 
    }

    public int info() {
        return food;
        //System.out.println(food + " food units at the plate");
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean isBellyfull; //Task #2

    public Cat(String name, int appetite, boolean bellyfull) {
        this.name = name;
        this.appetite = appetite;
        this.isBellyfull = isBellyfull;
    }

    public void eat(Plate plate) { // The cat eats if it's hangry & enough food at the plate
        if (isBellyfull == false) {
            isBellyfull = appetite > plate.info() ? false : true;  // Task #3
            plate.decreaseFood(appetite);
        }
    }
    
    @Override
    public String toString () {
        return ("Cat Name: " + name + "   Appetite: " + appetite + "   Bellyfool: " + isBellyfull);
    }
}
