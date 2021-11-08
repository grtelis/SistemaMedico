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
    JLabel hospitalFormTitle = new JLabel(ADD_HOSPITAL);
    JLabel nameLabel = new JLabel(NAME_LABEL);
    JLabel typeLabel = new JLabel(TYPE_LABEL);
    JTextField nameTextField = new JTextField();
    JTextField typeTextField = new JTextField();
    JButton addHospitalButton = new JButton(ADD_HOSPITAL);
    
    HospitalForm() {
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
        this.frame.add(this.addHospitalButton);
    }
    
    private void constructLabels() {
        this.hospitalFormTitle.setBounds(200, 25, 140, 25);
        this.nameLabel.setBounds(125, 100, 180, 25);  
        this.typeLabel.setBounds(125, 175, 180, 25);  
    }
    
    private void constructTextFields() {
        this.nameTextField.setBounds(125, 125, 180, 25);                
        this.typeTextField.setBounds(125, 200, 180, 25);                
    }
    
    private void constructButton() {
        this.addHospitalButton.setBounds(150, 250, 200, 25);
        this.addHospitalButton.setFocusable(false);
        this.addHospitalButton.addActionListener(this);      
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
        
}
