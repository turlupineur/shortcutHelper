package shortcutHelper.backend.dynamicCommand;

import shortcutHelper.common.obervation.DynamicCommandObserver;
import shortcutHelper.logging.ShortcutHelperLogging;

public class DynamicCommandController extends AbstractDynamicCommandController {

	@Override
	public void executeDynamicCommands() {
		Thread newThread = new Thread(new Runnable() {

			@Override
			public void run() {
				DynamicCommandShortcutRepository dynamicCommandShortcutRepository = new DynamicCommandShortcutRepository();

				for (IDynamicCommand dynamicCommand : getDynamicCommands()) {
					ShortcutHelperLogging.logInfo("Running dynamic command: " + dynamicCommand.getClass());
					try {
						dynamicCommand.run(dynamicCommandShortcutRepository);
					} catch (Throwable t) {
						ShortcutHelperLogging.logError(t);
					}
					ShortcutHelperLogging.logInfo("Done running dynamic command: " + dynamicCommand.getClass());
				}
				notifyObserversDynamicCommandsAreDone();

				ShortcutHelperLogging.logInfo("Done running dynamic commands. Nb shortcuts added: "
						+ dynamicCommandShortcutRepository.getNbShortcutsAdded() + ", nb shortcuts removed: "
						+ dynamicCommandShortcutRepository.getNbShortcutsRemoved());
			}
		});

		newThread.start();

	}

	private void notifyObserversDynamicCommandsAreDone() {
		for (DynamicCommandObserver observer : getDynamicCommandObservers()) {
			try {
				observer.dynamicCommandsHaveBeenExecuted();
			} catch (Throwable t) {
				ShortcutHelperLogging.logError(t);
			}

		}
	}

}
