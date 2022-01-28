 /**
 * Java 1. HomeWork 6
 * 
 * @author Alexey Krutikov
 * @version 28.01.2022
*/

class HomeWorkSix_v3 {
    public static void main(String[] args) {
        int dogSwimLimit = 10; // ограничение по плаванию для собак
        int dogRunLimit = 500; // ограничение по бегу для собак
        int catRunLimit = 200; // ограничение по бегу для котов
        int catSwimLimit = 0; // ограничение по плаванию для котов (не стал жестко указывать ноль)
        int runTarget = 250; // заданная дистанция для бега
        int swimTarget = 15; // заданная дистанция для плавания
        
        IAnimal [] animals = {
            new Cat( "Barsik", catSwimLimit, catRunLimit ), new Dog( "Bobik", dogSwimLimit, dogRunLimit ),
            new Cat( "Murka", catSwimLimit, catRunLimit ), new Dog( "Polkan", dogSwimLimit, dogRunLimit ),
            new Dog( "Mukhtar", dogSwimLimit, dogRunLimit)
        };
        for ( IAnimal animal : animals) {
            System.out.println( animal.run(runTarget) );
            System.out.println( animal.swim(swimTarget) );
        }

        System.out.println ("_________________________");
        System.out.println ("Total Cats created: " + animals[0].getCount()); // переменная статическая - нужно ссылаться на любого кота
        System.out.println ("Total Dogs created: " + animals[1].getCount()); // переменная статическая - нужно ссылаться на любую собаку
        System.out.println ("Total Animals created: " + ( animals[0].getCount() + animals[1].getCount() ));
    }
}

interface IAnimal {
    public String swim(int a);
    public String run(int b);
    public int getCount();
}

abstract class Animal implements IAnimal {
    protected String name;
    protected int limitSwim;
    protected int limitRun;

    Animal (String name, int limitSwim, int limitRun ) {
        this.name = name; // имя животного
        this.limitSwim = limitSwim; // ограничение по плаванию
        this.limitRun = limitRun; // ограничение по бегу
        //count ++; // увеличиваем счетчик при каждом вызове конструктора
    }
    
    public String run ( int runTarget ) {
        return (runTarget <= limitRun ? name + " has run " + runTarget + " meters" : name + " has run " + limitRun + " of " + runTarget + " meters ONLY");
    }
    
    //public int getCount() {
       // return count;
    //}
    
    public String swim ( int swimTarget ) {
        return (swimTarget <= limitSwim ? name + " has swum " + swimTarget + " meters" : name + " has swum " + limitSwim + " of " + swimTarget + " meters ONLY");
    }
}

class Dog extends Animal {
    private static int count; // счетчик созданных собак

    Dog (String name, int limitSwim, int limitRun ) {
        super( name, limitSwim, limitRun );
        count ++; // увеличиваем счетчик при каждом вызове конструктора
    }

    @Override
    public int getCount() {
        return count;
    }
}

class Cat extends Animal {
    private static int count; // счетчик созданных котов
    
    Cat (String name, int limitSwim, int limitRun ) {
        super( name, limitSwim, limitRun );
        count ++; // увеличиваем счетчик при каждом вызове конструктора
    }
    
    @Override
    public int getCount() {
        return count;
    }
    
    @Override
    public String swim( int swimTarget) {
        return name + " - Cats CAN'T swim";
    }
}
