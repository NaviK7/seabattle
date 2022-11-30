package edu.javagroup.seabattle.constants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static edu.javagroup.seabattle.constants.Constants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author kaa
 * @version 1.0
 */
@SpringBootTest
public class ConstantsTest {

    // тест констант (не имеет смысла)
    @Test
    void constantsTest() {
        //assertThat(Arrays.equals(LOCALHOST, new int[]{127, 0, 0, 1})).isTrue();
        assertThat(ENEMY_PROTOCOL.equals("http")).isTrue();
        assertThat(ENEMY_IP_ADDRESS.equals("enemyIpAddress")).isTrue();
        assertThat(ENEMY_PORT.equals("8080")).isTrue();
        assertThat(VERTICAL_COORDINATE.equals("ABCDEFGHIJ")).isTrue();
        assertThat(DECK.equals("deck")).isTrue();
        assertThat(BUTTON_PREFIX.equals("jButton")).isTrue();
        assertThat(MINE.equals("M")).isTrue();
        assertThat(ENEMY.equals("E")).isTrue();
        assertThat(M_BUTTON_PREFIX.equals("jButtonM")).isTrue();
        assertThat(E_BUTTON_PREFIX.equals("jButtonE")).isTrue();
        assertThat(BUTTON_POSTFIX.equals("ActionPerformed")).isTrue();
    }
}
