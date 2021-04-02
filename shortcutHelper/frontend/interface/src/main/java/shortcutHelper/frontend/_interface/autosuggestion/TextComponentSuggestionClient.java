package shortcutHelper.frontend._interface.autosuggestion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.text.JTextComponent;

import shortcutHelper.common.obervation.ShortcutListObserver;

/**
 * Contains logic to filter displayed results.
 * 
 * @author jsvaillant
 *
 */
public class TextComponentSuggestionClient implements SuggestionClient<JTextComponent>, ShortcutListObserver {

	private Function<String, List<String>> suggestionProvider;

	private List<String> listWords;
	private int nbMaxResultsToDisplay;

	public TextComponentSuggestionClient() {
		this.suggestionProvider = this::getWordsMatching;
		listWords = new ArrayList<>();
	}

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

	public void updateListWords(List<String> listWords) {
		this.listWords.clear();
		this.listWords.addAll(listWords);
	}

	private List<String> getWordsMatching(String str) {
		return listWords.stream().filter(s -> s.startsWith(str)).limit(nbMaxResultsToDisplay)
				.collect(Collectors.toList());
	}

	@Override
	public void listUpdated(Map<String, String> newShortcutLists) {
		this.listWords = new ArrayList<>(newShortcutLists.keySet());
	}

	public void setNbMaxResultsToDisplay(int nbMaxResultsToDisplay) {
		this.nbMaxResultsToDisplay = nbMaxResultsToDisplay;
	}

}
