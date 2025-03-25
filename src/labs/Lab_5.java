package labs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lab_5 {
    public static class DocumentConverter extends JFrame {
        public DocumentConverter() {
            setTitle("Конвертація документів");
            setSize(400, 350); // Збільшено розмір для кращого відображення
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);


            JPanel contentPane = new JPanel();
            contentPane.setBackground(new Color(250, 240, 230)); // Колір фону
            contentPane.setBounds(0, 0, 400, 350);
            add(contentPane);
            contentPane.setLayout(null);


            JLabel titleLabel = new JLabel("Конвертація документів");
            titleLabel.setBounds(100, 20, 250, 30);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setForeground(new Color(139, 69, 19)); // Колір тексту
            contentPane.add(titleLabel);


            JLabel taskLabel = new JLabel("Оберіть завдання:");
            taskLabel.setBounds(20, 60, 150, 20);
            contentPane.add(taskLabel);


            try {
                Image pdfIcon = ImageIO.read(new File("pdf_icon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                JButton pdfButton = new JButton(new ImageIcon(pdfIcon));
                pdfButton.setBounds(20, 90, 40, 40);
                contentPane.add(pdfButton);

                Image wordIcon = ImageIO.read(new File("word_icon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                JButton wordButton = new JButton(new ImageIcon(wordIcon));
                wordButton.setBounds(20, 140, 40, 40);
                contentPane.add(wordButton);

                Image excelIcon = ImageIO.read(new File("excel_icon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                JButton excelButton = new JButton(new ImageIcon(excelIcon));
                excelButton.setBounds(20, 190, 40, 40);
                contentPane.add(excelButton);

            } catch (IOException e) {
                e.printStackTrace();
            }

            JLabel pdfLabel = new JLabel("Конвертувати в PDF");
            pdfLabel.setBounds(70, 100, 150, 20);
            contentPane.add(pdfLabel);

            JLabel wordLabel = new JLabel("Конвертувати в Microsoft Word");
            wordLabel.setBounds(70, 150, 200, 20);
            contentPane.add(wordLabel);

            JLabel excelLabel = new JLabel("Перетворити на документ Microsoft Excel");
            excelLabel.setBounds(70, 200, 250, 20);
            contentPane.add(excelLabel);


            JLabel fileNameLabel = new JLabel("Ім'я файлу:");
            fileNameLabel.setBounds(20, 240, 100, 20);
            contentPane.add(fileNameLabel);

            JTextField fileNameField = new JTextField();
            fileNameField.setBounds(100, 240, 200, 20);
            contentPane.add(fileNameField);


            JButton nextButton = new JButton("Далі");
            nextButton.setBounds(310, 240, 70, 20);
            nextButton.setBackground(new Color(205, 133, 63)); // Колір кнопки
            nextButton.setForeground(Color.WHITE); // Колір тексту кнопки
            contentPane.add(nextButton);


            JCheckBox agreeCheckBox = new JCheckBox("Я погоджуюсь з Умовами");
            agreeCheckBox.setBounds(20, 270, 200, 20);
            contentPane.add(agreeCheckBox);

            setVisible(true);
        }

        public static void lab_5 () {
            SwingUtilities.invokeLater(DocumentConverter::new);
        }
        }
        public static void main(String[] args) {
            DocumentConverter.lab_5();
        }

}