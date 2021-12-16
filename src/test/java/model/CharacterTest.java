package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CharacterTest {

	@DisplayName("글자하나를 주입받아 글자 객체를 만든다.")
	@Test
	void createCharacterTest() {
		assertThat(new Character('a')).isEqualTo(new Character('a'));
	}

	@DisplayName("입력받는 글자가 영문자가 아닌 경우 에러를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1", "!", "?", ">"})
	void validationOnlyEnglishTest(char character) {
		assertThatThrownBy(
			() -> new Character(character)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("객체가 다른 문자객체와 비교하여 같은 객체인지 비교값을 반환한다.")
	@Test
	void isSameCharacterTest() {
		Character firstChar = new Character('a');
		assertThat(firstChar.isSameCharacter(new Character('a'))).isEqualTo(true);
	}
}