package labs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Lab_6 {
    public static class HexagonApp extends JFrame {
        private Color hexagonColor = Color.WHITE; // Початковий колір шестикутника
        public HexagonApp() {
            setTitle("Шестикутник");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);

            // Панель для малювання шестикутника
            JPanel hexagonPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawHexagon(g);
                }
            };
            hexagonPanel.setBounds(20, 20, 200, 200);
            add(hexagonPanel);

            // Кнопка "Залити червоним"
            JButton redButton = new JButton("Залити червоним");
            redButton.setBounds(250, 20, 130, 30);
            redButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hexagonColor = Color.RED;
                    hexagonPanel.repaint();
                }
            });
            add(redButton);

            // Кнопка "Залити жовтим"
            JButton yellowButton = new JButton("Залити жовтим");
            yellowButton.setBounds(250, 60, 130, 30);
            yellowButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hexagonColor = Color.YELLOW;
                    hexagonPanel.repaint();
                }
            });
            add(yellowButton);

            // Кнопка "Скасувати"
            JButton resetButton = new JButton("Скасувати");
            resetButton.setBounds(250, 100, 130, 30);
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hexagonColor = Color.WHITE;
                    hexagonPanel.repaint();
                }
            });
            add(resetButton);

            setVisible(true);
        }

        private void drawHexagon(Graphics g) {
            int[] xPoints = {100, 150, 150, 100, 50, 50};
            int[] yPoints = {50, 80, 130, 160, 130, 80};
            g.setColor(hexagonColor);
            g.fillPolygon(xPoints, yPoints, 6);
            g.setColor(Color.BLACK);
            g.drawPolygon(xPoints, yPoints, 6);
        }

        public static void lab_6 () {
            SwingUtilities.invokeLater(HexagonApp::new);
        }
    }
    public static void main(String[] args) {
        HexagonApp.lab_6();
    }
}
