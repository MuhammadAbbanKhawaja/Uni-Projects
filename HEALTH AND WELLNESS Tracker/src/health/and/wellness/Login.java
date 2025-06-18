package health.and.wellness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private JTextField textField;
    private JPasswordField jPasswordField;
    private JButton b1, b2, b3;

    public Login() {
        setTitle("Health and Wellness");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750, 300);
        setLocation(400, 270);
        getContentPane().setBackground(new Color(247, 247, 247));

        // Username label & field
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40, 20, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(nameLabel);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(215, 212, 217));
        add(textField);

        // Password label & field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(passwordLabel);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(215, 212, 217));
        add(jPasswordField);

        // Icon
        ImageIcon imageIcon = new ImageIcon(
            ClassLoader.getSystemResource("icon/login.png")
        );
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel iconLabel = new JLabel(new ImageIcon(i1));
        iconLabel.setBounds(300, -30, 400, 300);
        add(iconLabel);

        // Project title
        JLabel projectName = new JLabel("Health and Wellness");
        projectName.setBounds(370, 200, 500, 40);
        projectName.setFont(new Font("Vivaldi", Font.BOLD, 31));
        add(projectName);

        // Buttons
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 150, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Create new Account");
        b2.setBounds(200, 140, 200, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Forget Password");
        b3.setBounds(125, 180, 140, 30);
        b3.setFont(new Font("Serif", Font.BOLD, 14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                sqlconnect c = new sqlconnect();
                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());

                String query = "SELECT * FROM login WHERE username = '"
                    + user + "' AND password = '" + pass + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    new test();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
