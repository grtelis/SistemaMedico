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
public class HospitalForm implements ActionListener {

    JFrame frame = new JFrame();
    JLabel hospitalFormTitle = new JLabel();
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel typeLabel = new JLabel(TYPE_LABEL);
    JTextField nameTextField = new JTextField();
    JTextField typeTextField = new JTextField();
    JButton hospitalFormActionButton = new JButton(ADD_HOSPITAL);
            
    HospitalManager hospitalManager;    
    
    boolean isEditing;
    
    HospitalForm(HospitalManager hospitalManager, boolean isEditing, String nameText, String typeText) {
        this.hospitalManager = hospitalManager;
        this.isEditing = isEditing;
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
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.hospitalFormTitle);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.typeLabel);
        this.frame.add(this.typeTextField);
        this.frame.add(this.typeTextField);
        this.frame.add(this.hospitalFormActionButton);
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
    }        
    
    private void didTapOnHospitalFormActionButton(ActionEvent event) {
        String nameText = this.nameTextField.getText();
        String typeText = this.typeTextField.getText();
        if(event.getSource() == this.hospitalFormActionButton) {
            if (isEditing) {
                this.hospitalManager.updateHospital(0, nameText, typeText);
            } else {
                this.hospitalManager.createHospital(nameText, typeText);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnHospitalFormActionButton(e);
    }
}
