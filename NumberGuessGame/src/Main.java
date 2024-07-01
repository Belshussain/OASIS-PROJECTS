import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private JFrame frame;
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;

    private Random random;
    private int lowerBound = 1;
    private int upperBound = 100;
    private int randomNumber;
    private int maxAttempts = 10;
    private int attempts = 0;
    private int score = 0;

    public Main() {
        random = new Random();
        randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250); // Adjusted size for better layout

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // Increased rows for better spacing and aesthetics
        panel.setBackground(new Color(235, 252, 255)); // Light blue background color

        Font bigFont = new Font("Arial", Font.BOLD, 18); // Custom font for headers and labels

        messageLabel = new JLabel("Guess a number between " + lowerBound + " and " + upperBound);
        messageLabel.setFont(bigFont);
        panel.add(messageLabel);

        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.PLAIN, 16)); // Custom font for input field
        panel.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setFont(bigFont);
        guessButton.setBackground(new Color(87, 181, 192)); // Custom button color
        guessButton.setForeground(Color.WHITE); // Button text color
        guessButton.addActionListener(new GuessButtonListener());
        panel.add(guessButton);

        attemptsLabel = new JLabel("Attempts left: " + (maxAttempts - attempts));
        attemptsLabel.setFont(bigFont);
        panel.add(attemptsLabel);

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(bigFont);
        panel.add(scoreLabel);

        frame.getContentPane().setBackground(new Color(235, 252, 255)); // Matching background color for frame
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (attempts < maxAttempts) {
                try {
                    int guess = Integer.parseInt(guessField.getText().trim());
                    attempts++;

                    if (guess == randomNumber) {
                        JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the number in " + attempts + " attempts.");
                        score += (maxAttempts - attempts + 1) * 10;
                        scoreLabel.setText("Score: " + score);
                        resetGame();
                    } else if (guess < randomNumber) {
                        JOptionPane.showMessageDialog(frame, "Too low! Try again.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Too high! Try again.");
                    }

                    attemptsLabel.setText("Attempts left: " + (maxAttempts - attempts));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Sorry, you've run out of attempts. The number was " + randomNumber);
                resetGame();
            }
        }
    }

    private void resetGame() {
        randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        attempts = 0;
        attemptsLabel.setText("Attempts left: " + (maxAttempts - attempts));
        scoreLabel.setText("Score: " + score);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

