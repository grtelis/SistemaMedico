package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.DoctorDatabase;
import database.PersonDatabase;
import models.DoctorDataBaseModel;
import models.PersonDataBaseModel;

import static sistemamedico.Constants.*;

public class DoctorForm implements ActionListener {

    JFrame frame = new JFrame();
    JLabel doctorFormTitle = new JLabel();
    JLabel identificationCard = new JLabel(IDENTIFICATION_CARD_LABEL);
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel lastNamesLabel = new JLabel(LAST_NAMES_LABEL);
    JLabel phoneLabel = new JLabel(PHONE_NUMBER_LABEL);
    JLabel hospitalIdLabel = new JLabel("Id del hospital");
    JTextField identificationCardTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField lastNamesTextField = new JTextField();
    JTextField phoneTextField = new JTextField();
    JTextField hospitalIdTextField = new JTextField();
    JButton doctorFormActionButton = new JButton();
    JButton deleteButton = new JButton(DELETE_TEXT);

    boolean isEditing;
    int doctorId;

    public DoctorForm(boolean isEditing, int doctorId, String identificationCardText, String nameText,
            String lastNamesText, String phoneText, int hospitalId) {
        this.isEditing = isEditing;
        this.doctorId = doctorId;
        this.setTextFieldsText(identificationCardText, nameText, lastNamesText, phoneText, String.valueOf(hospitalId));
        this.constructTextFields();
        this.constructButton();
        this.constructLabels();
        this.addComponents();
        this.constructMainFrame();
    }

    DoctorForm() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void constructMainFrame() {
        this.frame.setSize(500, 600);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
    }

    private void addComponents() {
        this.frame.add(this.doctorFormTitle);
        this.frame.add(this.nameLabel);
        this.frame.add(this.lastNamesLabel);
        this.frame.add(this.identificationCard);
        this.frame.add(this.identificationCardTextField);
        this.frame.add(this.nameLabel);
        this.frame.add(this.nameTextField);
        this.frame.add(this.lastNamesTextField);
        this.frame.add(this.doctorFormActionButton);
        this.frame.add(this.phoneLabel);
        this.frame.add(this.phoneTextField);
        this.frame.add(this.hospitalIdLabel);
        this.frame.add(this.hospitalIdTextField);
        this.frame.add(this.deleteButton);
    }

    private void constructLabels() {
        this.doctorFormTitle.setText(isEditing ? UPDATE_TEXT : ADD_DOCTOR);
        this.doctorFormTitle.setBounds(200, 25, 140, 25);
        this.identificationCard.setBounds(125, 75, 140, 25);
        this.nameLabel.setBounds(125, 150, 140, 25);
        this.lastNamesLabel.setBounds(125, 225, 140, 25);
        this.phoneLabel.setBounds(125, 300, 140, 25);
        this.hospitalIdLabel.setBounds(125, 375, 140, 25);
    }

    private void constructTextFields() {
        this.identificationCardTextField.setBounds(125, 100, 180, 25);
        this.nameTextField.setBounds(125, 175, 180, 25);
        this.lastNamesTextField.setBounds(125, 250, 180, 25);
        this.phoneTextField.setBounds(125, 325, 180, 25);
        this.hospitalIdTextField.setBounds(125, 400, 140, 25);
    }

    private void constructButton() {
        this.doctorFormActionButton.setText(isEditing ? UPDATE_TEXT : ADD_DOCTOR);
        this.doctorFormActionButton.setBounds(150, 450, 200, 25);
        this.doctorFormActionButton.setFocusable(false);
        this.doctorFormActionButton.addActionListener(this);
        this.deleteButton.setBounds(150, 500, 200, 25);
        this.deleteButton.setFocusable(false);
        this.deleteButton.addActionListener(this);
        this.deleteButton.setVisible(isEditing ? true : false);
    }

    private void setTextFieldsText(String identificationCardText, String nameText, String lastNamesText,
            String phoneText, String hospitalId) {

        this.identificationCardTextField.setText(identificationCardText);
        this.nameTextField.setText(nameText);
        this.lastNamesTextField.setText(lastNamesText);
        this.phoneTextField.setText(phoneText);
        this.hospitalIdTextField.setText(hospitalId);
    }

    private void didTapOnDoctorFormActionButton(ActionEvent event) {
        String identificationCardText = this.identificationCardTextField.getText();
        String nameText = this.nameTextField.getText();
        String lastNamesText = this.lastNamesTextField.getText();
        String phoneText = this.phoneTextField.getText();
        String hospitalIdText = this.hospitalIdTextField.getText();

        if (event.getSource() == this.doctorFormActionButton) {
            DoctorDatabase doctorDB = new DoctorDatabase();
            PersonDatabase personDB = new PersonDatabase();
            if (isEditing) {
                DoctorDataBaseModel doctor = doctorDB.updateDoctor(doctorId, nameText, lastNamesText, phoneText,
                        identificationCardText, Integer.parseInt(hospitalIdText));
                PersonDataBaseModel person = personDB.fetchPerson(doctor.getPersona_id());
                this.setTextFieldsText(doctor.getCedula(), person.getNombre(), person.getApellidos(),
                        person.getTelefono(), String.valueOf(doctor.getHospital_id()));
            } else {
                doctorDB.insertDoctor(identificationCardText, nameText, lastNamesText, phoneText,
                        Integer.parseInt(hospitalIdText));
            }
        }
    }

    private void didTapOnDeleteButton(ActionEvent event) {
        if (event.getSource() == this.deleteButton) {
            DoctorDatabase doctorDB = new DoctorDatabase();
            DoctorDataBaseModel doctor = doctorDB.fetchDoctor(doctorId);
            PersonDatabase personaDB = new PersonDatabase();
            personaDB.deletePerson(doctor.getPersona_id());
            this.frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnDoctorFormActionButton(e);
        this.didTapOnDeleteButton(e);
    }



}
