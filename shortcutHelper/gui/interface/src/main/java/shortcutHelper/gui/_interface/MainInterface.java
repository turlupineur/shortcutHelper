package shortcutHelper.gui._interface;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainInterface extends JFrame{
	
	//*****************************************************************
	/**
	 * Config
	 */
	private static final int HEIGHT = 65;
	
	private static final int WIDTH = 250;
	
	private static final String TITLE = "ShortcutHelper";
	//*****************************************************************
	
	private JTextField textFieldCommand;
	
	public MainInterface()
	{
		textFieldCommand = new JTextField();
		init();
	}
	
	private void init()
	{
		setSize(WIDTH, HEIGHT);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		setTitle(TITLE);
		add(textFieldCommand);
		addClosingEvent();
		
		setVisible(true);
	}
	
	
	private void addClosingEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
			    System.exit(0);
			  }
			});
	}
}
