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
                    handleRectangle(scanner);
                    break;
                case 2:
                    handleLinearEquation(scanner);
                    break;
                case 3:
                    handleCalculateSum(scanner);
                    break;
                case 4:
                    handleMinDifference(scanner);
                    break;
                case 5:
                    handleFindLargestTriangleArea(scanner);
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void handleRectangle(Scanner scanner) {
        System.out.print("Введіть довжину сторони a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть довжину сторони b: ");
        double b = scanner.nextDouble();

        double perimeter = rectanglePerimeter(a, b);
        double area = rectangleArea(a, b);
        double diagonal = rectangleDiagonal(a, b);

        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
        System.out.println("Довжина діагоналі: " + diagonal);
    }

    public static double rectangleArea(double a, double b) {
        return a * b;
    }

    public static double rectanglePerimeter(double a, double b) {
        return 2 * (a + b);
    }

    public static double rectangleDiagonal(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void handleLinearEquation(Scanner scanner) {
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
            double root = linearEquationRoot(a, b);
            System.out.println("Корінь: " + root);
        }
    }

    public static double linearEquationRoot(double a, double b) {
        if (a == 0) {
            throw new IllegalArgumentException("Коефіцієнт 'a' не може бути нулем для єдиного кореня.");
        }
        return -b / a;
    }

    public static boolean linearEquationNoRootCase(double a, double b) {
        return a == 0 && b != 0;
    }

    public static boolean linearEquationInfiniteRootsCase(double a, double b) {
        return a == 0 && b == 0;
    }

    public static void handleCalculateSum(Scanner scanner) {
        System.out.print("Введіть натуральне число n: ");
        int n = scanner.nextInt();
        double sum = calculateSum(n);
        System.out.println("Сума: " + sum);
    }

    public static double calculateSum(int n) {
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            sum += Math.pow(-1, k) / (k * k * (k + 1));
        }
        return sum;
    }

    public static void handleMinDifference(Scanner scanner) {
        double[] array = new double[16];
        System.out.println("Введіть 16 дійсних чисел:");
        for (int i = 0; i < 16; i++) {
            array[i] = scanner.nextDouble();
        }
        double minDifference = minDifference(array);
        System.out.println("Мінімальна різниця: " + minDifference);
    }

    public static double minDifference(double[] array) {
        if (array.length != 16) {
            throw new IllegalArgumentException("Масив повинен мати довжину 16.");
        }
        double minDifference = Double.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            double difference = Math.abs(array[i] - array[i + 8]);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }
        return minDifference;
    }

    public static void handleFindLargestTriangleArea(Scanner input) {
        double[][] triangleCoordinates = new double[3][6];

        for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
            System.out.println("Введіть координати вершин трикутника " + (triangleIndex + 1) + " (x1 y1 x2 y2 x3 y3):");
            for (int coordinateIndex = 0; coordinateIndex < 6; coordinateIndex++) {
                triangleCoordinates[triangleIndex][coordinateIndex] = input.nextDouble();
            }
        }

        double largestArea = findLargestTriangleArea(triangleCoordinates);
        int largestTriangleIndex = findLargestTriangleIndex(triangleCoordinates, largestArea);

        System.out.println("\nПлощі трикутників:");
        for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
            double currentArea = calculateArea(
                    triangleCoordinates[triangleIndex][0], triangleCoordinates[triangleIndex][1],
                    triangleCoordinates[triangleIndex][2], triangleCoordinates[triangleIndex][3],
                    triangleCoordinates[triangleIndex][4], triangleCoordinates[triangleIndex][5]
            );
            System.out.println("Трикутник " + (triangleIndex + 1) + ": " + currentArea);
        }

        System.out.println("\nТрикутник " + largestTriangleIndex + " має найбільшу площу: " + largestArea);
    }

    public static double findLargestTriangleArea(double[][] triangleCoordinates) {
        double largestArea = 0;
        for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
            double currentArea = calculateArea(
                    triangleCoordinates[triangleIndex][0], triangleCoordinates[triangleIndex][1],
                    triangleCoordinates[triangleIndex][2], triangleCoordinates[triangleIndex][3],
                    triangleCoordinates[triangleIndex][4], triangleCoordinates[triangleIndex][5]
            );
            if (currentArea > largestArea) {
                largestArea = currentArea;
            }
        }
        return largestArea;
    }

    public static int findLargestTriangleIndex(double[][] triangleCoordinates, double largestArea) {
        for (int triangleIndex = 0; triangleIndex < 3; triangleIndex++) {
            double currentArea = calculateArea(
                    triangleCoordinates[triangleIndex][0], triangleCoordinates[triangleIndex][1],
                    triangleCoordinates[triangleIndex][2], triangleCoordinates[triangleIndex][3],
                    triangleCoordinates[triangleIndex][4], triangleCoordinates[triangleIndex][5]
            );
            if (Math.abs(currentArea - largestArea) < 0.000001) {
                return triangleIndex + 1;
            }
        }
        return -1; // Should not happen
    }

    public static double calculateArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    public static void main(String[] args) {
        lab_1();
    }
}