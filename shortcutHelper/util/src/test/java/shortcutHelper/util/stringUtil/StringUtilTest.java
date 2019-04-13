package shortcutHelper.util.stringUtil;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import shortcutHelper.util.UtilTesting;

public class StringUtilTest extends UtilTesting {
	@InjectMocks
	private IStringUtil strUtil = new StringUtilImpl();

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void lastUpper_nullStr() {
		String value = null;
		assertThat(strUtil.getPositionLastUpperCase(value), is(IStringUtil.INVALID_POSITION));
	}

	@Test
	public void lastUpper_noUpperCase() {
		String value = "bonjour";
		assertThat(strUtil.getPositionLastUpperCase(value), is(IStringUtil.INVALID_POSITION));
	}

	@Test
	public void lastUpper_allUpperCase() {
		String value = "bonjour".toUpperCase();
		assertThat(strUtil.getPositionLastUpperCase(value), is(value.length() - 1));
	}

	@Test
	public void lastUpper_normalCase() {
		String value = "bonjourToi";
		assertThat(strUtil.getPositionLastUpperCase(value), is(7));
	}

	@Test
	public void toFirstUpper_normalCase() {
		String value = "bonjour";
		assertThat(strUtil.toFirstUpper(value), is("Bonjour"));
	}

	@Test
	public void toFirstUpper_nullValue() {
		String value = null;
		assertNull(strUtil.toFirstUpper(value));
	}

	@Test
	public void toFirstUpper_emptyValue() {
		String value = "";
		assertThat(strUtil.toFirstUpper(value), is(""));
	}

	@Test
	public void toFirstLower_normalCase() {
		String value = "BONJOUR";
		assertThat(strUtil.toFirstLower(value), is("bONJOUR"));
	}

	@Test
	public void toFirstLower_nullValue() {
		String value = null;
		assertNull(strUtil.toFirstLower(value));
	}

	@Test
	public void toFirstLower_emptyValue() {
		String value = "";
		assertThat(strUtil.toFirstLower(value), is(""));
	}
}
