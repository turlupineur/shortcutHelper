package shortcutHelper.frontend.viewbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainInterfaceDataBean {
	private List<String> shortcuts ;
	private String calledShortcut;
	
	public MainInterfaceDataBean()
	{
		shortcuts = new ArrayList<String>();
	}	
	
	public List<String> getShortcuts() {
		return Collections.unmodifiableList(shortcuts);
	}
	public void setShortcuts(List<String> shortcuts)
	{
		this.shortcuts.clear();
		this.shortcuts.addAll(shortcuts);
	}
	public String getCalledShortcut() {
		return calledShortcut;
	}

	public void setCalledShortcut(String calledShortcut) {
		this.calledShortcut = calledShortcut;
	}
}
