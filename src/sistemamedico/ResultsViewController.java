package sistemamedico;

import java.awt.TextField;
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
public class ResultsViewController implements ActionListener {
    
    JFrame frame = new JFrame();
    JLabel resultsTitle = new JLabel();
    JLabel searchLabel = new JLabel(SEARCH_LABEL);
    JTextField searchTextField = new JTextField();
    JButton addButton = new JButton("Añadir");
    ResultType currentType;
    ResultsFactory resultsFactory;
    
    ResultsViewController(ResultType type) {
        this.currentType = type;
        this.resultsFactory = new ResultsFactory(type);
        this.constructInterface();
        this.addComponentsToMainFrame();
        this.constructMainFrame();        
    }
    
    private void constructMainFrame() {        
        this.frame.setSize(1000, 20000);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.resultsTitle);
        this.frame.add(this.searchLabel);
        this.frame.add(this.searchTextField);
        this.frame.add(this.addButton);
    }
    
    private void constructInterface() {
        this.resultsTitle = this.resultsFactory.buildResultTile();
        this.searchLabel.setBounds(25, 100, 200, 20);
        this.searchTextField.setBounds(25, 125, 500, 20);
        this.addButton.setBounds(550, 125, 200, 20);
        this.addButton.setFocusable(false);
        this.addButton.addActionListener(this);
    }

    
    private void didTapOnAddButton(ActionEvent event) {                        
        if(event.getSource() == this.addButton) {
            
            switch(currentType) {
                case DOCTOR -> {
                    AddDoctorForm addDoctorForm = new AddDoctorForm();
                }
                case PATIENT -> {
                    AddPatientForm addPatientForm = new AddPatientForm();
                } 
                
                case HOSPITAL -> {
                    HospitalForm hospitalForm = new HospitalForm();
                } 
                
                case MEDICAL_STUDY -> {
                    MedicalStudyForm medicalStudyForm = new MedicalStudyForm();
                }
            }
            
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnAddButton(e);
    }            
}
