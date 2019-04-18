package shortcutHelper.service.clipboardService.clipboard.realClipboard;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import shortcutHelper.logging.ShortcutHelperLogging;
import shortcutHelper.service.clipboardService.clipboard.ClipboardObject;

public class RealClipboard implements ClipboardObject {

	@Override
	public void setClipboard(String value) {
		StringSelection selection = new StringSelection(value);
		try {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
		}
	}

	@Override
	public String getClipboard() {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		String clipboard = null;
		try {
			clipboard = (String) defaultToolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException e) {
			ShortcutHelperLogging.logError(e);
		} catch (UnsupportedFlavorException e) {
			ShortcutHelperLogging.logError(e);
		} catch (IOException e) {
			ShortcutHelperLogging.logError(e);
		}
		return clipboard;
	}

}
