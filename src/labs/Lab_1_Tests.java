package labs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab_1_Tests {

    @Test
    void testRectangleArea_Task1() {
        double a = 5;
        double b = 10;
        double expected = 50.0;
        assertEquals(expected, Lab_1.rectangleArea(a, b), 0.001);
    }

    @Test
    void testRectanglePerimeter_Task1() {
        double a = 5;
        double b = 10;
        double expected = 30.0;
        assertEquals(expected, Lab_1.rectanglePerimeter(a, b), 0.001);
    }

    @Test
    void testRectangleDiagonal_Task1() {
        double a = 3;
        double b = 4;
        double expected = 5.0;
        assertEquals(expected, Lab_1.rectangleDiagonal(a, b), 0.001);
    }

    @Test
    void testLinearEquationSingleRoot_Task2() {
        double a = 2;
        double b = -4;
        double expected = 2.0;
        assertEquals(expected, Lab_1.linearEquationRoot(a, b), 0.001);
    }

    @Test
    void testLinearEquationNoRoot_Task2() {
        double a = 0;
        double b = 5;
        assertTrue(Lab_1.linearEquationNoRootCase(a, b));
    }

    @Test
    void testLinearEquationInfiniteRoots_Task2() {
        double a = 0;
        double b = 0;
        assertTrue(Lab_1.linearEquationInfiniteRootsCase(a, b));
    }

    @Test
    void testCalculateSumPositiveN_Task3() {
        int n = 3;
        double expected = -0.5 + 0.08333333333333333 - 0.027777777777777776;
        assertEquals(expected, Lab_1.calculateSum(n), 0.000001);
    }

    @Test
    void testMinDifferencePositiveNumbers_Task4() {
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        double expected = 8.0; // Виправлено очікуваний результат
        assertEquals(expected, Lab_1.minDifference(array), 0.001);
    }

    @Test
    void testMinDifferenceNegativeNumbers_Task4() {
        double[] array = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16};
        double expected = 8.0; // Виправлено очікуваний результат
        assertEquals(expected, Lab_1.minDifference(array), 0.001);
    }

    @Test
    void testCalculateTriangleArea_Task5() {
        double x1 = 0, y1 = 0;
        double x2 = 4, y2 = 0;
        double x3 = 0, y3 = 3;
        double expected = 6.0;
        assertEquals(expected, Lab_1.calculateArea(x1, y1, x2, y2, x3, y3), 0.001);
    }

    @Test
    void testFindLargestTriangleArea_Task5() {
        double[][] coordinates = {
                {0, 0, 1, 0, 0, 1}, // Area 0.5
                {0, 0, 2, 0, 0, 2}, // Area 2.0
                {0, 0, 3, 0, 0, 1}  // Area 1.5
        };
        double expectedLargestArea = 2.0;
        assertEquals(expectedLargestArea, Lab_1.findLargestTriangleArea(coordinates), 0.001);
    }

    @Test
    void testFindLargestTriangleIndex_Task5() {
        double[][] coordinates = {
                {0, 0, 1, 0, 0, 1}, // Area 0.5
                {0, 0, 2, 0, 0, 2}, // Area 2.0
                {0, 0, 3, 0, 0, 1}  // Area 1.5
        };
        double largestArea = 2.0;
        int expectedIndex = 2;
        assertEquals(expectedIndex, Lab_1.findLargestTriangleIndex(coordinates, largestArea));
    }
}