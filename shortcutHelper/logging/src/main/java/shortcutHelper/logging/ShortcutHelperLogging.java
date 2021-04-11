package shortcutHelper.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ShortcutHelperLogging {
	private static Logger logger = LogManager.getLogger(ShortcutHelperLogging.class);

	public static void logDebug(Object o) {
		logger.debug(o);
	}

	public static void logDebug(String str) {
		logger.debug(str);
	}

	public static void logDebug(Throwable t) {
		logger.debug(t.getMessage(), t);
	}

	public static void logInfo(Object o) {
		logger.info(o);
	}

	public static void logInfo(String str) {
		logger.info(str);
	}

	public static void logInfo(Throwable t) {
		logger.info(t.getMessage(), t);
	}

	public static void logWarning(Object o) {
		logger.warn(o);
	}

	public static void logWarning(String str) {
		logger.warn(str);
	}

	public static void logWarning(Throwable t) {
		logger.warn(t.getMessage(), t);
	}

	public static void logError(Object o) {
		logger.error(o);
	}

	public static void logError(String str) {
		logger.error(str);
	}

	public static void logError(Throwable t) {
		logger.error(t.getMessage(), t);
	}

	public static void logSeparationInfo() {
		logInfo("--------------------------------------------------------------");
	}
}
