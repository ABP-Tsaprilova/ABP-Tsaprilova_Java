package labs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_7 {

    public static class TriangleInputForm extends JFrame {

        private JTextField sideAField, sideBField, sideCField;

        public TriangleInputForm() {
            setTitle("Введення сторін трикутника");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(4, 2));

            add(new JLabel("Сторона A:"));
            sideAField = new JTextField();
            add(sideAField);

            add(new JLabel("Сторона B:"));
            sideBField = new JTextField();
            add(sideBField);

            add(new JLabel("Сторона C:"));
            sideCField = new JTextField();
            add(sideCField);

            JButton calculateButton = new JButton("Розрахувати");
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double a = Double.parseDouble(sideAField.getText());
                        double b = Double.parseDouble(sideBField.getText());
                        double c = Double.parseDouble(sideCField.getText());

                        TriangleResultForm resultForm = new TriangleResultForm(a, b, c);
                        resultForm.setVisible(true);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(TriangleInputForm.this, "Некоректний ввід!");
                    }
                }
            });
            add(calculateButton);

            setVisible(true);
        }
        public static class TriangleResultForm extends JFrame {

            public TriangleResultForm(double a, double b, double c) {
                setTitle("Результати розрахунку");
                setSize(300, 150);
                setLayout(new GridLayout(2, 2));

                double perimeter = a + b + c;
                double s = perimeter / 2;
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

                add(new JLabel("Периметр:"));
                add(new JLabel(String.valueOf(perimeter)));

                add(new JLabel("Площа:"));
                add(new JLabel(String.valueOf(area)));
            }
        }

        public static void lab_7 () {
            SwingUtilities.invokeLater(TriangleInputForm::new);
        }
    }
    public static void main(String[] args) {
        Lab_7.TriangleInputForm.lab_7();
    }
}
