package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.MedicalStudyDatabase;
import models.MedicalStudyDataBaseModel;

import static sistemamedico.Constants.*;

public class MedicalStudyForm implements ActionListener {

    JFrame frame = new JFrame();
    JLabel medicalStudyTitle = new JLabel();
    JLabel typeLabel = new JLabel(STUDY_TYPE_LABEL);
    JLabel dateLabel = new JLabel(STUDY_DATE_LABEL);
    JLabel idPatientLabel = new JLabel(PATIENT_ID_TEXT);
    JTextField typeTextField = new JTextField();
    JTextField dateTextField = new JTextField();
    JTextField idPatientField = new JTextField();
    JButton medicalStudyActionButton = new JButton();
    JButton deleteMedicalStudyButton = new JButton(DELETE_TEXT);

    boolean isEditing;
    int medicalStudyId;

    public MedicalStudyForm(boolean isEditing, int medicalStudyId, String typeText, String dateText, String idPatient) {
        this.isEditing = isEditing;
        this.medicalStudyId = medicalStudyId;
        this.setTextFieldsTexts(typeText, dateText, idPatient);
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
        this.frame.setLocationRelativeTo(null);
    }

    private void addComponentsToMainFrame() {
        this.frame.add(this.medicalStudyTitle);
        this.frame.add(this.medicalStudyActionButton);
        this.frame.add(this.typeLabel);
        this.frame.add(this.typeTextField);
        this.frame.add(this.dateLabel);
        this.frame.add(this.dateTextField);
        this.frame.add(this.idPatientLabel);
        this.frame.add(this.idPatientField);
        this.frame.add(this.deleteMedicalStudyButton);
    }

    private void constructLabels() {
        this.medicalStudyTitle.setText(isEditing ? UPDATE_TEXT : ADD_MEDICAL_STUDY);
        this.medicalStudyTitle.setBounds(200, 25, 180, 25);
        this.typeLabel.setBounds(125, 75, 140, 25);
        this.dateLabel.setBounds(125, 155, 140, 25);
        this.idPatientLabel.setBounds(125, 225, 140, 25);
    }

    private void constructTextFields() {
        this.typeTextField.setBounds(125, 100, 180, 25);
        this.dateTextField.setBounds(125, 175, 180, 25);
        this.idPatientField.setBounds(125, 250, 180, 25);
    }

    private void constructButton() {
        this.medicalStudyActionButton.setText(isEditing ? UPDATE_TEXT : ADD_MEDICAL_STUDY);
        this.medicalStudyActionButton.setBounds(150, 300, 180, 25);
        this.medicalStudyActionButton.setFocusable(false);
        this.medicalStudyActionButton.addActionListener(this);
        this.deleteMedicalStudyButton.setBounds(150, 350, 180, 25);
        this.deleteMedicalStudyButton.setFocusable(false);
        this.deleteMedicalStudyButton.addActionListener(this);
        this.deleteMedicalStudyButton.setVisible(isEditing ? true : false);
    }

    private void setTextFieldsTexts(String typeText, String dateText, String idPatient) {
        this.typeTextField.setText(typeText);
        this.dateTextField.setText(dateText);
        this.idPatientField.setText(idPatient);
    }

    private void didTapOnMedicalStudyActionButton(ActionEvent event) {
        if (event.getSource() == this.medicalStudyActionButton) {
            String typeText = this.typeTextField.getText();
            String dateText = this.dateTextField.getText();
            String idPatient = this.idPatientField.getText();
            MedicalStudyDatabase medicalStudyDB = new MedicalStudyDatabase();
            if (isEditing) {
                MedicalStudyDataBaseModel medicalStudy = medicalStudyDB.updateMedicalStudy(medicalStudyId, typeText, dateText,
                        Integer.parseInt(idPatient));
                this.setTextFieldsTexts(medicalStudy.getTipoEstudio(

                ), medicalStudy.getFechaEstudio(), String.valueOf(medicalStudy.getPacienteId()));
            } else {
                medicalStudyDB.createMedicalStudy(typeText, dateText, Integer.parseInt(idPatient));
            }
        }
    }

    private void didTapOnDeleteMedicalStudyButton(ActionEvent event) {
        if (event.getSource() == this.deleteMedicalStudyButton) {
            MedicalStudyDatabase medicalStudyDB = new MedicalStudyDatabase();
            medicalStudyDB.deleteMedicalStudy(medicalStudyId);
            this.frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnMedicalStudyActionButton(e);
        this.didTapOnDeleteMedicalStudyButton(e);
    }

}
