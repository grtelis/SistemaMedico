package sistemamedico;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Hernández
 */
public class ResultsViewController {
    
    JFrame frame = new JFrame();
    JLabel resultsTitle = new JLabel();
    ResultsFactory resultsFactory;
    
    ResultsViewController(ResultType type) {
        this.resultsFactory = new ResultsFactory(type);
        this.constructLabels();
        this.addComponentsToMainFrame();
        this.constructMainFrame();        
    }
    
    private void constructMainFrame() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1000, 14000);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
    
    private void addComponentsToMainFrame() {
        this.frame.add(this.resultsTitle);
    }
    
    private void constructLabels() {
        this.resultsTitle = this.resultsFactory.buildResultTile();
    }
    
    
}
