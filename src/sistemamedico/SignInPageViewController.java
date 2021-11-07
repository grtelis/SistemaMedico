package sistemamedico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */

public class SignInPageViewController implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel sigInTitle = new JLabel(SIGN_IN_TEXT);
    JLabel userNameLabel = new JLabel(USERNAME_LABEL);
    JLabel passwordLabel = new JLabel(PASSWORD_LABEL);
    JLabel passwordConfirmationLabel = new JLabel(PASSWORD_CONFIRMATION_LABEL);
    JLabel messageLabel = new JLabel();
    JTextField userNameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();
    JPasswordField passwordConfirmationTextField = new JPasswordField(); 
    JButton signInButton = new JButton(SIGN_IN_TEXT);
    
    SignInPageViewController() {
        this.constructLabels();
        this.constructTextFields();
        this.constructButton();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }
    
    private void constructMainFrame() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(420, 620);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.sigInTitle);
        this.frame.add(this.userNameLabel);
        this.frame.add(this.userNameTextField);
        this.frame.add(this.passwordLabel);
        this.frame.add(this.passwordTextField);
        this.frame.add(this.passwordConfirmationLabel);
        this.frame.add(this.passwordConfirmationTextField);
        this.frame.add(this.signInButton);
        this.frame.add(this.messageLabel);
    }
    
    private void constructLabels() {
        this.sigInTitle.setBounds(175, 25, 140, 25);
        this.sigInTitle.setFont(new Font(null, Font.BOLD, 15));
        this.userNameLabel.setBounds(50,100,125,25);
        this.passwordLabel.setBounds(50,200,125,25);
        this.passwordConfirmationLabel.setBounds(50,300,200,25);
        this.messageLabel.setBounds(50,450,200,25);
    }
    
    private void constructTextFields() {
        this.userNameTextField.setBounds(50,150,125,25);
        this.passwordTextField.setBounds(50,250,125,25);
        this.passwordConfirmationTextField.setBounds(50, 350, 125, 25);
    }
    
    private void constructButton() {
        this.signInButton.setBounds(130, 400, 125, 30);
        this.signInButton.setFocusable(false);
        this.signInButton.addActionListener(this);
    }
    
    private boolean validateEmptyTextFields(String userNameText, String passwordText, String passwordConfirmation) {
        if (userNameText.isEmpty()) {
            return true;
        }
        
        if (passwordText.isEmpty()) {
            return true;
        }
        
        if (passwordConfirmation.isEmpty()) {
            return true;
        }
        
        return false;        
    }
    
    private boolean validatePasswordsMatching(String password, String passwordConfirmation) {
        return password.equals(passwordConfirmation);
    }
    
    private void didTapOnSignIn(ActionEvent event) {
        if(event.getSource() == this.signInButton) {
            String userNameText = this.userNameTextField.getText();
            String passwordText = String.valueOf(this.passwordTextField.getPassword());                                     
            String passwordConfirmationText = String.valueOf(this.passwordConfirmationTextField.getPassword());                                    
            
            boolean textFieldsAreEmpty = this.validateEmptyTextFields(
                    userNameText, 
                    passwordText, 
                    passwordConfirmationText);
            
            if (textFieldsAreEmpty) {
                this.messageLabel.setText(TEXT_FIELD_EMPTY_ERROR);
                this.messageLabel.setForeground(Color.red);
                return;
            }
            
            boolean passwordsMatch = this.validatePasswordsMatching(passwordText, passwordConfirmationText);
            
            if (passwordsMatch) {
                //TODO_ ADD HERE CREATE USER METHOD 
                this.messageLabel.setText("Exito");
                this.messageLabel.setForeground(Color.green); 
                this.frame.dispose();
                MainPageViewController mainPageViewController = new MainPageViewController();
            } else {
                this.messageLabel.setText(PASSWROD_MATCH_ERROR);
                this.messageLabel.setForeground(Color.red);
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnSignIn(e);
    }
}
