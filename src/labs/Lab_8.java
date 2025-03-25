package labs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class Lab_8 {
    public static class DrawingApp extends JFrame {
        private JPanel drawingPanel;
        private int shapeType = 0; // 0 - багатокутник, 1 - квадрат, 2 - коло

        public DrawingApp() {
            setTitle("Малювання фігур");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Панель для малювання
            drawingPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawShape(g);
                }
            };
            add(drawingPanel, BorderLayout.CENTER);

            // Меню
            JMenuBar menuBar = new JMenuBar();
            JMenu shapeMenu = new JMenu("Фігури");
            menuBar.add(shapeMenu);

            // Пункти меню з гарячими клавішами
            JMenuItem polygonItem = new JMenuItem("Багатокутник");
            polygonItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)); // Додано гарячу клавішу
            polygonItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shapeType = 0;
                    drawingPanel.repaint();
                }
            });
            shapeMenu.add(polygonItem);

            JMenuItem squareItem = new JMenuItem("Квадрат");
            squareItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // Додано гарячу клавішу
            squareItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shapeType = 1;
                    drawingPanel.repaint();
                }
            });
            shapeMenu.add(squareItem);

            JMenuItem circleItem = new JMenuItem("Коло");
            circleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // Додано гарячу клавішу
            circleItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shapeType = 2;
                    drawingPanel.repaint();
                }
            });
            shapeMenu.add(circleItem);

            setJMenuBar(menuBar);
            setVisible(true);
        }

        private void drawShape(Graphics g) {
            g.setColor(Color.BLACK);
            switch (shapeType) {
                case 0: // Багатокутник
                    int[] xPoints = {100, 150, 200, 180, 120};
                    int[] yPoints = {100, 80, 120, 180, 160};
                    g.fillPolygon(xPoints, yPoints, 5);
                    break;
                case 1: // Квадрат
                    g.fillRect(150, 150, 100, 100);
                    break;
                case 2: // Коло
                    g.fillOval(150, 150, 100, 100);
                    break;
            }
        }

        public static void lab_8() {
            SwingUtilities.invokeLater(DrawingApp::new);
        }
    }
    public static void main(String[] args) {
        Lab_8.DrawingApp.lab_8();
    }
}