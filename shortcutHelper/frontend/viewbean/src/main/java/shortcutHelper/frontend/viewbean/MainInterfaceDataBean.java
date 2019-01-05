package shortcutHelper.frontend.viewbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainInterfaceDataBean {
	private List<String> listShortcuts ;
	private String calledShortcut;
	
	public MainInterfaceDataBean()
	{
		listShortcuts = new ArrayList<String>();
		listShortcuts.add("house");
		listShortcuts.add("house.kitchen.table");
		listShortcuts.add("house.kitchen.chairs");
		listShortcuts.add("house.bedroom.bed");
		
	}	
	
	public List<String> getListShortcuts() {
		return Collections.unmodifiableList(listShortcuts);
	}
	public String getCalledShortcut() {
		return calledShortcut;
	}

	public void setCalledShortcut(String calledShortcut) {
		this.calledShortcut = calledShortcut;
	}
}
