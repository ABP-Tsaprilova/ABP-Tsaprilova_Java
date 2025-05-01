package labs;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab_10 {
    public static class DrawPoints extends JPanel {
        private List<Point> points = new ArrayList<>();

        public DrawPoints() {
            loadPointsFromFile("INPUT.txt");
        }
        private void loadPointsFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        try {
                            int x = Integer.parseInt(parts[0].trim());
                            int y = Integer.parseInt(parts[1].trim());
                            points.add(new Point(x, y));
                        } catch (NumberFormatException e) {
                            System.err.println("Неправильний формат координат: " + line);
                        }
                    } else {
                        System.err.println("Неправильний формат рядка: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Помилка при читанні файлу INPUT.txt: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point point : points) {
                g.fillOval(point.x - 5, point.y - 5, 10, 10);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Малювання точок");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.getContentPane().add(new DrawPoints());
            frame.setVisible(true);
        });
    }
}

