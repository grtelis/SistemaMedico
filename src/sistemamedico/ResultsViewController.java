package sistemamedico;

import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Hernández
 */
public class ResultsViewController {
    
    JFrame frame = new JFrame();
    JLabel resultsTitle = new JLabel();
    JTextField searchTextField = new JTextField();
    ResultsFactory resultsFactory;
    
    ResultsViewController(ResultType type) {
        this.resultsFactory = new ResultsFactory(type);
        this.constructInterface();
        this.addComponentsToMainFrame();
        this.constructMainFrame();        
    }
    
    private void constructMainFrame() {        
        this.frame.setSize(1000, 14000);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.resultsTitle);
    }
    
    private void constructInterface() {
        this.resultsTitle = this.resultsFactory.buildResultTile();
        this.searchTextField = new JTextField();
    }
    
    
}
