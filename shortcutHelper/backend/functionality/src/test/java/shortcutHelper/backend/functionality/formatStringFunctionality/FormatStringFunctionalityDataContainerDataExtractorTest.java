package shortcutHelper.backend.functionality.formatStringFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

import shortcutHelper.backend.functionality.FunctionalityTesting;

public class FormatStringFunctionalityDataContainerDataExtractorTest extends FunctionalityTesting {
	@InjectMocks
	private FormatStringFunctionalityDataContainerDataExtractor extractor;

	private static final String ORIGINAL_FORMAT = "originalFormat";
	private static final String TRANSFORMATION_TO_TARGET = "transformationToOriginal";

	private static final String TARGET_FORMAT = "originalFormat";
	private static final String TRANSFORMATION_TO_ORIGINAL = "transformationToOriginal";

	@Test
	public void onlyTwoParametersGiven() {

		String[] rawData = new String[2];

		rawData[0] = ORIGINAL_FORMAT;
		rawData[1] = TRANSFORMATION_TO_TARGET;

		FormatStringFunctionalityDataContainer container = new FormatStringFunctionalityDataContainer();

		extractor.extractData(rawData, container);

		assertThat(container.getOriginalFormat(), is(ORIGINAL_FORMAT));
		assertThat(container.getTransformationToTargetFormat(), is(TRANSFORMATION_TO_TARGET));

	}

	@Test
	public void fourParametersGiven() {
		String[] rawData = new String[4];

		rawData[0] = ORIGINAL_FORMAT;
		rawData[1] = TRANSFORMATION_TO_TARGET;
		rawData[2] = TARGET_FORMAT;
		rawData[3] = TRANSFORMATION_TO_ORIGINAL;

		FormatStringFunctionalityDataContainer container = new FormatStringFunctionalityDataContainer();

		extractor.extractData(rawData, container);

		assertThat(container.getOriginalFormat(), is(ORIGINAL_FORMAT));
		assertThat(container.getTransformationToTargetFormat(), is(TRANSFORMATION_TO_TARGET));
		assertThat(container.getOTargetFormat(), is(TARGET_FORMAT));
		assertThat(container.getOTransformationToOriginalFormat(), is(TRANSFORMATION_TO_ORIGINAL));

	}

	@Test
	public void defaultRevertingSpecified() {
		String[] rawData = new String[5];

		rawData[0] = ORIGINAL_FORMAT;
		rawData[1] = TRANSFORMATION_TO_TARGET;
		rawData[2] = TARGET_FORMAT;
		rawData[3] = TRANSFORMATION_TO_ORIGINAL;
		rawData[4] = String.valueOf(false);

		FormatStringFunctionalityDataContainer container = new FormatStringFunctionalityDataContainer();

		extractor.extractData(rawData, container);

		assertThat(container.getOriginalFormat(), is(ORIGINAL_FORMAT));
		assertThat(container.getTransformationToTargetFormat(), is(TRANSFORMATION_TO_TARGET));
		assertThat(container.getOTargetFormat(), is(TARGET_FORMAT));
		assertThat(container.getOTransformationToOriginalFormat(), is(TRANSFORMATION_TO_ORIGINAL));
		assertThat(container.getDReverseFormat(), is(false));
	}

}
