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
public class PatientForm implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel patientFormTitle = new JLabel();
    JLabel ageLabel = new JLabel(AGE_LABEL); //ONLY NUMBERS
    JLabel weightLabel = new JLabel(WEIGHT_LABEL); //ONLY NUMBERS
    JLabel sizeLabel = new JLabel(SIZE_LABEL); //ONLY NUMBERS
    JLabel sufferingLabel = new JLabel(SUFFERING_LABEL); 
    JLabel nameLabel = new JLabel(NAME_LABEL); 
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneNumberLabel = new JLabel(PHONE_NUMBER_LABEL);
    JTextField ageTextField = new JTextField();
    JTextField weightTextField = new JTextField();
    JTextField sizeTextField = new JTextField();
    JTextField sufferingTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();
    JTextField phoneNumberTextField = new JTextField(); //ADD THIS
    JButton patientFormActionButton = new JButton();
    
    PatientManager patientManager;
    
    boolean isEditing;    
    
    PatientForm(
            PatientManager patientManager, 
            boolean isEditing, 
            String ageText, 
            String weightText, 
            String sizeText, 
            String sufferingText, 
            String nameText, 
            String lastNamesText, 
            String phoneText
    ) {
        this.patientManager = patientManager;
        this.isEditing = isEditing;
        this.setTextFieldsText(ageText, weightText, sizeText, sufferingText, nameText, lastNamesText, phoneText);
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
        this.frame.add(this.patientFormTitle);
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
        this.frame.add(this.phoneNumberLabel);
        this.frame.add(this.phoneNumberTextField);
        this.frame.add(this.patientFormActionButton);
    }
    
    private void constructLabels() {
        this.patientFormTitle.setText(isEditing ? UPDATE_TEXT : ADD_PATIENT);
        this.patientFormTitle.setBounds(200, 25, 140, 25);
        this.ageLabel.setBounds(125, 75, 140, 25);
        this.weightLabel.setBounds(125, 150, 140, 25);
        this.sizeLabel.setBounds(125, 225, 140, 25);
        this.sufferingLabel.setBounds(125, 300, 140, 25);
        this.nameLabel.setBounds(125, 375, 140, 25);
        this.lastNamesLabel.setBounds(125, 450, 140, 25);
        this.phoneNumberLabel.setBounds(125, 525, 140, 25);
    }
    
    private void constructTextFields() {
        this.ageTextField.setBounds(125, 100, 180, 25);
        this.weightTextField.setBounds(125, 175, 180, 25);
        this.sizeTextField.setBounds(125, 250, 180, 25);
        this.sufferingTextField.setBounds(125, 325, 180, 25);        
        this.nameTextField.setBounds(125, 400, 180, 25);        
        this.lastNamesTextField.setBounds(125, 475, 180, 25);          
        this.phoneNumberTextField.setBounds(125, 550, 180, 25);          
    }
    
    private void constructButton() {
        this.patientFormActionButton.setText(isEditing ? UPDATE_TEXT : ADD_PATIENT);
        this.patientFormActionButton.setBounds(150, 625, 200, 25);
        this.patientFormActionButton.setFocusable(false);
        this.patientFormActionButton.addActionListener(this);       
    }
    
    private void setTextFieldsText(
            String ageText, 
            String weightText, 
            String sizeText, 
            String sufferingText, 
            String nameText, 
            String lastNamesText, 
            String phoneText
    ) {
        this.ageTextField.setText(ageText);
        this.weightTextField.setText(weightText);
        this.sizeTextField.setText(sizeText);
        this.sufferingTextField.setText(sufferingText);
        this.nameTextField.setText(nameText);
        this.lastNamesTextField.setText(lastNamesText);
        this.phoneNumberTextField.setText(phoneText);
    }

    private void didTapOnPatientActionButton(ActionEvent event) {
        if (event.getSource() == this.patientFormActionButton) {
            String ageText = this.ageTextField.getText();
            String weightText = this.weightTextField.getText();
            String sizeText = this.sizeTextField.getText();
            String sufferingText = this.sufferingTextField.getText();
            String nameText = this.nameTextField.getText();
            String lastNamesText = this.lastNamesTextField.getText();
            String phoneNumberText = this.phoneNumberTextField.getText();
            if (isEditing) {
                this.patientManager.updatePatient(
                        0, 
                        Integer.parseInt(ageText), 
                        Float.parseFloat(weightText), 
                        Float.parseFloat(sizeText), 
                        sufferingText,
                        nameText, 
                        lastNamesText,
                        phoneNumberText
                );
            } else {
                this.patientManager.createPatient(
                        Integer.parseInt(ageText), 
                        Float.parseFloat(weightText), 
                        Float.parseFloat(sizeText), 
                        sufferingText,
                        nameText, 
                        lastNamesText, 
                        phoneNumberText
                );
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnPatientActionButton(e);
    }
}
