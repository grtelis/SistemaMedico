package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.HospitalDatabase;
import models.HospitalDataBaseModel;

import static sistemamedico.Constants.*;


public class HospitalForm implements ActionListener {

    JFrame frame = new JFrame();
    JLabel hospitalFormTitle = new JLabel();
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel typeLabel = new JLabel(TYPE_LABEL);
    JTextField nameTextField = new JTextField();
    JTextField typeTextField = new JTextField();
    JButton hospitalFormActionButton = new JButton(ADD_HOSPITAL);   
    JButton deleteButton = new JButton(DELETE_TEXT);                 

    boolean isEditing;
    int hospitalId;
    
    public HospitalForm(boolean isEditing, int hospitalId, String nameText, String typeText) {
        this.isEditing = isEditing;
        this.hospitalId = hospitalId;
        this.setTextFieldsTexts(nameText, typeText);
        this.constructButton();
        this.constructTextFields();
        this.constructLabels();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }       
    
    private void constructMainFrame() {
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.hospitalFormTitle);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.typeLabel);
        this.frame.add(this.typeTextField);
        this.frame.add(this.typeTextField);
        this.frame.add(this.hospitalFormActionButton);
        this.frame.add(this.deleteButton);
    }
    
    private void constructLabels() {
        this.hospitalFormTitle.setText(isEditing ? UPDATE_TEXT : ADD_HOSPITAL);
        this.hospitalFormTitle.setBounds(200, 25, 140, 25);
        this.nameLabel.setBounds(125, 100, 180, 25);  
        this.typeLabel.setBounds(125, 175, 180, 25);  
    }
    
    private void constructTextFields() {
        this.nameTextField.setBounds(125, 125, 180, 25);                
        this.typeTextField.setBounds(125, 200, 180, 25);                
    }
    
    private void setTextFieldsTexts(String nameText, String typeText) {        
        this.nameTextField.setText(nameText);
        this.typeTextField.setText(typeText);                                
    }
    
    private void constructButton() {
        this.hospitalFormActionButton.setText(isEditing ? UPDATE_TEXT : ADD_HOSPITAL);
        this.hospitalFormActionButton.setBounds(150, 250, 200, 25);
        this.hospitalFormActionButton.setFocusable(false);
        this.hospitalFormActionButton.addActionListener(this);    
        this.deleteButton.setBounds(150, 300, 200, 25);  
        this.deleteButton.setFocusable(false);
        this.deleteButton.addActionListener(this);        
        this.deleteButton.setVisible(isEditing ? true : false);
    }        
    
    private void didTapOnHospitalFormActionButton(ActionEvent event) {
        String nameText = this.nameTextField.getText();
        String typeText = this.typeTextField.getText();
        HospitalDatabase hospitalDB = new HospitalDatabase();

        if(event.getSource() == this.hospitalFormActionButton) {
            if (isEditing) {
                HospitalDataBaseModel hospital = hospitalDB.updateHospital(hospitalId, nameText, typeText);
                this.setTextFieldsTexts(hospital.getNombre(), hospital.getTipo());                
            } else {
                hospitalDB.createHospital(nameText, typeText);
            }
        }
    }

    private void didTapOnDeleteButton(ActionEvent event) {
        if (event.getSource() == this.deleteButton) {
            HospitalDatabase hospitalDB = new HospitalDatabase();
            hospitalDB.deleteHospital(hospitalId);
            this.frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnHospitalFormActionButton(e);
        this.didTapOnDeleteButton(e);
    }
}
