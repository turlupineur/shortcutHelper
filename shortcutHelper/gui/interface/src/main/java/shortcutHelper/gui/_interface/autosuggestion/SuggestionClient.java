package shortcutHelper.gui._interface.autosuggestion;

import java.awt.Point;

import javax.swing.JComponent;

public interface SuggestionClient<C extends JComponent> {

	  Point getPopupLocation(C invoker);

	  void setSelectedText(C invoker, String selectedValue);

	  java.util.List<String> getSuggestions(C invoker);

	}