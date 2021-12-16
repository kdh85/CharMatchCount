package model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordTest {

	@DisplayName("도메인 심화분석을 위한 초기형태의 전기능 구현.")
	@Test
	void prototypeTest() {
		String aaa = "aaabBbc";

		Map<java.lang.Character, Integer> result = new HashMap<>();

		AtomicInteger integer = new AtomicInteger();

		for (int i = 0; i < aaa.length(); i++) {
			char character = aaa.charAt(i);

			if(result.containsKey(character)){
				result.put(character, integer.incrementAndGet());
			}else{
				integer.set(1);
				result.put(character, integer.intValue());
			}
		}

		for (java.lang.Character key : result.keySet()) {
			System.out.println(key + " : " + result.get(key));
		}
	}

	@DisplayName("단어를 입력받아 각 글자별 카운트값을 가지는 객체를 생성한다.")
	@Test
	void createTest() {
		Word testWord = Word.of("aabccc");

		Map<Character, Count> testMap = new HashMap<>();
		testMap.put(new Character('a'), new Count(2));
		testMap.put(new Character('b'), new Count(1));
		testMap.put(new Character('c'), new Count(3));

		assertThat(testWord).isEqualTo(new Word(testMap));
	}

	@DisplayName("입력받는 단어가 영문이외의 것이 포함되있을 경우 에러를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"aa b", "!abc", "asd2"})
	void validationTest(String word) {
		assertThatThrownBy(
			() -> Word.of(word)
		).isInstanceOf(IllegalArgumentException.class);
	}
}