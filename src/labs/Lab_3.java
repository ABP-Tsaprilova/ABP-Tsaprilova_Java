package labs;


    interface Run {
        void printName();
        int getSpeed();
        double getWeight();
        int getPassengers();
        int getWheels();
    }

    // Завдання 2: Абстрактний клас Machine
    abstract class Machine implements Run {
        public static final int MAX_SPEED = 300;
        public static final int MIN_SPEED = 0;
        public static final int MIN_PASSENGERS = 1;
        public static final int MAX_PASSENGERS = 10;

        protected String name;
        protected int speed;

        public Machine(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        @Override
        public void printName() {
            System.out.println("Транспортний засіб: " + name);
        }
    }

    // Завдання 3: Суперкласи та нащадки (Велосипед)
    abstract class Bicycle extends Machine {
        public Bicycle(String name, int speed) {
            super(name, speed);
        }

        @Override
        public double getWeight() {
            return 10.0; // Приблизна вага велосипеда
        }

        @Override
        public int getPassengers() {
            return 1;
        }

        @Override
        public int getWheels() {
            return 2;
        }
    }

    class RegularBicycle extends Bicycle {
        public RegularBicycle(int speed) {
            super("Звичайний велосипед", speed);
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "Звичайний велосипед, швидкість: " + speed + " км/год";
        }
    }

    class ChildrenBicycle extends Bicycle {
        public ChildrenBicycle(int speed) {
            super("Дитячий велосипед", speed);
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "Дитячий велосипед, швидкість: " + speed + " км/год";
        }
    }

    // Завдання 4: Демонстраційний клас
    public class Lab_3 {
        public static void lab_3 () {
            RegularBicycle regularBicycle = new RegularBicycle(25);
            ChildrenBicycle childrenBicycle = new ChildrenBicycle(15);

            System.out.println(regularBicycle);
            regularBicycle.printName();
            System.out.println("Швидкість: " + regularBicycle.getSpeed() + " км/год");
            System.out.println("Вага: " + regularBicycle.getWeight() + " кг");
            System.out.println("Кількість пасажирів: " + regularBicycle.getPassengers());
            System.out.println("Кількість коліс: " + regularBicycle.getWheels());

            System.out.println("\n" + childrenBicycle);
            childrenBicycle.printName();
            System.out.println("Швидкість: " + childrenBicycle.getSpeed() + " км/год");
            System.out.println("Вага: " + childrenBicycle.getWeight() + " кг");
            System.out.println("Кількість пасажирів: " + childrenBicycle.getPassengers());
            System.out.println("Кількість коліс: " + childrenBicycle.getWheels());
        }
    }
