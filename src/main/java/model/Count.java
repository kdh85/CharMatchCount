package model;

import java.util.Objects;

public class Count {

	private static final int DEFAULT_COUNT = 0;
	private static final String ERROR_COUNT_VALUE = String.format("카운트의 최소값은 %d부터 입니다.", DEFAULT_COUNT);
	private static final int INCREASE_TERM_VALUE = 1;
	private final int count;

	protected Count(int count) {
		validationCount(count);
		this.count = count;
	}

	private void validationCount(int count) {
		if (isLessThanDefault(count)) {
			throw new IllegalArgumentException(ERROR_COUNT_VALUE);
		}
	}

	private boolean isLessThanDefault(int count) {
		return count < DEFAULT_COUNT;
	}

	public static Count createZero() {
		return new Count(DEFAULT_COUNT);
	}

	public Count increaseCount() {
		return new Count(count + INCREASE_TERM_VALUE);
	}

	public String toStringCount() {
		return String.valueOf(count);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Count count1 = (Count)o;
		return count == count1.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	@Override
	public String toString() {
		return "Count{" +
			   "count=" + count +
			   '}';
	}
}
