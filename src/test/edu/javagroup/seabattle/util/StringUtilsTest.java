package edu.javagroup.seabattle.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kaa
 * @version 1.3
 */
@SpringBootTest
public class StringUtilsTest {

    @Test
    void isEmptyTest() {
        assertThat(StringUtils.isEmpty(null)).isTrue();
        assertThat(StringUtils.isEmpty("")).isTrue();
        assertThat(StringUtils.isEmpty("123")).isFalse();
    }

    @Test
    void isNotEmptyTest() {
        assertThat(StringUtils.isNotEmpty(null)).isFalse();
        assertThat(StringUtils.isNotEmpty("")).isFalse();
        assertThat(StringUtils.isNotEmpty("123")).isTrue();
    }

    @Test
    void letterBeforeTest() {
        char randomSymbol = (char) (new Random().nextInt(73 - 65) + 65);
        assertThat(StringUtils.letterBefore(randomSymbol) == (char) (randomSymbol - 1)).isTrue();
    }

    @Test
    void letterAfterTest() {
        char randomSymbol = (char) (new Random().nextInt(73 - 65) + 65);
        assertThat(StringUtils.letterAfter(randomSymbol) == (char) (randomSymbol + 1)).isTrue();
    }
}
