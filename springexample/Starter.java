/**
 * 
 */
package springexample;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * @author marcin
 *
 */
public class Starter extends JFrame {

	/**
	 * @param args
	 */
	JPanel mainPanel;
	//JTextArea testText;
	JMenuBar menuBar;
	//JPopupMenu menuPopUp;
	
	JLabel mainFirstLabel = new JLabel("Display...");
	
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
	/* 
	 * Constructor
	 */
	public Starter(){
		super("Spring Example Starter");
		this.setPreferredSize(new Dimension(700,500));
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		menuBar = new JMenuBar();
		
		// Example Menu, E - Mnemonic
	    JMenu ExampleMenu = new JMenu("Examples");
	    ExampleMenu.setMnemonic(KeyEvent.VK_E);
	    menuBar.add(ExampleMenu);
		
	    // done with menu creation, set it !s
	    setJMenuBar(menuBar);
	    
	    // Adding label, giving some hard-coded info.
	    addcomponent(mainPanel, mainFirstLabel, 0,0,1,1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH);
	    
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}// end of constructor
	
	public static void main(String[] args) {
		Starter starter = new Starter();

	}

}
