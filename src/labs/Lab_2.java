package labs;
public class Lab_2 {
    static class Matrix2x3 { // Зробити клас статичним
        private double[][] matrix;

        public Matrix2x3(double[][] matrix) {
            if (matrix == null || matrix.length != 2 || matrix[0].length != 3) {
                throw new IllegalArgumentException("Матриця повинна мати розмір 2x3.");
            }
            this.matrix = matrix;
        }

        public Matrix2x3 multiplyByScalar(double scalar) {
            double[][] result = new double[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = matrix[i][j] * scalar;
                }
            }
            return new Matrix2x3(result);
        }

        public Matrix2x3 add(Matrix2x3 other) {
            if (other == null) {
                throw new IllegalArgumentException("Інша матриця не може бути null.");
            }
            double[][] result = new double[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = matrix[i][j] + other.matrix[i][j];
                }
            }
            return new Matrix2x3(result);
        }

        public Matrix3x2 transpose() {
            double[][] transposed = new double[3][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }
            return new Matrix3x2(transposed);
        }

        public void print() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void lab_2() {
            double[][] data1 = {{1, 2, 3}, {4, 5, 6}};
            double[][] data2 = {{7, 8, 9}, {10, 11, 12}};
            Matrix2x3 matrix1 = new Matrix2x3(data1);
            Matrix2x3 matrix2 = new Matrix2x3(data2);

            System.out.println("Матриця 1:");
            matrix1.print();

            System.out.println("\nМатриця 2:");
            matrix2.print();

            System.out.println("\nМатриця 1, помножена на 2:");
            matrix1.multiplyByScalar(2).print();

            System.out.println("\nМатриця 1 + Матриця 2:");
            matrix1.add(matrix2).print();

            System.out.println("\nТранспонована Матриця 1:");
            matrix1.transpose().print();
        }
    }

    static class Matrix3x2 { // Зробити клас статичним
        private double[][] matrix;

        public Matrix3x2(double[][] matrix) {
            if (matrix == null || matrix.length != 3 || matrix[0].length != 2) {
                throw new IllegalArgumentException("Матриця повинна мати розмір 3x2.");
            }
            this.matrix = matrix;
        }

        public void print() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void lab_2() { // Додати метод main
        Matrix2x3.lab_2();
    }
}