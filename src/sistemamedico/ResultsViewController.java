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
    JButton addButton = new JButton(ADD_TEXT);
    JButton searchButton = new JButton(SEARCH_TEXT);
    
    ResultType currentType;
    ResultsFactory resultsFactory;
    
    DoctorManager doctorManager = new DoctorManager();
    PatientManager patientManager = new PatientManager();
    HospitalManager hospitalManager = new HospitalManager();
    MedicalSudyManager medicalStudyManager = new MedicalSudyManager();
    
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
        this.frame.add(this.searchButton);
    }
    
    private void constructInterface() {
        this.resultsTitle = this.resultsFactory.buildResultTile();
        this.searchLabel.setBounds(25, 100, 200, 20);
        this.searchTextField.setBounds(25, 125, 400, 20);
        this.addButton.setBounds(450, 125, 100, 20);
        this.addButton.setFocusable(false);
        this.addButton.addActionListener(this);
        this.searchButton.setBounds(575, 125, 100, 20);
        this.searchButton.setFocusable(false);
        this.searchButton.addActionListener(this);
    }
    
    private void didTapOnAddButton(ActionEvent event) {                        
        if(event.getSource() == this.addButton) {
            
            switch(currentType) {
                case DOCTOR -> {
                    DoctorForm addDoctorForm = new DoctorForm(this.doctorManager, false, "", "", "", "");
                }
                case PATIENT -> {
                    PatientForm addPatientForm = new PatientForm(
                            this.patientManager, 
                            false, 
                            "", 
                            "", 
                            "", 
                            "", 
                            "", 
                            "", 
                            ""
                    );
                } 
                
                case HOSPITAL -> {
                    HospitalForm hospitalForm = new HospitalForm(this.hospitalManager, false, "", "");
                } 
                
                case MEDICAL_STUDY -> {
                    MedicalStudyForm medicalStudyForm = new MedicalStudyForm(this.medicalStudyManager, false, "", "");
                }
            }                        
        }
    }
    
    private void didTapOnSearchButton(ActionEvent event) {
        if (event.getSource() == this.searchButton) {
            String searchButtonText = this.searchTextField.getText();
            switch(currentType) {
                case DOCTOR -> {
                    this.doctorManager.fetchDoctor(searchButtonText);
                }
                case PATIENT -> {
                    this.patientManager.fetchPatient(searchButtonText);
                } 
                
                case HOSPITAL -> {
                    this.hospitalManager.fetchHospital(searchButtonText);
                } 
                
                case MEDICAL_STUDY -> {
                    this.medicalStudyManager.fetchMedicalStudy(searchButtonText);
                }
            }
        }     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnAddButton(e);
        this.didTapOnSearchButton(e);
    }            
}
