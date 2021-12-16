package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

	@DisplayName("초기 카운트객체를 생성한다.")
	@Test
	void createCountTest() {
		assertThat(Count.createZero()).isEqualTo(new Count(0));
	}

	@DisplayName("카운트값이 0 미만이 될 경우 에러를 반환한다.")
	@Test
	void validationCountTest() {
		assertThatThrownBy(
			() -> new Count(-1)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("카운트를 증가시키면 1만큼 커진 객체를 반환한다.")
	@Test
	void increaseCountTest() {
		assertThat(Count.createZero().increaseCount()).isEqualTo(new Count(1));
	}
}