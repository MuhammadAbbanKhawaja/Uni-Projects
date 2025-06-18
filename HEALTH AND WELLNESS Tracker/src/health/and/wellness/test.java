package health.and.wellness;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame {

    public test() {
        setTitle("Dashboard");
        setSize(500, 500);
        setLocationRelativeTo(null); // center on screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Example content: a simple welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Health & Wellness Tracker", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(welcomeLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test());
    }
}
