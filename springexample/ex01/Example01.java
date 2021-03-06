package springexample.ex01;

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
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.*;

public class Example01 extends JFrame {
	JPanel mainPanel;
	JTextArea jta;
	JLabel mainFirstLabel = new JLabel("Example 01\nFactoryBean usage, property tag, ...");
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
public Example01(final String pathToApp, final String pathToExample){
	super("Spring Example - Example 01");
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
    		//
    		//System.out.println("Button start marker...");
    		//Triangle triangle = new Triangle();
    		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(pathToApp + pathToExample + "spring.xml"));
    		
    		Triangle triangle = (Triangle) factory.getBean("triangle");
    		triangle.draw();
    		//System.out.println("Path is:"+pathToExample);
    		
    		Triangle triangle1 = (Triangle) factory.getBean("triangle1");
    		triangle1.draw();
        }
    });
	addcomponent(mainPanel, jButtonStart, 1,0,1,1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH);
	
	// Notepad++
	
	
	
    
	this.add(mainPanel);
	this.pack();
	this.setVisible(true);
	
}// end of Constructor

public void printSomething(){
	System.out.println("Printing something... just to check if this console works.");
}

}// end of class Example01

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

///////////////////////////////////
// Code for button notepad++
/*
String cmds[] = new String[] { "cmd", "/c","C:\Test.txt" };
Runtime.getRuntime().exec(cmds);

oraz:
{ "cmd", "/c","notepad++ C:\Test.txt" };
lub
{ "cmd", "/c","fullpath-to-notepad++.exe C:\Test.txt" };
*/
	
