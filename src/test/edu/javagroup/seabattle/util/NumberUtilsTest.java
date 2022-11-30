package edu.javagroup.seabattle.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kaa
 * @version 1.3
 */
@SpringBootTest
public class NumberUtilsTest {

    @Test
    void numberUtilsTest() {
        assertThat(NumberUtils.isNumber(null)).isFalse();
        assertThat(NumberUtils.isNumber("")).isFalse();
        assertThat(NumberUtils.isNumber(" ")).isFalse();
        assertThat(NumberUtils.isNumber("-1")).isFalse();
        assertThat(NumberUtils.isNumber("1-")).isFalse();
        assertThat(NumberUtils.isNumber("1.2")).isFalse();
        assertThat(NumberUtils.isNumber("1a")).isFalse();
        assertThat(NumberUtils.isNumber("a1")).isFalse();
        assertThat(NumberUtils.isNumber("0")).isTrue();
        assertThat(NumberUtils.isNumber("1")).isTrue();
    }

    @Test
    void currentNumberTest() {
        assertThat(NumberUtils.currentNumber(1).equals("01")).isTrue();
        assertThat(NumberUtils.currentNumber(5).equals("05")).isTrue();
        assertThat(NumberUtils.currentNumber(10).equals("10")).isTrue();
    }

    @Test
    void numberBeforeTest() {
        assertThat(NumberUtils.numberBefore(1).equals("00")).isTrue();
        assertThat(NumberUtils.numberBefore(5).equals("04")).isTrue();
        assertThat(NumberUtils.numberBefore(10).equals("09")).isTrue();
    }

    @Test
    void numberAfterTest() {
        assertThat(NumberUtils.numberAfter(1).equals("02")).isTrue();
        assertThat(NumberUtils.numberAfter(9).equals("10")).isTrue();
        assertThat(NumberUtils.numberAfter(10).equals("11")).isTrue();
    }
}
