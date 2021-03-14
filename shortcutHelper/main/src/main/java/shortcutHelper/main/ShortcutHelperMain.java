package shortcutHelper.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import shortcutHelper.middleend.controller.IMainInterfaceController;

public class ShortcutHelperMain {

	public static void main(String[] args) {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		ApplicationContext context = loadBeans();
		IMainInterfaceController controller = (IMainInterfaceController) context
				.getBean(IMainInterfaceController.BEAN_ID);
		controller.showInterface();
	}

	private static ApplicationContext loadBeans() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/config/beans/backend/functionality/functionality-data-container-creator-man.xml",
				"/config/beans/backend/functionality/functionality-data-container-data-extractor-man.xml",
				"/config/beans/backend/functionality/functionality-man.xml", "/config/beans/helper/helper-man.xml",
				"/config/beans/util/util-man.xml", "/config/beans/service/service-man.xml",
				"/config/beans/backend/backendinteraction/backendInteraction.xml",
				"/config/beans/middleend/interaction/interaction.xml", "/config/beans/backend/logic/logic-man.xml",
				"/config/beans/middleend/controller/controller.xml", "/config/beans/frontend/interface/interface.xml",
				"/config/beans/backend/functionality/functionality_command.xml",
				"/config/beans/backend/logic/logic-data-container-creator-man.xml",
				"/config/beans/backend/functionality/functionality-man.xml");
		return context;
	}
}
