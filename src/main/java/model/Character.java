package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Character {

	private static final String PATTERN_ONLY_ENGLISH = "^[a-zA-Z]*$";
	private static final String ERROR_CHARACTER_VALUE = "입력받는 글자는 영문자만 가능합니다.";

	private final char character;

	public Character(char character) {
		if(isNotEnglish(character)){
			throw new IllegalArgumentException(ERROR_CHARACTER_VALUE);
		}
		this.character = character;
	}

	private boolean isNotEnglish(char character) {
		return !Pattern.matches(PATTERN_ONLY_ENGLISH, String.valueOf(character));
	}

	public boolean isSameCharacter(final Character character){
		return this.equals(character);
	}

	public String toStringCharacter() {
		return String.valueOf(character);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Character character1 = (Character)o;
		return character == character1.character;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character);
	}

	@Override
	public String toString() {
		return "Character{" +
			   "character=" + character +
			   '}';
	}
}
