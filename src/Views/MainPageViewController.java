package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.DimensionUIResource;

import static sistemamedico.Constants.*;
import sistemamedico.ResultType;

public class MainPageViewController implements ActionListener {

    JFrame frame = new JFrame();
    JLabel mainTitle = new JLabel(SYSTEM_TITLE_TEXT);
    JLabel selectOptionLabel = new JLabel(SELECT_OPTION_LABEL);
    JButton doctorsButton = new JButton(DOCTORS);
    JButton patientsButton = new JButton(PATIENTS);
    JButton hospitalsButton = new JButton(HOSPITALS);
    JButton medicalStudiesButton = new JButton(MEDICAL_STUDIES);

    JButton logOutButton = new JButton(LOG_OUT_TEXT);

    MainPageViewController() {
        this.constructButtons();
        this.constructLabels();
        this.addComponentsToMainFrame();
        this.constructMainFrame();
    }

    private void constructMainFrame() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(540, 540);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setMinimumSize(new DimensionUIResource(540, 540));
    }

    private void addComponentsToMainFrame() {
        this.frame.add(this.mainTitle);
        this.frame.add(this.logOutButton);
        this.frame.add(this.selectOptionLabel);
        this.frame.add(this.doctorsButton);
        this.frame.add(this.patientsButton);
        this.frame.add(this.hospitalsButton);
        this.frame.add(this.medicalStudiesButton);
        this.frame.add(this.logOutButton);
    }

    private void constructLabels() {
        this.mainTitle.setBounds(200, 25, 140, 25);
        this.mainTitle.setFont(new Font(null, Font.BOLD, 15));
        this.selectOptionLabel.setBounds(190, 75, 200, 25);
    }

    private void constructButtons() {
        this.doctorsButton.setBounds(165, 125, 200, 25);
        this.doctorsButton.setFocusable(false);
        this.doctorsButton.addActionListener(this);
        this.patientsButton.setBounds(165, 175, 200, 25);
        this.patientsButton.setFocusable(false);
        this.patientsButton.addActionListener(this);
        this.hospitalsButton.setBounds(165, 225, 200, 25);
        this.hospitalsButton.setFocusable(false);
        this.hospitalsButton.addActionListener(this);
        this.medicalStudiesButton.setBounds(165, 275, 200, 25);
        this.medicalStudiesButton.setFocusable(false);
        this.medicalStudiesButton.addActionListener(this);
        this.logOutButton.setBounds(165, 325, 200, 25);
        this.logOutButton.setFocusable(false);
        this.logOutButton.addActionListener(this);
    }

    private void didTapOnDoctorsButton(ActionEvent event) {
        if (event.getSource() == this.doctorsButton) {
            new ResultsViewController(ResultType.DOCTOR);
        }
    }

    private void didTapOnPatientsButton(ActionEvent event) {
        if (event.getSource() == this.patientsButton) {
            new ResultsViewController(ResultType.PATIENT);
        }
    }

    private void didTapOnHospitalsButton(ActionEvent event) {
        if (event.getSource() == this.hospitalsButton) {
            new ResultsViewController(ResultType.HOSPITAL);
        }
    }

    private void didTapOnMedicalStudiesButton(ActionEvent event) {
        if (event.getSource() == this.medicalStudiesButton) {
            new ResultsViewController(ResultType.MEDICAL_STUDY);
        }
    }

    private void didTapOnLogOutButton(ActionEvent event) {
        if (event.getSource() == this.logOutButton) {
            this.frame.dispose();
            new WelcomePageViewController();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.didTapOnDoctorsButton(e);
        this.didTapOnLogOutButton(e);
        this.didTapOnPatientsButton(e);
        this.didTapOnHospitalsButton(e);
        this.didTapOnMedicalStudiesButton(e);
    }



}
