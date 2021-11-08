package sistemamedico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */
public class MedicalStudyForm {
    
    JFrame frame = new JFrame();
    JLabel medicalStudyTitle = new JLabel(ADD_MEDICAL_STUDY);
    JLabel typeLabel = new JLabel(STUDY_TYPE_LABEL);
    JLabel dateLabel = new JLabel(STUDY_DATE_LABEL);
    JTextField typeTextField = new JTextField();
    JTextField dateTextField = new JTextField();
    JButton medicalStudyActionButton = new JButton(ADD_MEDICAL_STUDY);
    
    MedicalStudyForm() {
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
        this.medicalStudyTitle.setBounds(200, 25, 180, 25);
        this.typeLabel.setBounds(125, 75, 140, 25);
        this.dateLabel.setBounds(125, 155, 140, 25);
    }
    
    private void constructTextFields() {
        this.typeTextField.setBounds(125, 100, 180, 25);
        this.dateTextField.setBounds(125, 175, 180, 25);        
    }
    
    private void constructButton() {
        this.medicalStudyActionButton.setBounds(150, 225, 180, 25);
    }
    
}
