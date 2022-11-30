package edu.javagroup.seabattle.service;

import edu.javagroup.seabattle.common.utils.CommonService;
import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.service.impl.PanelServiceImpl;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.ImReadySingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * перед использованием раскомментировать классы
 * <p>
 * test -> edu.javagroup.seabattle.common.utils.CommonService
 * test -> edu.javagroup.seabattle.common.utils.impl.CommonServiceImpl
 *
 * @author kaa
 * @version 1.6
 */
@SpringBootTest
public class PanelServiceTest {

    @Autowired
    private PanelService panelService;

    @Autowired
    private CommonService commonService;

    //------------------------------------------------------------------------------------------------------------------

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(PanelServiceImpl.class.getInterfaces()[0].getName().equals(PanelService.class.getName())).isTrue();
    }

    @Test
    void isPanelEmptyTest() {
        MinePanelSingleton.instance(commonService.getPanel00());
        assertThat(panelService.isPanelEmpty()).isTrue();

        MinePanelSingleton.instance(commonService.getPanel19());
        assertThat(panelService.isPanelEmpty()).isFalse();
    }

    @Test
    void isFullMinePanelTest() {
        MinePanelSingleton.instance(commonService.getPanel19());
        assertThat(panelService.isFullMinePanel()).isFalse();

        MinePanelSingleton.instance(commonService.getPanel20());
        assertThat(panelService.isFullMinePanel()).isTrue();
    }

    @Test
    void howMuchIsLeftTest() {

        ImReadySingleton.instance(true);

        MinePanelSingleton.instance(commonService.getPanel00());
        assertThat(panelService.howMuchIsLeft(Constants.MINE) == 20).isTrue();

        MinePanelSingleton.instance(commonService.getPanel19());
        assertThat(panelService.howMuchIsLeft(Constants.MINE) == 20).isTrue();

        MinePanelSingleton.instance(commonService.getPanel20());
        assertThat(panelService.howMuchIsLeft(Constants.MINE) == 20).isTrue();

        MinePanelSingleton.instance(commonService.getPanel22());
        assertThat(panelService.howMuchIsLeft(Constants.MINE) == 0).isTrue();
    }

    @Test
    void checkEndGameTest() {
        MinePanelSingleton.instance(commonService.getPanel20());
        assertThat(panelService.checkEndGame(Constants.MINE)).isFalse();

        MinePanelSingleton.instance(commonService.getPanel22());
        assertThat(panelService.checkEndGame(Constants.MINE)).isTrue();

        EnemyPanelSingleton.instance(commonService.getPanel20());
        assertThat(panelService.checkEndGame(Constants.ENEMY)).isFalse();

        EnemyPanelSingleton.instance(commonService.getPanel22());
        assertThat(panelService.checkEndGame(Constants.ENEMY)).isTrue();

        MinePanelSingleton.instance(commonService.getPanel20());
        Exception exception = assertThrows(Exception.class, () -> {
            panelService.checkEndGame("STRANGE");
        });
        assertThat(exception.getMessage()).hasToString("Уточните сторону (MINE or ENEMY)");
    }
}
