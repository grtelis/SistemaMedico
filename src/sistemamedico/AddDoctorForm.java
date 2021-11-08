package sistemamedico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */
public class AddDoctorForm implements ActionListener {
    
    JFrame frame = new JFrame();   
    JLabel addDoctorTitle = new JLabel(ADD_DOCTOR); 
    JLabel identificationCard = new JLabel(IDENTIFICATION_CARD_LABEL);
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneLabel = new JLabel(PHONE_NUMBER_LABEL);
    JTextField identificationCardTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();
    JTextField phoneTextField = new JTextField(); //ACCEPT ONLY NUMBERS  
    JButton addButton = new JButton(ADD_DOCTOR);
    //HOSPITAL PENDING
    
    
    AddDoctorForm() {
        this.constructTextFields();
        this.constructButton();
        this.constructLabels();
        this.addComponents();
        this.constructMainFrame();        
    }
    
    private void constructMainFrame() {
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponents() {
        this.frame.add(this.addDoctorTitle);
        this.frame.add(this.nameLabel);
        this.frame.add(this.lastNamesLabel);
        this.frame.add(this.identificationCard);
        this.frame.add(this.identificationCardTextField);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.lastNamesTextField);
        this.frame.add(this.addButton);
    }
    
    private void constructLabels() {
        this.addDoctorTitle.setBounds(200, 25, 140, 25);
        this.identificationCard.setBounds(125, 75, 140, 25);
        this.nameLabel.setBounds(125, 150, 140, 25);
        this.lastNamesLabel.setBounds(125, 225, 140, 25);
    }
    
    private void constructTextFields() {
        this.identificationCardTextField.setBounds(125, 100, 180, 25);
        this.nameTextField.setBounds(125, 175, 180, 25);
        this.lastNamesTextField.setBounds(125, 250, 180, 25);
        
    }
    
    private void constructButton() {
        this.addButton.setBounds(150, 350, 200, 25);
        this.addButton.setFocusable(false);
        this.addButton.addActionListener(this);       
    }        
    
    private void didTapOnAddDoctor(ActionEvent event) {
        if(event.getSource() == this.addButton) {
            //TODO: ADD INSERT TO DOCTOR TABLE HERE
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnAddDoctor(e);
    }
    
}
