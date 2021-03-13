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
import shortcutHelper.frontend._interface.toast.ToastMessage;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;
public class MainInterface extends JFrame implements Observer{
	private MainInterfaceViewBean mainInterfaceViewBean;
	private Observer controller;
	
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
	
	private boolean viewInitialized;
	
	public MainInterface()
	{
		textFieldCommand = new JTextField();
		viewInitialized = false;
		
	}
	
	public Observer getController() {
		return controller;
	}

	public void setController(Observer controller) {
		this.controller = controller;
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
		if(!viewInitialized)
		{
			init();
			viewInitialized = true;
		}
		mapViewBeanToView();
		showToastIfRequired();
	}
	
	private void showToastIfRequired() {
		if(this.mainInterfaceViewBean.getFunctionBean().getToastMessage() != null) {
			ToastMessage toast = new ToastMessage(this,this.mainInterfaceViewBean.getFunctionBean().getToastMessage());
			toast.display();
		}
	}

	private void mapViewBeanToView()
	{
		this.textFieldCommand.setText(this.mainInterfaceViewBean.getDataBean().getCalledShortcut());
		if(this.mainInterfaceViewBean.getFunctionBean().isFocusOnShortcutTextBox())
		{
			this.textFieldCommand.requestFocus();
		}
	}
	
	private void configureSuggestionDropdown() {
		this.componentSuggestionClient =  new TextComponentSuggestionClient(mainInterfaceViewBean.getDataBean().getShortcuts(),MAX_DISPLAYED_RESULTS_SUGGESTION);
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
		this.getController().update(arg0, this.mainInterfaceViewBean);
	}
}
