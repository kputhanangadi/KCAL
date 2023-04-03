package src.ui;

import src.model.FoodItem;
import src.model.JunkFood;
import src.model.ListManager;
import src.model.RegularFood;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceSelectionSystemGUI extends JFrame implements ActionListener {

    private ListManager listManager = new ListManager();

    private JLabel foodTypeLabel;
    private JLabel foodNameLabel;
    private JLabel caloriesLabel;
    private JLabel sugarLabel;
    private JTextField foodNameField;
    private JTextField caloriesField;
    private JTextField sugarField;
    private JButton addButton;
    private JButton removeButton;
    private JButton showButton;
    private JButton caloriesButton;
    private JButton quitButton;
    private JList<FoodItem> foodList;
    private JLabel totalCaloriesLabel;
    private JComboBox<String> foodTypeComboBox;
    private DefaultListModel<FoodItem> foodListModel;

    public InterfaceSelectionSystemGUI() {
        setTitle("Food Selection System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        foodTypeLabel = new JLabel("Select Food Type:");
        inputPanel.add(foodTypeLabel);

        String[] foodTypes = {"Regular", "Junk"};
        foodTypeComboBox = new JComboBox<>(foodTypes);
        inputPanel.add(foodTypeComboBox);

        foodNameLabel = new JLabel("Enter Food Name:");
        inputPanel.add(foodNameLabel);

        foodNameField = new JTextField();
        inputPanel.add(foodNameField);

        caloriesLabel = new JLabel("Enter Calories:");
        inputPanel.add(caloriesLabel);

        caloriesField = new JTextField();
        inputPanel.add(caloriesField);

        sugarLabel = new JLabel("Enter Sugar (for Junk Food only):");
        inputPanel.add(sugarLabel);

        sugarField = new JTextField();
        inputPanel.add(sugarField);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        addButton = new JButton("Add Food");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove Food");
        removeButton.addActionListener(this);
        buttonPanel.add(removeButton);

        showButton = new JButton("Show Foods");
        showButton.addActionListener(this);
        buttonPanel.add(showButton);

        caloriesButton = new JButton("Calculate Total Calories");
        caloriesButton.addActionListener(this);
        buttonPanel.add(caloriesButton);

        quitButton = new JButton("Quit Program");
        quitButton.addActionListener(this);
        buttonPanel.add(quitButton);

        foodList = new JList<>(new DefaultListModel<>());
        mainPanel.add(new JScrollPane(foodList), BorderLayout.SOUTH);

        totalCaloriesLabel = new JLabel("Total Calories: 0");
        mainPanel.add(totalCaloriesLabel, BorderLayout.PAGE_END);

        setContentPane(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Get the selected food type from the combo box
            String foodType = (String) foodTypeComboBox.getSelectedItem();

            // Get the food name and calories from their respective fields
            String foodName = foodNameField.getText();
            int calories = Integer.parseInt(caloriesField.getText());

            // Initialize sugar to 0
            int sugar = 0;

            // If the selected food type is Junk, get the sugar value from the sugar field
            if (foodType.equals("Junk")) {
                sugar = Integer.parseInt(sugarField.getText());
            }

            // Declare a new FoodItem variable
            FoodItem foodItem;

            // If the selected food type is Regular, create a new RegularFood object
            if (foodType.equals("Regular")) {
                foodItem = new RegularFood(foodName, calories);
            }
            // Otherwise, create a new JunkFood object with the sugar value
            else {
                foodItem = new JunkFood(foodName, calories, sugar);
            }

            // Add the new food item to the food list model
            foodListModel.addElement(foodItem);

            // Update the total calories label
            totalCaloriesLabel.setText("Total Calories: " + listManager.getTotalCaloriesConsumed());

            // Clear the food name, calories, and sugar fields
            foodNameField.setText("");
            caloriesField.setText("");
            sugarField.setText("");
        } else if (e.getSource() == removeButton) {
            // Remove the selected food item from the food list model
            foodListModel.removeElement(foodList.getSelectedValue());

            // Update the total calories label
            totalCaloriesLabel.setText("Total Calories: " + listManager.getTotalCaloriesConsumed());
        } else if (e.getSource() == quitButton) {
            // Quit the program
            System.exit(0);
        }
    }
}
