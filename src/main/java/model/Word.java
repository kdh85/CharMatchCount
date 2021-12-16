package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Word {

	private static final int START_WORD_INDEX = 0;
	private static final String SEPARATOR = " : ";

	private final Map<Character, Count> word;

	public Word(Map<Character, Count> word) {
		this.word = word;
	}

	public static Word of(final String inputWord) {
		Map<Character, Count> result = new HashMap<>();

		for (int i = START_WORD_INDEX; i < inputWord.length(); i++) {
			Character character = new Character(inputWord.charAt(i));
			result.put(character, countByCharacter(result, character));
		}

		return new Word(result);
	}

	private static Count countByCharacter(Map<Character, Count> result, Character character) {
		if (result.containsKey(character)) {
			return result.get(character).increaseCount();
		}
		return Count.createZero().increaseCount();
	}

	public void printResult() {
		for (Character character : word.keySet()) {
			System.out.println(character.toStringCharacter() + SEPARATOR + word.get(character).toStringCount());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Word word1 = (Word)o;
		return Objects.equals(word, word1.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}

	@Override
	public String toString() {
		return "Word{" +
			   "word=" + word +
			   '}';
	}

}
