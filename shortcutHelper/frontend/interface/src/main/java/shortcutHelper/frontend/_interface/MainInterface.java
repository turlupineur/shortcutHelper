package shortcutHelper.frontend._interface;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;

import shortcutHelper.frontend._interface.autosuggestion.SuggestionDropDownDecorator;
import shortcutHelper.frontend._interface.autosuggestion.TextComponentSuggestionClient;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;


public class MainInterface extends JFrame implements Observer{
	private MainInterfaceViewBean mainInterfaceViewBean;
	private Observer observerEvent;
	
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
	
	private TextComponentSuggestionClient componentSuggestionClient;
	
	public MainInterface(Observer observerEvent)
	{
		textFieldCommand = new JTextField();
		mainInterfaceViewBean = new MainInterfaceViewBean();
		this.observerEvent = observerEvent;
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
	}
	
	
	
	public void updateView(MainInterfaceViewBean viewBean)
	{
		this.mainInterfaceViewBean = viewBean;
		mapViewBeanToView();
	}
	
	private void mapViewBeanToView()
	{
		this.textFieldCommand.setText(this.mainInterfaceViewBean.getDataBean().getCalledShortcut());
	}
	
	private void configureSuggestionDropdown() {
		this.componentSuggestionClient =  new TextComponentSuggestionClient(mainInterfaceViewBean.getDataBean().getListShortcuts(),MAX_DISPLAYED_RESULTS_SUGGESTION);
		SuggestionDropDownDecorator.decorate(textFieldCommand,
	              componentSuggestionClient,this);
	}

	private void addClosingEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
			    System.exit(0);
			  }
			});
	}

	// event submit shortcut.
	@Override
	public void update(Observable arg0, Object calledShortcut) {
		this.mainInterfaceViewBean.getDataBean().setCalledShortcut(calledShortcut.toString());
		this.observerEvent.update(arg0, this.mainInterfaceViewBean);
		System.out.println("update");
	}
}
