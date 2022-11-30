package edu.javagroup.seabattle;

import edu.javagroup.seabattle.init.Initializer;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.service.impl.ShipServiceImpl;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;

import java.util.List;

import static edu.javagroup.seabattle.service.impl.ShipServiceImpl.autoSetShipPoints;

public class exz {
    public static void main(String[] args) {
        new Initializer().initPanels();
        ShipServiceImpl shipServiceImpl = new ShipServiceImpl();
        shipServiceImpl.getCoordinateList(autoSetShipPoints());
        int[][] field = new int[10][10];
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = panel.get(i).getPointElementList().get(j).getValue();
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
