/* Write a program that creates a user interface to perform
integer divisions. The user enters two numbers in the text
fields, Num1 and Num2. The division of Num1 and Num2
is displayed in the Result field when the Divide button is
clicked. If Num1 or Num2 were not an integer, the
program would throw a NumberFormatException. If Num2
were Zero, the program would throw an Arithmetic
Exception Display the exception in a message dialog box. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Integer Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // Create and add components
        JLabel labelNum1 = new JLabel("Num1:");
        JTextField textNum1 = new JTextField();
        JLabel labelNum2 = new JLabel("Num2:");
        JTextField textNum2 = new JTextField();
        JLabel labelResult = new JLabel("Result:");
        JTextField textResult = new JTextField();
        textResult.setEditable(false);
        JButton divideButton = new JButton("Divide");

        // Add components to the frame
        frame.add(labelNum1);
        frame.add(textNum1);
        frame.add(labelNum2);
        frame.add(textNum2);
        frame.add(labelResult);
        frame.add(textResult);
        frame.add(new JLabel()); // Empty cell
        frame.add(divideButton);

        // Add action listener to the button
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse inputs
                    int num1 = Integer.parseInt(textNum1.getText());
                    int num2 = Integer.parseInt(textNum2.getText());

                    // Perform division
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }

                    int result = num1 / num2;
                    textResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid integers for Num1 and Num2.",
                            "Number Format Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame,
                            ex.getMessage(),
                            "Arithmetic Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}