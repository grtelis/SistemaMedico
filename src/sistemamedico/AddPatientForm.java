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
public class AddPatientForm implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel addPatientTitle = new JLabel(ADD_PATIENT);
    JLabel ageLabel = new JLabel(AGE_LABEL); //ONLY NUMBERS
    JLabel weightLabel = new JLabel(WEIGHT_LABEL); //ONLY NUMBERS
    JLabel sizeLabel = new JLabel(SIZE_LABEL); //ONLY NUMBERS
    JLabel sufferingLabel = new JLabel(SUFFERING_LABEL); //ONLY NUMBERS
    JLabel nameLabel = new JLabel(NAME_LABEL); 
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneNumberLabel = new JLabel(PHONE_NUMBER_LABEL);
    JTextField ageTextField = new JTextField();
    JTextField weightTextField = new JTextField();
    JTextField sizeTextField = new JTextField();
    JTextField sufferingTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();
    JTextField phoneNumberTextField = new JTextField();
    JButton addPatientButton = new JButton(ADD_PATIENT);
    
    AddPatientForm() {
        this.constructButton();
        this.constructTextFields();
        this.constructLabels();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }
    
    private void constructMainFrame() {
        this.frame.setSize(500, 700);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.addPatientTitle);
        this.frame.add(this.ageLabel);
        this.frame.add(this.ageTextField);
        this.frame.add(this.weightLabel);
        this.frame.add(this.weightTextField);
        this.frame.add(this.sizeLabel);
        this.frame.add(this.sizeTextField);
        this.frame.add(this.sufferingLabel);
        this.frame.add(this.sufferingTextField);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.lastNamesLabel);
        this.frame.add(this.lastNamesTextField);              
        this.frame.add(this.addPatientButton);
    }
    
    private void constructLabels() {
        this.addPatientTitle.setBounds(200, 25, 140, 25);
        this.ageLabel.setBounds(125, 75, 140, 25);
        this.weightLabel.setBounds(125, 150, 140, 25);
        this.sizeLabel.setBounds(125, 225, 140, 25);
        this.sufferingLabel.setBounds(125, 300, 140, 25);
        this.nameLabel.setBounds(125, 375, 140, 25);
        this.lastNamesLabel.setBounds(125, 450, 140, 25);
    }
    
    private void constructTextFields() {
        this.ageTextField.setBounds(125, 100, 180, 25);
        this.weightTextField.setBounds(125, 175, 180, 25);
        this.sizeTextField.setBounds(125, 250, 180, 25);
        this.sufferingTextField.setBounds(125, 325, 180, 25);        
        this.nameTextField.setBounds(125, 400, 180, 25);        
        this.lastNamesTextField.setBounds(125, 475, 180, 25);        
    }
    
    private void constructButton() {
        this.addPatientButton.setBounds(150, 525, 200, 25);
        this.addPatientButton.setFocusable(false);
        this.addPatientButton.addActionListener(this);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
