package shortcutHelper.frontend.viewbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainInterfaceViewBean {
	private MainInterfaceFunctionBean functionBean;
	private MainInterfaceDataBean dataBean;
	
	
	public MainInterfaceViewBean()
	{
		functionBean = new MainInterfaceFunctionBean();
		dataBean = new MainInterfaceDataBean();
	}
	
	public MainInterfaceFunctionBean getFunctionBean() {
		return functionBean;
	}
	


	public MainInterfaceDataBean getDataBean() {
		return dataBean;
	}
}
