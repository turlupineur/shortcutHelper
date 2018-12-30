package shortcutHelper.gui._interface.autosuggestion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.text.JTextComponent;
/**
 * Contains logic to filter displayed results.
 * @author jsvaillant
 *
 */
public class TextComponentSuggestionClient implements SuggestionClient<JTextComponent> {

	private Function<String, List<String>> suggestionProvider;
	
	private List<String> listWords;
	private int nbMaxResultsToDisplay;

	public TextComponentSuggestionClient(List<String> listWords, int nbMaxResultsToDisplay) {
		this.suggestionProvider = this::getWordsMatching;
		this.listWords = listWords;
		this.nbMaxResultsToDisplay = nbMaxResultsToDisplay;
	}

	@Override
	public Point getPopupLocation(JTextComponent invoker) {
		return new Point(0, invoker.getPreferredSize().height);
	}

	@Override
	public void setSelectedText(JTextComponent invoker, String selectedValue) {
		invoker.setText(selectedValue);
	}

	@Override
	public List<String> getSuggestions(JTextComponent invoker) {
		return suggestionProvider.apply(invoker.getText().trim());
	}

	private List<String> getWordsMatching(String str) {		
		return listWords.stream()
        .filter(s -> s.startsWith(str))
        .limit(nbMaxResultsToDisplay)
        .collect(Collectors.toList());
	}
}
