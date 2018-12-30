package shortcutHelper.gui._interface;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import shortcutHelper.gui._interface.autosuggestion.SuggestionDropDownDecorator;
import shortcutHelper.gui._interface.autosuggestion.TextComponentSuggestionClient;


public class MainInterface extends JFrame{
	
	//*****************************************************************
	/**
	 * Config (property)
	 */
	private static final int HEIGHT = 65;
	
	private static final int WIDTH = 250;
	
	private static final String TITLE = "ShortcutHelper";
	
	private static final int MAX_DISPLAYED_RESULTS_SUGGESTION = 20;
	
	/**
	 * ViewBean
	 */
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
		
		configureSuggestionDropdown();
		
		setVisible(true);
	}
	
	
	private void configureSuggestionDropdown() {
		
		List<String> words = new ArrayList<String>();
		words.add("germany.language");
		words.add("germany.coucou");
		words.add("house.kitchen");
		words.add("house.bedroom");
		words.add("house.bedroom.table");
		words.add("house.bedroom.chair");
		words.add("house.bedroom.bed");
		words.add("house.livingroom.salut.salut.salut");
		SuggestionDropDownDecorator.decorate(textFieldCommand,
	              new TextComponentSuggestionClient(words,MAX_DISPLAYED_RESULTS_SUGGESTION));
	}

	private void addClosingEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
			    System.exit(0);
			  }
			});
	}
	
	public static void main(String [] args)
	{
		MainInterface m = new MainInterface();
	}
}
