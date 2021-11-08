package sistemamedico;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */
public class ResultsFactory {
    
    ResultType resultType;
    JLabel titleLabel = new JLabel();
    JTextField searchTextField = new JTextField();
    
    ResultsFactory(ResultType type) {
        this.resultType = type;
        this.constructTitleLabel();
    }
        
    private void constructTitleLabel() {
        this.titleLabel.setBounds(25, 25, 350, 35);
        this.titleLabel.setFont(new Font(null, Font.BOLD, 35));
    }
    
    private void constructSearchTextField() {
        this.searchTextField.setBounds(25, 100, 800, 35);
    }
    
    public JLabel buildResultTile() {
        
        switch(resultType) {
            case DOCTOR -> {                
                this.titleLabel.setText(DOCTORS);
                return this.titleLabel;
            }
            case PATIENT -> {
                this.titleLabel.setText(PATIENTS);
                return this.titleLabel;
            }   
            
            case HOSPITAL -> {
                this.titleLabel.setText(HOSPITALS);
                return this.titleLabel;
            }
            
            case MEDICAL_STUDY -> {
                this.titleLabel.setText(MEDICAL_STUDIES);
                return this.titleLabel;                
            }                        
        }
        
        return new JLabel();
    }
    
}
