package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.PatientDatabase;
import database.PersonDatabase;
import models.PatientDataBaseModel;
import models.PersonDataBaseModel;

import static sistemamedico.Constants.*;

public class PatientForm implements ActionListener {

    JFrame frame = new JFrame();
    JLabel patientFormTitle = new JLabel();
    JLabel ageLabel = new JLabel(AGE_LABEL); // ONLY NUMBERS
    JLabel weightLabel = new JLabel(WEIGHT_LABEL); // ONLY NUMBERS
    JLabel sizeLabel = new JLabel(SIZE_LABEL); // ONLY NUMBERS
    JLabel sufferingLabel = new JLabel(SUFFERING_LABEL);
    JLabel studiesNumberLabel = new JLabel(STUDIES_NUMBER_LABEL);
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneNumberLabel = new JLabel(PHONE_NUMBER_LABEL);
    JTextField ageTextField = new JTextField();
    JTextField weightTextField = new JTextField();
    JTextField sizeTextField = new JTextField();
    JTextField sufferingTextField = new JTextField();
    JTextField studiesNumberTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();
    JTextField phoneNumberTextField = new JTextField();
    JButton patientFormActionButton = new JButton();
    JButton deletePatientButton = new JButton();

    boolean isEditing;
    int patientId;

    public PatientForm(boolean isEditing, int patientId, String ageText, String weightText, String sizeText,
            String sufferingText, String studiesNumberText, String nameText, String lastNamesText, String phoneText) {
        this.patientId = patientId;
        this.isEditing = isEditing;
        this.setTextFieldsText(ageText, weightText, sizeText, sufferingText, studiesNumberText, nameText, lastNamesText,
                phoneText);
        this.constructButton();
        this.constructTextFields();
        this.constructLabels();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }

    private void constructMainFrame() {
        this.frame.setSize(500, 900);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
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
        this.frame.add(this.studiesNumberLabel);
        this.frame.add(this.studiesNumberTextField);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.lastNamesLabel);
        this.frame.add(this.lastNamesTextField);
        this.frame.add(this.phoneNumberLabel);
        this.frame.add(this.phoneNumberTextField);
        this.frame.add(this.patientFormActionButton);
        this.frame.add(this.deletePatientButton);
    }

    private void constructLabels() {
        this.patientFormTitle.setText(isEditing ? UPDATE_TEXT : ADD_PATIENT);
        this.patientFormTitle.setBounds(200, 25, 140, 25);
        this.ageLabel.setBounds(125, 75, 140, 25);
        this.weightLabel.setBounds(125, 150, 140, 25);
        this.sizeLabel.setBounds(125, 225, 140, 25);
        this.sufferingLabel.setBounds(125, 300, 140, 25);
        this.studiesNumberLabel.setBounds(125, 375, 140, 25);
        this.nameLabel.setBounds(125, 450, 140, 25);
        this.lastNamesLabel.setBounds(125, 525, 140, 25);
        this.phoneNumberLabel.setBounds(125, 600, 140, 25);
    }

    private void constructTextFields() {
        this.ageTextField.setBounds(125, 100, 180, 25);
        this.weightTextField.setBounds(125, 175, 180, 25);
        this.sizeTextField.setBounds(125, 250, 180, 25);
        this.sufferingTextField.setBounds(125, 325, 180, 25);
        this.studiesNumberTextField.setBounds(125, 400, 180, 25);
        this.studiesNumberTextField.setEditable(false);
        this.nameTextField.setBounds(125, 475, 180, 25);
        this.lastNamesTextField.setBounds(125, 550, 180, 25);
        this.phoneNumberTextField.setBounds(125, 625, 180, 25);
    }

    private void constructButton() {
        this.patientFormActionButton.setText(isEditing ? UPDATE_TEXT : ADD_PATIENT);
        this.patientFormActionButton.setBounds(150, 700, 200, 25);
        this.patientFormActionButton.setFocusable(false);
        this.patientFormActionButton.addActionListener(this);
        this.deletePatientButton.setText(DELETE_TEXT);
        this.deletePatientButton.setBounds(150, 750, 200, 25);
        this.deletePatientButton.setFocusable(false);
        this.deletePatientButton.addActionListener(this);
        this.deletePatientButton.setVisible(isEditing ? true : false);
    }

    private void setTextFieldsText(String ageText, String weightText, String sizeText, String sufferingText,
            String studiesNumberText, String nameText, String lastNamesText, String phoneText) {
        this.ageTextField.setText(ageText);
        this.weightTextField.setText(weightText);
        this.sizeTextField.setText(sizeText);
        this.sufferingTextField.setText(sufferingText);
        this.studiesNumberTextField.setText(studiesNumberText);
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
            String studiesNumberText = this.studiesNumberTextField.getText();
            String nameText = this.nameTextField.getText();
            String lastNamesText = this.lastNamesTextField.getText();
            String phoneNumberText = this.phoneNumberTextField.getText();

            PatientDatabase patientDB = new PatientDatabase();
            PersonDatabase personDB = new PersonDatabase();

            if (isEditing) {
                PatientDataBaseModel patient = patientDB.updatePatient(patientId, Integer.parseInt(ageText),
                        Float.parseFloat(weightText), Float.parseFloat(sizeText), sufferingText, nameText,
                        lastNamesText, phoneNumberText);
                PersonDataBaseModel person = personDB.fetchPerson(patient.getPersonaId());
                this.setTextFieldsText(String.valueOf(patient.getEdad()), String.valueOf(patient.getPeso()),
                        String.valueOf(patient.getTalla()), patient.getPadecimiento(),
                        String.valueOf(patient.getNumEstudios()), person.getNombre(), person.getApellidos(),
                        person.getTelefono());
            } else {
                patientDB.insertPatient(nameText, lastNamesText, phoneNumberText, Integer.parseInt(ageText),
                        Float.parseFloat(weightText), Float.parseFloat(sizeText), sufferingText,
                        Integer.parseInt(studiesNumberText));
            }
        }
    }

    private void didTapOnDeleteButton(ActionEvent event) {
        if (event.getSource() == this.deletePatientButton) {
            PatientDatabase patientDB = new PatientDatabase();
            PatientDataBaseModel paciente = patientDB.fetchPatient(patientId);
            PersonDatabase persona = new PersonDatabase();
            persona.deletePerson(paciente.getPersonaId());
            this.frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnPatientActionButton(e);
        this.didTapOnDeleteButton(e);
    }
}
