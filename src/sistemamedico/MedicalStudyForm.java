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
public class MedicalStudyForm implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel medicalStudyTitle = new JLabel();
    JLabel typeLabel = new JLabel(STUDY_TYPE_LABEL);
    JLabel dateLabel = new JLabel(STUDY_DATE_LABEL);
    JTextField typeTextField = new JTextField();
    JTextField dateTextField = new JTextField();
    JButton medicalStudyActionButton = new JButton();
    
    MedicalSudyManager medicalSudyManager;
    
    boolean isEditing;
    
    MedicalStudyForm(MedicalSudyManager medicalSudyManager, boolean isEditing, String typeText, String dateText) {
        this.medicalSudyManager = medicalSudyManager;
        this.isEditing = isEditing;
        this.constructTextFields();
        this.constructLabels();
        this.constructButton();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }
    
    private void constructMainFrame() {
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame.setVisible(true);        
    }        
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.medicalStudyTitle);
        this.frame.add(this.medicalStudyActionButton);
        this.frame.add(this.typeLabel);
        this.frame.add(this.typeTextField);
        this.frame.add(this.dateLabel);
        this.frame.add(this.dateTextField);        
    }
    
    private void constructLabels() {
        this.medicalStudyTitle.setText(isEditing ? UPDATE_TEXT : ADD_MEDICAL_STUDY);
        this.medicalStudyTitle.setBounds(200, 25, 180, 25);
        this.typeLabel.setBounds(125, 75, 140, 25);
        this.dateLabel.setBounds(125, 155, 140, 25);
    }
    
    private void constructTextFields() {
        this.typeTextField.setBounds(125, 100, 180, 25);
        this.dateTextField.setBounds(125, 175, 180, 25);        
    }
    
    private void constructButton() {
        this.medicalStudyActionButton.setText(isEditing ? UPDATE_TEXT : ADD_MEDICAL_STUDY);
        this.medicalStudyActionButton.setBounds(150, 225, 180, 25);
    }
    
    private void setTextFieldsTexts(String typeText, String dateText) {
        this.typeTextField.setText(typeText);
        this.dateTextField.setText(dateText);
    }

    private void didTapOnMedicalStudyActionButton(ActionEvent event) {
        if (event.getSource() == this.medicalStudyActionButton) {
            String typeText = this.typeTextField.getText();
            String dateText = this.dateTextField.getText();
            if (isEditing) {
                this.medicalSudyManager.updateMedicalStudy(0, typeText, dateText, 0);
            } else {
                this.medicalSudyManager.createMedicalStudy(typeText, dateText, 0);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnMedicalStudyActionButton(e);
    }
    
}
