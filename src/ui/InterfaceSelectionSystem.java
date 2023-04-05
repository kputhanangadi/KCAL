package src.ui;


import src.model.JunkFood;
import src.model.ListManager;
import src.model.RegularFood;
import src.model.TooManyCaloriesException;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;



public class InterfaceSelectionSystem extends JFrame implements ActionListener {
    private ListManager listManager;
    private final JTextField itemNameField, caloriesField, sugarField;
    private final JButton addRegularButton, addJunkButton, deleteButton, showAllButton, caloriesButton, quitButton;
    private final JTextArea foodItemListTextArea;

    private Clip clip;

    public InterfaceSelectionSystem() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        listManager = new ListManager();

        // Load the image
        ImageIcon logo = new ImageIcon("src/ui/Logo.png");

        // Sound Setup
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src/ui/Sound.wav"));
        clip.open(inputStream);
        clip.start();


        // Set up GUI components
        JLabel itemNameLabel = new JLabel("Food Item :");
        itemNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        itemNameField = new JTextField(10);
        JLabel caloriesLabel = new JLabel("Calorie Count :");
        caloriesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        caloriesField = new JTextField(5);
        JLabel sugarLabel = new JLabel("Sugar Count (Junk Food Only) :");
        sugarLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sugarField = new JTextField(5);
        addRegularButton = new JButton("Add Regular Food");
        addRegularButton.setFont(new Font("Arial", Font.BOLD, 14));
        addJunkButton = new JButton("Add Junk Food");
        addJunkButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton = new JButton("Delete a Food Item");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        showAllButton = new JButton("Show All Foods");
        showAllButton.setFont(new Font("Arial", Font.BOLD, 14));
        caloriesButton = new JButton("Calorie Total");
        caloriesButton.setFont(new Font("Arial", Font.BOLD, 14));
        quitButton = new JButton("Quit Program");
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        foodItemListTextArea = new JTextArea(10, 30);
        foodItemListTextArea.setEditable(false);
        foodItemListTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Set up ActionListener for buttons
        addRegularButton.addActionListener(this);
        addJunkButton.addActionListener(this);
        deleteButton.addActionListener(this);
        showAllButton.addActionListener(this);
        caloriesButton.addActionListener(this);
        quitButton.addActionListener(this);

        // Set up layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(itemNameLabel);
        inputPanel.add(itemNameField);
        inputPanel.add(caloriesLabel);
        inputPanel.add(caloriesField);
        inputPanel.add(sugarLabel);
        inputPanel.add(sugarField);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(addRegularButton);
        buttonPanel.add(addJunkButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(caloriesButton);
        buttonPanel.add(quitButton);

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setPreferredSize(new Dimension(500, 500)); // set a fixed size
        logoPanel.add(logoLabel);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(Color.WHITE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(emptyPanel, BorderLayout.WEST); // add an empty panel to the left
        mainPanel.add(logoPanel, BorderLayout.CENTER); // add logo panel to the center
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.EAST);


        // Set up JFrame
        setTitle("KCAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 675));
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add Regular Food":
                String regularFoodItem = itemNameField.getText();
                int regularFoodCalories = Integer.parseInt(caloriesField.getText());
                RegularFood regularFood = new RegularFood(regularFoodItem, regularFoodCalories);
                try {
                    listManager.addNewFood(regularFood);
                    JOptionPane.showMessageDialog(this, "Added " + regularFoodItem + " to food consumed list.");
                    clip.start();
                } catch (TooManyCaloriesException exception) {
                    JOptionPane.showMessageDialog(this, "Exceeded daily calorie intake.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Add Junk Food":
                String junkFoodItem = itemNameField.getText();
                int junkFoodCalories = Integer.parseInt(caloriesField.getText());
                int junkFoodSugar = Integer.parseInt(sugarField.getText());
                JunkFood junkFood = new JunkFood(junkFoodItem, junkFoodCalories, junkFoodSugar);
                try {
                    listManager.addNewFood(junkFood);
                    JOptionPane.showMessageDialog(this, "Added " + junkFoodItem + " to food consumed list.");
                } catch (TooManyCaloriesException exception) {
                    JOptionPane.showMessageDialog(this, "Exceeded daily calorie intake.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Delete a Food Item":
                if (listManager.foodCount() > 0) {
                    if (listManager.foodItemList.size() == 0) {
                        JOptionPane.showMessageDialog(this, "Eat some food to log!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int index = Integer.parseInt(JOptionPane.showInputDialog(this, listManager.getFoodItemsOutput(), "Remove Food Item", JOptionPane.QUESTION_MESSAGE)) - 1;
                        if (index >= 0 && index < listManager.foodCount()) {
                            Clip clip = null;
                            try {
                                clip = AudioSystem.getClip();
                            } catch (LineUnavailableException ex) {
                                throw new RuntimeException(ex);
                            }
                            AudioInputStream inputStream = null;
                            try {
                                inputStream = AudioSystem.getAudioInputStream(new File("src/ui/Sound.wav"));
                            } catch (UnsupportedAudioFileException ex) {
                                throw new RuntimeException(ex);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            try {
                                clip.open(inputStream);
                            } catch (LineUnavailableException ex) {
                                throw new RuntimeException(ex);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            clip.start();
                            listManager.deleteFoodIndex(index);
                            JOptionPane.showMessageDialog(this, "Removed item from food consumed list.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid index.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No food items are available.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Show All Foods":
                if (listManager.foodItemList.size() == 0) {
                    JOptionPane.showMessageDialog(this, "Eat some food to log!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Clip clip = null;
                    try {
                        clip = AudioSystem.getClip();
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                    AudioInputStream inputStream = null;
                    try {
                        inputStream = AudioSystem.getAudioInputStream(new File("src/ui/Sound.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        clip.open(inputStream);
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    clip.start();
                    JOptionPane.showMessageDialog(this, listManager.getFoodItemsOutput(), "Food Consumed List", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Calorie Total":
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                AudioInputStream inputStream = null;
                try {
                    inputStream = AudioSystem.getAudioInputStream(new File("src/ui/Sound.wav"));
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    clip.open(inputStream);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                clip.start();
                JOptionPane.showMessageDialog(this, "Total calories consumed: " + listManager.getTotalCaloriesConsumed());
                break;
            case "Quit Program":
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    clip = null;
                    try {
                        clip = AudioSystem.getClip();
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                    inputStream = null;
                    try {
                        inputStream = AudioSystem.getAudioInputStream(new File("src/ui/Sound.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        clip.open(inputStream);
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    clip.start();

                    System.exit(0);
                }
                break;
        }
    }
}
