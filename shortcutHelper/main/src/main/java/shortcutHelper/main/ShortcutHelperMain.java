package shortcutHelper.main;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import shortcutHelper.helper.Helper;
import shortcutHelper.helper.propertyHelper.IPropertyHelper;
import shortcutHelper.middleend.controller.IMainInterfaceController;
import shortcutHelper.middleend.controller.MainInterfaceController;

public class ShortcutHelperMain {

	
	public static void main(String[] args) {
//		URL url = ShortcutHelperMain.class.getClass().getResource("/config/beans/backend/backendcommand/backendCommand-data-container-creator.xml");
//		System.out.println(url);
		ApplicationContext context = loadBeans();
		IMainInterfaceController controller = (IMainInterfaceController) context.getBean(IMainInterfaceController.BEAN_ID);
		controller.showInterface();
	}
	private static ApplicationContext loadBeans()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/config/beans/backend/backendcommand/backendCommand-data-container-creator-man.xml",
				"/config/beans/backend/backendcommand/backendCommand-data-container-data-extractor-man.xml",
				"/config/beans/backend/backendcommand/backendCommand-man.xml",
				"/config/beans/backend/helper/helper-man.xml",
				"/config/beans/backend/service/service-man.xml",
				"/config/beans/backend/backendinteraction/backendInteraction.xml",
				"/config/beans/middleend/interaction/interaction.xml",
				"/config/beans/middleend/controller/controller.xml",
				"/config/beans/frontend/interface/interface.xml"
				);
		return context;
	}
}
