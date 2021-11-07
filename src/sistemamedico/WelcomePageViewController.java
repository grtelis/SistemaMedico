package sistemamedico;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */
public class WelcomePageViewController implements ActionListener {    
    JFrame frame = new JFrame();  
    JLabel welcomeLabel = new JLabel(WELCOME_LABEL);
    JButton logInButton = new JButton(LOGIN_TEXT);
    JButton signInButton = new JButton(SIGN_IN_TEXT); 
    
    
    WelcomePageViewController() {
        this.constructLabels();
        this.constructButtons();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }
    
    private void constructMainFrame() {
        
        this.frame.setSize(420, 420);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.welcomeLabel);  
        this.frame.add(this.logInButton);
        this.frame.add(this.signInButton);
    }
    
    private void constructLabels() {
        this.welcomeLabel.setBounds(125, 25, 140, 140);
        this.welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.welcomeLabel.setFont(new Font(null, Font.PLAIN,25));
    }
    
    private void constructButtons() {
        this.logInButton.setBounds(130, 150, 125, 30);
        this.logInButton.addActionListener(this);
        this.logInButton.setFocusable(false);
        this.signInButton.setBounds(130, 200, 125, 30);
        this.signInButton.addActionListener(this);
        this.signInButton.setFocusable(false);
    } 
    
    private void didTapOnLogInButton(ActionEvent event) {
        this.frame.dispose();
        if(event.getSource() == this.logInButton) {
            UserDatabase userDatabase = new UserDatabase();        
            LoginPageViewController loginPage = new LoginPageViewController(userDatabase.logininfo);
        }
    }
    
    private void didTapOnSingInButton(ActionEvent event) {
        this.frame.dispose();
        if(event.getSource() == this.signInButton) {
            SignInPageViewController signInViewController = new SignInPageViewController();
        }
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnLogInButton(e);
        this.didTapOnSingInButton(e);
    }
}
