/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico;

import javax.swing.JLabel;
import static sistemamedico.Constants.*;

/**
 *
 * @author Carlos Hernández
 */
public class ResultsFactory {
    
    ResultType resultType;
    JLabel titleLabel = new JLabel();
    
    ResultsFactory(ResultType type) {
        this.resultType = type;
    }
    
    public JLabel buildResultTile() {
        
        switch(resultType) {
            case DOCTOR -> {
                this.titleLabel.setBounds(25, 25, 200, 35);
                this.titleLabel.setText(DOCTORS);
                return this.titleLabel;
            }
        }
        
        return new JLabel("Holaaaaaaaa");
    }
    
}
