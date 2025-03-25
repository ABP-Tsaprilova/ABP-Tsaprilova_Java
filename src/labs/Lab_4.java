package labs;
import javax.swing.*;
import java.awt.*;

public class Lab_4 {
    public static class ShapesApp extends JFrame {

        public ShapesApp() {
            setTitle("Фігури");
            setSize(500, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);

            // Круг
            JPanel circlePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.RED);
                    g.fillOval(10, 10, 80, 80);
                }
            };
            circlePanel.setBounds(20, 20, 100, 100);
            add(circlePanel);

            JLabel circleLabel = new JLabel("Круг, червоний");
            circleLabel.setBounds(20, 120, 150, 20);
            circleLabel.setFont(new Font("Arial", Font.BOLD, 14));
            circleLabel.setForeground(Color.DARK_GRAY);
            add(circleLabel);

            // Квадрат
            JPanel squarePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.BLUE);
                    g.fillRect(10, 10, 80, 80);
                }
            };
            squarePanel.setBounds(150, 20, 100, 100);
            add(squarePanel);

            JLabel squareLabel = new JLabel("Квадрат, синій");
            squareLabel.setBounds(150, 120, 150, 20);
            squareLabel.setFont(new Font("Arial", Font.BOLD, 14));
            squareLabel.setForeground(Color.DARK_GRAY);
            add(squareLabel);

            // Трапеція
            JPanel trapezoidPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.GREEN);
                    int[] xPoints = {10, 90, 70, 30};
                    int[] yPoints = {90, 90, 10, 10};
                    g.fillPolygon(xPoints, yPoints, 4);
                }
            };
            trapezoidPanel.setBounds(280, 20, 100, 100);
            add(trapezoidPanel);

            JLabel trapezoidLabel = new JLabel("Трапеція, зелена"); // Додано мітку для трапеції
            trapezoidLabel.setBounds(280, 120, 150, 20);
            trapezoidLabel.setFont(new Font("Arial", Font.BOLD, 14));
            trapezoidLabel.setForeground(Color.DARK_GRAY);
            add(trapezoidLabel);

            setVisible(true);
        }

        public static void lab_4() {
            SwingUtilities.invokeLater(ShapesApp::new);
        }
    }

    public static void main(String[] args) {
        ShapesApp.lab_4();
    }
}