package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class App {

    public class HouseholdChemistryApp extends JFrame implements ActionListener {

        private JTable dataTable;
        private DefaultTableModel tableModel;
        private JButton addButton;
        private JButton deleteButton;
        private JTextField nameField;
        private JTextField categoryField;
        private JTextField priceField;
        private JTextField quantityField;

        private static final String DB_URL = "jdbc:mysql://localhost:3306/household_chemistry?serverTimezone=UTC";
        private static final String DB_USER = "root"; // Замініть на ваше ім'я користувача MySQL
        private static final String DB_PASSWORD = "20070115ts"; // Замініть на ваш пароль MySQL

        public HouseholdChemistryApp() {
            setTitle("Магазин побутової хімії");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());


            tableModel = new DefaultTableModel();
            dataTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(dataTable);
            add(scrollPane, BorderLayout.CENTER);


            JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel nameLabel = new JLabel("Назва:");
            nameField = new JTextField(20);
            JLabel categoryLabel = new JLabel("Категорія:");
            categoryField = new JTextField(20);
            JLabel priceLabel = new JLabel("Ціна:");
            priceField = new JTextField(10);
            JLabel quantityLabel = new JLabel("Кількість:");
            quantityField = new JTextField(10);
            addButton = new JButton("Додати товар");
            addButton.addActionListener(this);

            addPanel.add(nameLabel);
            addPanel.add(nameField);
            addPanel.add(categoryLabel);
            addPanel.add(categoryField);
            addPanel.add(priceLabel);
            addPanel.add(priceField);
            addPanel.add(quantityLabel);
            addPanel.add(quantityField);
            addPanel.add(addButton);
            add(addPanel, BorderLayout.NORTH);


            JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            deleteButton = new JButton("Видалити товар");
            deleteButton.addActionListener(this);
            deletePanel.add(deleteButton);
            add(deletePanel, BorderLayout.SOUTH);

            createTableIfNotExists();
            loadData();
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void createTableIfNotExists() {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "category VARCHAR(100)," +
                    "price DECIMAL(10, 2)," +
                    "quantity INT)";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Таблицю 'products' успішно створено (або вона вже існувала).");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Помилка створення таблиці: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        private void loadData() {
            tableModel.setColumnCount(0);
            tableModel.setRowCount(0);

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();


                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnName(i));
                }


                while (resultSet.next()) {
                    Vector<Object> row = new Vector<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(resultSet.getObject(i));
                    }
                    tableModel.addRow(row);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Помилка завантаження даних: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        private void addProduct() {
            String name = nameField.getText();
            String category = categoryField.getText();
            String priceText = priceField.getText();
            String quantityText = quantityField.getText();

            if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Будь ласка, заповніть назву, ціну та кількість.", "Помилка", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(quantityText);
                String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, category);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setInt(4, quantity);
                    preparedStatement.executeUpdate();
                    loadData();

                    nameField.setText("");
                    categoryField.setText("");
                    priceField.setText("");
                    quantityField.setText("");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Помилка додавання товару: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Невірний формат ціни або кількості.", "Помилка", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void deleteSelectedProduct() {
            int selectedRow = dataTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Будь ласка, виберіть товар для видалення.", "Попередження", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idToDelete = (int) tableModel.getValueAt(selectedRow, 0); // Припускаємо, що ID знаходиться в першому стовпці

            int confirmation = JOptionPane.showConfirmDialog(this, "Ви впевнені, що хочете видалити товар з ID: " + idToDelete + "?", "Підтвердження", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM products WHERE id = ?";
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, idToDelete);
                    preparedStatement.executeUpdate();
                    loadData();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Помилка видалення товару: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                addProduct();
            } else if (e.getSource() == deleteButton) {
                deleteSelectedProduct();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().new HouseholdChemistryApp());
    }
}