
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import database.UserDatabase;

import static sistemamedico.Constants.*;

public class LoginPageViewController implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton(LOGIN_TEXT);
    JButton resetButton = new JButton(RESET_BUTTON_TEXT);
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel logInTitle = new JLabel(LOGIN_TEXT);
    JLabel userNameLabel = new JLabel(USERNAME_LABEL);
    JLabel passwordLabel = new JLabel(PASSWORD_LABEL);
    JLabel messageLabel = new JLabel();

    LoginPageViewController() {
        this.constructLabels();
        this.constructTextFields();
        this.constructButtons();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }

    private void constructMainFrame() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(420, 420);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setMinimumSize(new DimensionUIResource(420, 420));
    }

    private void addComponentsToMainFrame() {
        this.frame.add(this.userNameLabel);
        this.frame.add(this.passwordLabel);
        this.frame.add(this.userNameField);
        this.frame.add(this.passwordField);
        this.frame.add(this.loginButton);
        this.frame.add(this.resetButton);
        this.frame.add(this.messageLabel);
        this.frame.add(this.logInTitle);
    }

    private void constructLabels() {
        this.userNameLabel.setBounds(50, 100, 125, 25);
        this.passwordLabel.setBounds(50, 150, 75, 25);
        this.messageLabel.setBounds(125, 250, 250, 35);
        this.messageLabel.setFont(new Font(null, Font.BOLD, 15));
        this.logInTitle.setBounds(150, 25, 140, 25);
        this.logInTitle.setFont(new Font(null, Font.BOLD, 15));
    }

    private void constructTextFields() {
        this.userNameField.setBounds(125, 100, 200, 25);
        this.passwordField.setBounds(125, 150, 200, 25);
    }

    private void constructButtons() {
        this.loginButton.setBounds(110, 200, 115, 25);
        this.loginButton.addActionListener(this);
        this.loginButton.setFocusable(false);
        this.resetButton.setBounds(225, 200, 100, 25);
        this.resetButton.addActionListener(this);
        this.resetButton.setFocusable(false);
    }

    private void didTapOnCleanButton(ActionEvent event) {
        if (event.getSource() == this.resetButton) {
            this.userNameField.setText("");
            this.passwordField.setText("");
        }
    }

    private boolean validateEmptyTextFields(String userNameText, String passwordText) {
        if (userNameText.isEmpty()) {
            return true;
        }

        if (passwordText.isEmpty()) {
            return true;
        }

        return false;
    }

    private void didTapOnLogInButton(ActionEvent event) {
        if (event.getSource() == this.loginButton) {
            String userNameText = this.userNameField.getText();
            String passwordText = String.valueOf(this.passwordField.getPassword());

            boolean textFieldsAreEmpty = this.validateEmptyTextFields(userNameText, passwordText);

            if (textFieldsAreEmpty) {
                this.messageLabel.setForeground(Color.red);
                this.messageLabel.setText(TEXT_FIELD_EMPTY_ERROR);
                return;
            }

            UserDatabase userDB = new UserDatabase();
            if (userDB.logInUser(userNameText, passwordText)) {
                new MainPageViewController();
                this.frame.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnCleanButton(e);
        this.didTapOnLogInButton(e);
    }
}
