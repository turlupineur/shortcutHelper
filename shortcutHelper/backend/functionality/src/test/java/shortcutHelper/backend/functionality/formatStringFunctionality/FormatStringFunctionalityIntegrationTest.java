package shortcutHelper.backend.functionality.formatStringFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.FunctionalityIntegrationTesting;

public class FormatStringFunctionalityIntegrationTest extends FunctionalityIntegrationTesting {

	private static final String ORIGINAL_REG_FORMAT = "(cat) (dog)";
	private static final String TRANSFORMATION_TO_ORIGINAL_FORMAT = "$2 $1";
	private static final String TARGET_REG_FORMAT = "(dog) (cat)";
	private static final String TRANSFORMATION_TARGET_FORMAT = "$2 $1";

	@Test
	public void formatNotRecognized() {
		// We will try to inverse the cat and dog in string.
		setClibpoard("bonjour");

		FunctionalityExecutionResult result = runCurrentFunctionality(ORIGINAL_REG_FORMAT,
				TRANSFORMATION_TARGET_FORMAT);

		assertThat(getClipboard(), is("bonjour"));
		assertThat(result.getContext().getError(), is("Clipboard format unknown."));
	}

	@Test
	public void targetFormatAlreadyReached() {
		setClibpoard("dog cat");

		FunctionalityExecutionResult result = runCurrentFunctionality(ORIGINAL_REG_FORMAT, TRANSFORMATION_TARGET_FORMAT,
				TARGET_REG_FORMAT, TRANSFORMATION_TO_ORIGINAL_FORMAT, String.valueOf(false));

		assertThat(getClipboard(), is("dog cat"));
		assertThat(result.getContext().getInfo(), is("Value already formatted. Nothing was done."));
	}

	@Test
	public void reverseFormatting() {
		// We will try to inverse the cat and dog in string.
		setClibpoard("dog cat");

		FunctionalityExecutionResult result = runCurrentFunctionality(ORIGINAL_REG_FORMAT, TRANSFORMATION_TARGET_FORMAT,
				TARGET_REG_FORMAT, TRANSFORMATION_TO_ORIGINAL_FORMAT, String.valueOf(true));

		assertThat(getClipboard(), is("cat dog"));
		assertThat(result.getContext().getInfo(), is("Value reversed back to original format."));
	}

	@Test
	public void clibpoardFormatToTargetFormat() {
		// We will try to inverse the cat and dog in string.
		setClibpoard("cat dog");

		FunctionalityExecutionResult result = runCurrentFunctionality(ORIGINAL_REG_FORMAT,
				TRANSFORMATION_TARGET_FORMAT);

		assertThat(getClipboard(), is("dog cat"));
		assertThat(result.getContext().getInfo(), is("Value formatted."));
	}
}
