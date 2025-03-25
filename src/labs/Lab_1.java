package labs;
import java.util.Scanner;

public class Lab_1 {
    public static void lab_1() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Елементарні оператори (прямокутник)");
            System.out.println("2. Умовні оператори (лінійне рівняння)");
            System.out.println("3. Обчислення суми ");
            System.out.println("4. Масиви (мінімум різниці)");
            System.out.println("5. Методи (площа трикутників)");
            System.out.println("0. Вихід");
            System.out.print("Виберіть завдання: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rectangle(scanner);
                    break;
                case 2:
                    linearEquation(scanner);
                    break;
                case 3:
                    calculateSum(scanner);
                    break;
                case 4:
                    minDifference(scanner);
                    break;
                case 5:
                    findLargestTriangleArea(scanner);
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }


    public static void rectangle(Scanner scanner) {
        System.out.print("Введіть довжину сторони a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть довжину сторони b: ");
        double b = scanner.nextDouble();

        double perimeter = 2 * (a + b);
        double area = a * b;
        double diagonal = Math.sqrt(a * a + b * b);

        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
        System.out.println("Довжина діагоналі: " + diagonal);
    }


    public static void linearEquation(Scanner scanner) {
        System.out.print("Введіть коефіцієнт a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть коефіцієнт b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Безліч коренів.");
            } else {
                System.out.println("Коренів немає.");
            }
        } else {
            double root = -b / a;
            System.out.println("Корінь: " + root);
        }
    }


    public static void calculateSum(Scanner scanner) {
        System.out.print("Введіть натуральне число n: ");
        int n = scanner.nextInt();
        double sum = 0;

        for (int k = 1; k <= n; k++) {
            sum += Math.pow(-1, k) / (k * k * (k + 1));
        }

        System.out.println("Сума: " + sum);
    }


    public static void minDifference(Scanner scanner) {
        double[] array = new double[16];
        System.out.println("Введіть 16 дійсних чисел:");
        for (int i = 0; i < 16; i++) {
            array[i] = scanner.nextDouble();
        }

        double minDifference = Double.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            double difference = Math.abs(array[i] - array[i + 8]);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        System.out.println("Мінімальна різниця: " + minDifference);
    }


    public static void findLargestTriangleArea(Scanner input) {
            double[][] triangleCoordinates = new double[3][6];

            for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
                System.out.println("Введіть координати вершин трикутника " + (triangleIndex + 1) + " (x1 y1 x2 y2 x3 y3):");
                for (int coordinateIndex = 0; coordinateIndex < 6; coordinateIndex++) {
                    triangleCoordinates[triangleIndex][coordinateIndex] = input.nextDouble();
                }
            }

            double largestArea = 0;
            int largestTriangleIndex = -1;


            System.out.println("\nПлощі трикутників:");
            for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
                double currentArea = calculateArea(
                        triangleCoordinates[triangleIndex][0], triangleCoordinates[triangleIndex][1],
                        triangleCoordinates[triangleIndex][2], triangleCoordinates[triangleIndex][3],
                        triangleCoordinates[triangleIndex][4], triangleCoordinates[triangleIndex][5]
                );
                System.out.println("Трикутник " + (triangleIndex + 1) + ": " + currentArea);

                if (currentArea > largestArea) {
                    largestArea = currentArea;
                    largestTriangleIndex = triangleIndex + 1;
                }
            }

            System.out.println("\nТрикутник " + largestTriangleIndex + " має найбільшу площу: " + largestArea);
        }

        public static double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
            return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
        }
    }


