package views;

import static sistemamedico.Constants.ADD_TEXT;
import static sistemamedico.Constants.SEARCH_LABEL;
import static sistemamedico.Constants.SEARCH_TEXT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.DoctorDatabase;
import database.HospitalDatabase;
import database.MedicalStudyDatabase;
import database.PatientDatabase;
import database.PersonDatabase;
import forms.DoctorForm;
import forms.HospitalForm;
import forms.MedicalStudyForm;
import forms.PatientForm;
import models.DoctorDataBaseModel;
import models.HospitalDataBaseModel;
import models.MedicalStudyDataBaseModel;
import models.PatientDataBaseModel;
import models.PersonDataBaseModel;
import sistemamedico.ResultType;
import sistemamedico.ResultsFactory;


public class ResultsViewController implements ActionListener {

    JFrame frame = new JFrame();
    JLabel resultsTitle = new JLabel();
    JLabel searchLabel = new JLabel(SEARCH_LABEL);
    JTextField searchTextField = new JTextField();
    JButton addButton = new JButton(ADD_TEXT);
    JButton searchButton = new JButton(SEARCH_TEXT);

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
        this.frame.setSize(710, 210);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
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
        if (event.getSource() == this.addButton) {

            switch (currentType) {
            case DOCTOR -> {
                new DoctorForm(false, 0, "", "", "", "", 0);
                break;
            }
            case PATIENT -> {
                new PatientForm(false, 0, "", "", "", "", "0", "", "", "");
                break;
            }

            case HOSPITAL -> {
                new HospitalForm(false, 0, "", "");
            }

            case MEDICAL_STUDY -> {
                new MedicalStudyForm(false, 0, "", "", "");
                break;
            }
            }
        }
    }

    private void didTapOnSearchButton(ActionEvent event) {

        if (event.getSource() == this.searchButton) {
            String searchButtonText = this.searchTextField.getText();

            switch (currentType) {
            case DOCTOR -> {
                DoctorDatabase doctorDB = new DoctorDatabase();
                DoctorDataBaseModel doctor = doctorDB.fetchDoctor(Integer.parseInt(searchButtonText));
                PersonDatabase personDB = new PersonDatabase();
                PersonDataBaseModel person = personDB.fetchPerson(doctor.getPersona_id());
                if (doctor != null) {
                    new DoctorForm(true, doctor.getId(), doctor.getCedula(), person.getNombre(), person.getApellidos(),
                            person.getTelefono(), doctor.getHospital_id());
                }
                break;
            }
            case PATIENT -> {
                PatientDatabase patientDB = new PatientDatabase();
                PatientDataBaseModel patient = patientDB.fetchPatient(Integer.parseInt(searchButtonText));
                PersonDatabase personDB = new PersonDatabase();
                PersonDataBaseModel person = personDB.fetchPerson(patient.getPersonaId());
                if (patient != null) {
                    new PatientForm(true, patient.getId(), String.valueOf(patient.getEdad()),
                            String.valueOf(patient.getPeso()), String.valueOf(patient.getTalla()),
                            String.valueOf(patient.getPadecimiento()), String.valueOf(patient.getNumEstudios()),
                            String.valueOf(person.getNombre()), String.valueOf(person.getApellidos()),
                            String.valueOf(person.getTelefono()));
                }
                break;
            }

            case HOSPITAL -> {
                HospitalDatabase hospitalDB = new HospitalDatabase();
                HospitalDataBaseModel hospital = hospitalDB.fetchHospital(Integer.parseInt(searchButtonText));
                if (hospital != null) {
                    new HospitalForm(true, hospital.getId(), hospital.getNombre(), hospital.getTipo());
                }
                break;
            }

            case MEDICAL_STUDY -> {
                MedicalStudyDatabase medicalStudyDB = new MedicalStudyDatabase();
                MedicalStudyDataBaseModel medicalStudy = medicalStudyDB
                        .fetchMedicalStudy(Integer.parseInt(searchButtonText));
                if (medicalStudy != null) {
                    new MedicalStudyForm(true, medicalStudy.getId(), String.valueOf(medicalStudy.getTipoEstudio()),
                            String.valueOf(medicalStudy.getFechaEstudio()),
                            String.valueOf(medicalStudy.getPacienteId()));
                }
                break;
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
