package springexample.exA04;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.*;

public class ExampleA04 extends JFrame {
	JPanel mainPanel;
	JTextArea jta;
	JLabel mainFirstLabel = new JLabel("<html>Example Adv 04 , JSR-250 Annotations"
			+ "<br />check both 'pointC' and no name in the @Resource name, the last works, cause this is the variable name is 'center', Java makes a guess here. (2) Note annotations for PostConstruct and PreDestroy</html>");
	JButton jButtonStart;
	/**
	 * Methods for the constructor
	 */
	private void addcomponent(JPanel pn, JComponent cmp, int xpos, int ypos, int w, int h, int place, int stretch){
		GridBagConstraints gridcns = new GridBagConstraints();
		gridcns.gridx = xpos;
		gridcns.gridy = ypos;
		gridcns.gridwidth = w;
		gridcns.gridheight = h;
		gridcns.weightx = 100;
		gridcns.weighty = 100;
		gridcns.insets = new Insets(5,5,5,5);
		gridcns.anchor = place;
		gridcns.fill = stretch;
		
		pn.add(cmp, gridcns);
	} // end private void addcomponent
	
// CONSTRUCTOR
public ExampleA04(final String pathToApp, final String pathToExample){
	super("Spring Example - Example Adv 01");
	this.setPreferredSize(new Dimension(700,500));
	mainPanel = new JPanel();
	mainPanel.setLayout(new GridBagLayout());
	
	
	addcomponent(mainPanel, mainFirstLabel, 0,0,1,1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH);
	
	// adding console
	JTextArea textArea = new JTextArea(50, 10);
	PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
	System.setOut(printStream);
	System.setErr(printStream);
    
	addcomponent(mainPanel, textArea, 0,1,2,10, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH);
	
	//Start
	jButtonStart = new JButton("Start example");
	jButtonStart.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		clearConsole();
    		
    		String xmlfile = "/"+pathToApp + pathToExample + "spring.xml";
    		@SuppressWarnings("resource")
    		ApplicationContext context = new FileSystemXmlApplicationContext(xmlfile);
    		
    		// asking user which shape to draw
    		String s = (String)JOptionPane.showInputDialog(
                    null,
                    "provide shape to draw: triangle? circle?",
                    "Provide shape",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
    		
    		Shape shape = (Shape) context.getBean(s);
    		shape.draw();

        }
    });
	addcomponent(mainPanel, jButtonStart, 1,0,1,1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH);
	
	// Notepad++
	
	
	
    
	this.add(mainPanel);
	this.pack();
	this.setVisible(true);
	
}// end of Constructor

// other methods

// from stackoverflow
public final static void clearConsole(){
    try{
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            Runtime.getRuntime().exec("cls");
        }else{
            Runtime.getRuntime().exec("clear");
        }
    }catch (final Exception e) {
        //  Handle any exceptions.
    }
}

}// end of class Example04

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 *
 */
class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
     
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}