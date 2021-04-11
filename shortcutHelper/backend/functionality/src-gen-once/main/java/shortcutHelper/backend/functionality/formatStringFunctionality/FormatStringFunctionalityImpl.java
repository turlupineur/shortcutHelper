package shortcutHelper.backend.functionality.formatStringFunctionality;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.logic.behavior.ClipboardGetBehavior;
import shortcutHelper.backend.logic.behavior.ClipboardSetBehavior;

public class FormatStringFunctionalityImpl extends AbstractFormatStringFunctionality
		implements ClipboardGetBehavior, ClipboardSetBehavior {
	public FunctionalityResult runImpl(FunctionalityDataContainer c) {
		FormatStringFunctionalityDataContainer container = (FormatStringFunctionalityDataContainer) c;

		String clipboard = getClipboard();

		Pattern originalPattern = Pattern.compile(container.getOriginalFormat());
		Matcher originalMatcher = originalPattern.matcher(clipboard);

		if (container.getOTargetFormat() != null) {
			Pattern targetPattern = Pattern.compile(container.getOTargetFormat());
			Matcher targetMatcher = targetPattern.matcher(clipboard);
			if (targetMatcher.matches()) {
				if (container.getDReverseFormat()) {
					String newValue = targetMatcher.replaceAll(container.getOTransformationToOriginalFormat());
					setClipboard(newValue);
					container.getShortcutHelperContext().setInfo("Value reversed back to original format.");
				} else {
					container.getShortcutHelperContext().setInfo("Value already formatted. Nothing was done.");
				}
			}
		} else if (originalMatcher.matches()) {
			String newValue = originalMatcher.replaceAll(container.getTransformationToTargetFormat());
			setClipboard(newValue);
			container.getShortcutHelperContext().setInfo("Value formatted.");
		} else {
			container.getShortcutHelperContext().setError("Clipboard format unknown.");
		}

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
