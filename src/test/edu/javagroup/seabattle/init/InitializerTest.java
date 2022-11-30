package edu.javagroup.seabattle.init;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.singleton.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kaa
 * @version 1.0
 */
@SpringBootTest
public class InitializerTest {

    @BeforeAll
    static void init() {
        new Initializer().init();
    }

    @Test
    void initializerTest() {
        assertThat(SettingsSingleton.instance(null).getSettingsMap().isEmpty()).isTrue();
        assertThat(MyStepSingleton.instance(null).myStep()).isTrue();
        assertThat(ImReadySingleton.instance(null).imReady()).isFalse();
        assertThat(ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap().isEmpty()).isTrue();

        List<HorizontalLine> list1 = MinePanelSingleton.instance(null).getPanel();
        StringBuilder coordinateVertical1 = new StringBuilder();
        for (HorizontalLine horizontalLine : list1) {
            coordinateVertical1.append(horizontalLine.getRow());
        }
        assertThat(coordinateVertical1.toString().equals(Constants.VERTICAL_COORDINATE)).isTrue();

        List<PointElement> list11 = new ArrayList<>();
        for (HorizontalLine horizontalLine : list1) {
            list11.addAll(horizontalLine.getPointElementList());
        }
        int count11 = 0;
        for (PointElement pointElement : list11) {
            count11 += pointElement.getCol();
        }
        assertThat(count11 == 550).isTrue();

        StringBuilder coordinateVertical2 = new StringBuilder();
        List<HorizontalLine> list2 = EnemyPanelSingleton.instance(null).getPanel();
        for (HorizontalLine horizontalLine : list2) {
            coordinateVertical2.append(horizontalLine.getRow());
        }
        assertThat(coordinateVertical2.toString().equals(Constants.VERTICAL_COORDINATE)).isTrue();

        List<PointElement> list21 = new ArrayList<>();
        for (HorizontalLine horizontalLine : list2) {
            list21.addAll(horizontalLine.getPointElementList());
        }
        int count21 = 0;
        for (PointElement pointElement : list21) {
            count21 += pointElement.getCol();
        }
        assertThat(count21 == 550).isTrue();

        // панели должны быть представлены разными коллекциями, они должны находится в разных обдастях памяти
        assertThat(MinePanelSingleton.instance(null).getPanel().equals(EnemyPanelSingleton.instance(null).getPanel())).isFalse();

        Map<String, Integer> map = ShipStorageSingleton.instance(null).getShipMap();
        assertThat(map.isEmpty()).isFalse();
        for (int i = 1; i <= map.size(); ++i) {
            assertThat(map.getOrDefault(i + Constants.DECK, 100) == 0).isTrue();
        }
    }
}
