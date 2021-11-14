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
public class DoctorForm implements ActionListener {
    
    JFrame frame = new JFrame();   
    JLabel doctorFormTitle = new JLabel(); 
    JLabel identificationCard = new JLabel(IDENTIFICATION_CARD_LABEL);
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneLabel = new JLabel(PHONE_NUMBER_LABEL);
    JTextField identificationCardTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();    
    JTextField phoneTextField = new JTextField(); //ACCEPT ONLY NUMBERS
    JButton doctorFormActionButton = new JButton();
    //HOSPITAL PENDING
    
    DoctorManager doctorManager;
    boolean isEditing;                   
    
    DoctorForm(
            DoctorManager doctorManager, 
            boolean isEditing, 
            String identificationCardText, 
            String nameText, 
            String lastNamesText, 
            String phoneText
    ) {
        this.doctorManager = doctorManager;
        this.isEditing = isEditing;
        this.setTextFieldsText(identificationCardText, nameText, lastNamesText, phoneText);
        this.constructTextFields();
        this.constructButton();
        this.constructLabels();
        this.addComponents();
        this.constructMainFrame();        
    }

    DoctorForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void constructMainFrame() {
        this.frame.setSize(500, 600);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponents() {
        this.frame.add(this.doctorFormTitle);
        this.frame.add(this.nameLabel);
        this.frame.add(this.lastNamesLabel);
        this.frame.add(this.identificationCard);
        this.frame.add(this.identificationCardTextField);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.lastNamesTextField);
        this.frame.add(this.doctorFormActionButton);
        this.frame.add(this.phoneLabel);
        this.frame.add(this.phoneTextField);
    }
    
    private void constructLabels() {
        this.doctorFormTitle.setText(isEditing ? UPDATE_TEXT : ADD_DOCTOR);
        this.doctorFormTitle.setBounds(200, 25, 140, 25);
        this.identificationCard.setBounds(125, 75, 140, 25);
        this.nameLabel.setBounds(125, 150, 140, 25);
        this.lastNamesLabel.setBounds(125, 225, 140, 25);
        this.phoneLabel.setBounds(125, 300, 140, 25);
    }
    
    private void constructTextFields() {
        this.identificationCardTextField.setBounds(125, 100, 180, 25);
        this.nameTextField.setBounds(125, 175, 180, 25);
        this.lastNamesTextField.setBounds(125, 250, 180, 25);
        this.phoneTextField.setBounds(125, 325, 180, 25);
    }
    
    private void constructButton() {
        this.doctorFormActionButton.setText(isEditing ? UPDATE_TEXT : ADD_DOCTOR);
        this.doctorFormActionButton.setBounds(150, 450, 200, 25);
        this.doctorFormActionButton.setFocusable(false);
        this.doctorFormActionButton.addActionListener(this);       
    }        
    
    private void setTextFieldsText(
            String identificationCardText, 
            String nameText, 
            String lastNamesText, 
            String phoneText
    ) {
        
        this.identificationCardTextField.setText(identificationCardText);
        this.nameTextField.setText(nameText);
        this.lastNamesTextField.setText(lastNamesText);
        this.phoneTextField.setText(phoneText);                                   
    }
    
    private void didTapOnDoctorFormActionButton(ActionEvent event) {
        String identificationCardText = this.identificationCardTextField.getText();
        String nameText = this.nameTextField.getText();
        String lastNamesText = this.lastNamesTextField.getText();
        String phoneText = this.phoneTextField.getText();
        
        if(event.getSource() == this.doctorFormActionButton) {
            if (isEditing) {
                this.doctorManager.updateDoctor(0, identificationCardText, nameText, lastNamesText, phoneText, 0);
            } else {
                this.doctorManager.createDoctor(identificationCardText, nameText, lastNamesText, phoneText, 0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnDoctorFormActionButton(e);
    }
}
