package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.model.ShipPoint;
import edu.javagroup.seabattle.service.ShipService;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import edu.javagroup.seabattle.singleton.ShipStorageSingleton;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Класс ShipServiceImpl имплементация интерфейса ShipService,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Component
public class ShipServiceImpl implements ShipService {
    private List<ShipPoint> coordinateList;


    /**
     * имплементация интерфейса ShipService
     * перегруженный метод: checkShipCount
     * проверяет правильное количество кораблей
     */
    @Override
    public boolean checkShipCount() {
        //получиаем коллекцию из MinePanelSingleton
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();
        //вызваем метод getCoordinateList куда отправить полученную коллекцию
        getCoordinateList(panel);
        //создаем карту
        Map<String, Integer> map = new HashMap<>();
        map.put("4" + Constants.DECK, findShipDeck(4));
        map.put("3" + Constants.DECK, findShipDeck(3));
        map.put("2" + Constants.DECK, findShipDeck(2));
        map.put("1" + Constants.DECK, findShipDeck(1));
        // вложить полученную карту в ShipStorageSingleton
        ShipStorageSingleton.instance(map);
        //возвращаем результат соответствия ключа карты с количеством короблей, которое должно быть в карте по данному ключу
        return ShipStorageSingleton.instance(null).getShipMap().get("4" + Constants.DECK) == 1
                && ShipStorageSingleton.instance(null).getShipMap().get("3" + Constants.DECK) == 2
                && ShipStorageSingleton.instance(null).getShipMap().get("2" + Constants.DECK) == 3
                && ShipStorageSingleton.instance(null).getShipMap().get("1" + Constants.DECK) == 4;
    }

    /**
     * имплементация интерфейса ShipService
     * перегруженный метод: checkShipCount
     * проверяет  количество короблей
     */
    @Override
    public int checkShipCount(int deckCount) {
        int count = 0;
        getCoordinateList(MinePanelSingleton.instance(null).getPanel());
        for (int i = 1; i <= deckCount; i++) {
            count = findShipDeck(deckCount);
            return count;
        }
        return findShipDeck(deckCount);
    }

    /**
     * имплементация интерфейса ShipService
     * метод: getCoordinateList
     * создает коллекцию , которая отображает заполнеие кораблями  игровоого поля
     */
    public List<ShipPoint> getCoordinateList(List<HorizontalLine> list) {
        //инициализация  поля coordinateList  нужной размерности
        coordinateList = new ArrayList<>(220);
        //добавляем коллекцию полученную из метода getHorizontalCoordinateList
        coordinateList.addAll(getHorizontalCoordinateList(list));
        // добавляем  коллекцию полученную из метода getVerticalCoordinateList
        coordinateList.addAll(getVerticalCoordinateList(list));
        /*создаем колекцию pointList типа ShipPoint и добавляем в нее только те элементы coordinateList,
         у которых value == 0 и у соседнего (следующего) value == 0 */
        List<ShipPoint> pointList = new ArrayList<>(coordinateList.size());
        for (int i = 0; i < coordinateList.size() - 1; i++) {
            if (coordinateList.get(i).getValue() == 0
                    && coordinateList.get(i + 1).getValue() == 0) {
                pointList.add(coordinateList.get(i));
            }
        }
        //удаляем из coordinateList  все элементы коллекции pointList
        coordinateList.removeAll(pointList);
        // сортируем коллекцию coordinateList по полю point
        coordinateList.sort(Comparator.comparing(ShipPoint::getPoint));
        return coordinateList;
    }

    /**
     * имплементация интерфейса ShipService
     * метод: getHorizontalCoordinateList
     * входные параметры: List<HorizontalLine>
     * возвращает: List<ShipPoint>
     * перебирает коолекцию  List<HorizontalLine>  по горизонтали
     * и перезаписываем ее элементы в новую коллекцию List<ShipPoint> в нужном порядке
     */
    public List<ShipPoint> getHorizontalCoordinateList(List<HorizontalLine> list) {
        // создаем коллекцию  List<ShipPoint> нужной размерности
        List<ShipPoint> shipPointList = new ArrayList<>(110);
        int k = 1;
        //перебираем коолекцию List<HorizontalLine> по горизонтали
        for (HorizontalLine i : list) {
            for (PointElement j : i.getPointElementList()) {
                // перезаписываем  элементы  из  List<HorizontalLine> в новую коллекцию List<ShipPoint> в нужном порядке
                shipPointList.add(new ShipPoint(k, j.getValue()));
                k++;
            }
            shipPointList.add(new ShipPoint(k, 0));
            k++;
        }
        return shipPointList;

    }

    /**
     * имплементация интерфейса ShipService
     * метод: getVerticalCoordinateList
     * входные параметры: List<HorizontalLine>
     * возвращает: List<ShipPoint>
     * перебирает коолекцию  List<HorizontalLine>  по вертикали
     * и перезаписываем ее элементы в новую коллекцию List<ShipPoint> в нужном порядке
     */
    public List<ShipPoint> getVerticalCoordinateList(List<HorizontalLine> list) {
        // создаем коллекцию  List<ShipPoint> нужной размерности
        List<ShipPoint> shipPointListV = new ArrayList<>(110);
        int k = 111;
        //перебираем коолекцию List<HorizontalLine> по вертикали
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            for (int g = 0; g < Constants.VERTICAL_COORDINATE.length(); g++) {
                for (int j = 0; j < Constants.VERTICAL_COORDINATE.length(); j++) {
                    if (Constants.VERTICAL_COORDINATE.charAt(g) == list.get(j).getRow()) {
                        // перезаписываем  элементы  из  List<HorizontalLine> в новую коллекцию List<ShipPoint> в нужном порядке
                        shipPointListV.add(new ShipPoint(k, list.get(j).getPointElementList().get(i).getValue()));
                    }
                }
                k++;
            }
            shipPointListV.add(new ShipPoint(k, 0));
            k++;
        }
        return shipPointListV;
    }

    /**
     * имплементация интерфейса ShipService
     * метод: findShipDeck
     * считает количество кораблей на игровом поле
     */
    public int findShipDeck(int lengthShip) {
        //обяявляем переменную количества кораблей
        int countShip = 0;
        //строковая пееменная , в которую записываем элементы из колекции
        StringBuilder stringBuilder = new StringBuilder();
        //перебираем коллекцию coordinateList и извлекаем нужные элементы
        for (ShipPoint j : getCoordinateList(MinePanelSingleton.instance(null).getPanel())) {
            if (j.getValue() == 0 || j.getValue() == 1 || j.getValue() == 2)
                stringBuilder.append(j.getValue());
        }
        //создаем массив из полученной строки
        String[] arrayStringsValue = stringBuilder.toString().split("0");
        //перебираем полученный массив и считаем в нем количество ячеек нужной размерности
        for (String line : arrayStringsValue) {
            if (line.length() == lengthShip) {
                countShip++;
            }
        }
        return lengthShip == 1 ? countShip / 6 : countShip;

    }

    /**
     * метод: autoSetShipPoints
     * расстановка кораблей на игровом поле
     */
    public static List<HorizontalLine> autoSetShipPoints() {
        Random random = new Random();
        //создаем коллекцию и заполняем ее числами в нужном интервале
        List<Integer> integerList = new ArrayList<>();
        for (int i = -11; i < 111; i++) {
            integerList.add(i);
        }
        //перемешиваем числа в коллекции
        Collections.shuffle(integerList);
        ShipServiceImpl shipServiceImpl = new ShipServiceImpl();
        int count = 0;
        int rand;
        int round1;
        int round2;
        int round3;
        int round4;
        int round5;
        int round6;
        int round7;
        int round8;
        int round9;
        int round10;
        int round11;
        int round12;
        int round13;
        int round14;
        int round15;
        int round16;
        int round17;
        int vector;
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();

        //установка четырехпалубного корабля
        while (shipServiceImpl.findShipDeck(4) <= 0) {
            rand = integerList.get(count);
            vector = random.nextInt(2);
            if (rand >= 0 & rand <= 99) {
                int ver = rand / 10;
                int gor = rand % 10;
                if (vector == 0) {
                    if (ver < 7) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand - 1 + 20;
                        round4 = rand - 1 + 30;
                        round5 = rand - 1 + 40;
                        round6 = rand + 40;
                        round7 = rand + 40 + 1;
                        round8 = rand + 30 + 1;
                        round9 = rand + 20 + 1;
                        round10 = rand + 10 + 1;
                        round11 = rand + 1;
                        round12 = rand - 10 + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 10;
                        round16 = rand + 20;
                        round17 = rand + 30;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(round16)
                                    & integerList.contains(round17)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 1).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 2).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 3).getPointElementList().get(gor).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round4)) {
                                    integerList.remove(integerList.indexOf(round4));
                                }
                                if (integerList.contains(round5)) {
                                    integerList.remove(integerList.indexOf(round5));
                                }
                                if (integerList.contains(round6)) {
                                    integerList.remove(integerList.indexOf(round6));
                                }
                                if (integerList.contains(round7)) {
                                    integerList.remove(integerList.indexOf(round7));
                                }
                                if (integerList.contains(round8)) {
                                    integerList.remove(integerList.indexOf(round8));
                                }
                                if (integerList.contains(round9)) {
                                    integerList.remove(integerList.indexOf(round9));
                                }
                                if (integerList.contains(round10)) {
                                    integerList.remove(integerList.indexOf(round10));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                if (integerList.contains(round16)) {
                                    integerList.remove(integerList.indexOf(round16));
                                }
                                if (integerList.contains(round17)) {
                                    integerList.remove(integerList.indexOf(round17));
                                }
                                MinePanelSingleton.instance(panel);
                            }
                        }
                    }
                } else {
                    if (gor < 7) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand + 10;
                        round4 = rand + 10 + 1;
                        round5 = rand + 10 + 2;
                        round6 = rand + 10 + 3;
                        round7 = rand + 10 + 4;
                        round8 = rand + 4;
                        round9 = rand - 10 + 4;
                        round10 = rand - 10 + 3;
                        round11 = rand - 10 + 2;
                        round12 = rand - 10 + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 1;
                        round16 = rand + 2;
                        round17 = rand + 3;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(round16)
                                    & integerList.contains(round17)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 1).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 2).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 3).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round4)) {
                                    integerList.remove(integerList.indexOf(round4));
                                }
                                if (integerList.contains(round5)) {
                                    integerList.remove(integerList.indexOf(round5));
                                }
                                if (integerList.contains(round6)) {
                                    integerList.remove(integerList.indexOf(round6));
                                }
                                if (integerList.contains(round7)) {
                                    integerList.remove(integerList.indexOf(round7));
                                }
                                if (integerList.contains(round8)) {
                                    integerList.remove(integerList.indexOf(round8));
                                }
                                if (integerList.contains(round9)) {
                                    integerList.remove(integerList.indexOf(round9));
                                }
                                if (integerList.contains(round10)) {
                                    integerList.remove(integerList.indexOf(round10));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                if (integerList.contains(round16)) {
                                    integerList.remove(integerList.indexOf(round16));
                                }
                                if (integerList.contains(round17)) {
                                    integerList.remove(integerList.indexOf(round17));
                                }
                                MinePanelSingleton.instance(panel);
                            }

                        }
                    }

                }
            }
            count++;
        }
        count = 0;

        //расстановка трехпалубных кораблей
        while (shipServiceImpl.findShipDeck(3) <= 1) {
            rand = integerList.get(count);
            vector = random.nextInt(2);
            if (rand >= 0 & rand <= 99) {
                int ver = rand / 10;
                int gor = rand % 10;
                if (vector == 0) {
                    if (ver < 8) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand - 1 + 20;
                        round4 = rand - 1 + 30;
                        round6 = rand + 30;
                        round8 = rand + 30 + 1;
                        round9 = rand + 20 + 1;
                        round10 = rand + 10 + 1;
                        round11 = rand + 1;
                        round12 = rand - 10 + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 10;
                        round16 = rand + 20;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(round16)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 1).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 2).getPointElementList().get(gor).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round4)) {
                                    integerList.remove(integerList.indexOf(round4));
                                }
                                if (integerList.contains(round6)) {
                                    integerList.remove(integerList.indexOf(round6));
                                }
                                if (integerList.contains(round8)) {
                                    integerList.remove(integerList.indexOf(round8));
                                }
                                if (integerList.contains(round9)) {
                                    integerList.remove(integerList.indexOf(round9));
                                }
                                if (integerList.contains(round10)) {
                                    integerList.remove(integerList.indexOf(round10));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                if (integerList.contains(round16)) {
                                    integerList.remove(integerList.indexOf(round16));
                                }
                                MinePanelSingleton.instance(panel);
                            }
                        }
                    }
                } else {
                    if (gor < 8) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand + 10;
                        round4 = rand + 10 + 1;
                        round5 = rand + 10 + 2;
                        round6 = rand + 10 + 3;
                        round8 = rand + 3;
                        round10 = rand - 10 + 3;
                        round11 = rand - 10 + 2;
                        round12 = (rand - 10) + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 1;
                        round16 = rand + 2;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(round16)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 1).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 2).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round4)) {
                                    integerList.remove(integerList.indexOf(round4));
                                }
                                if (integerList.contains(round5)) {
                                    integerList.remove(integerList.indexOf(round5));
                                }
                                if (integerList.contains(round6)) {
                                    integerList.remove(integerList.indexOf(round6));
                                }
                                if (integerList.contains(round8)) {
                                    integerList.remove(integerList.indexOf(round8));
                                }
                                if (integerList.contains(round10)) {
                                    integerList.remove(integerList.indexOf(round10));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                if (integerList.contains(round16)) {
                                    integerList.remove(integerList.indexOf(round16));
                                }
                                MinePanelSingleton.instance(panel);
                            }
                        }
                    }
                }
            }
            count++;
        }
        count = 0;

        //расстановка двухпалубных кораблей
        while (shipServiceImpl.findShipDeck(2) <= 2) {
            rand = integerList.get(count);
            vector = random.nextInt(2);
            if (rand >= 0 & rand <= 99) {
                int ver = rand / 10;
                int gor = rand % 10;
                if (vector == 0) {
                    if (ver < 9) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand - 1 + 20;
                        round6 = rand + 20;
                        round9 = rand + 20 + 1;
                        round10 = rand + 10 + 1;
                        round11 = rand + 1;
                        round12 = rand - 10 + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 10;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver + 1).getPointElementList().get(gor).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round6)) {
                                    integerList.remove(integerList.indexOf(round6));
                                }
                                if (integerList.contains(round9)) {
                                    integerList.remove(integerList.indexOf(round9));
                                }
                                if (integerList.contains(round10)) {
                                    integerList.remove(integerList.indexOf(round10));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                MinePanelSingleton.instance(panel);
                            }
                        }
                    }
                } else {
                    if (gor < 9) {
                        round1 = rand - 1;
                        round2 = rand - 1 + 10;
                        round3 = rand + 10;
                        round4 = rand + 10 + 1;
                        round5 = rand + 10 + 2;
                        round8 = rand + 2;
                        round11 = rand - 10 + 2;
                        round12 = rand - 10 + 1;
                        round13 = rand - 10;
                        round14 = rand - 10 - 1;
                        round15 = rand + 1;
                        if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                            if (integerList.contains(round15)
                                    & integerList.contains(rand)) {
                                panel.get(ver).getPointElementList().get(gor).setValue(1);
                                panel.get(ver).getPointElementList().get(gor + 1).setValue(1);
                                if (integerList.contains(rand)) {
                                    integerList.remove(integerList.indexOf(rand));
                                }
                                if (integerList.contains(round1)) {
                                    integerList.remove(integerList.indexOf(round1));
                                }
                                if (integerList.contains(round2)) {
                                    integerList.remove(integerList.indexOf(round2));
                                }
                                if (integerList.contains(round3)) {
                                    integerList.remove(integerList.indexOf(round3));
                                }
                                if (integerList.contains(round4)) {
                                    integerList.remove(integerList.indexOf(round4));
                                }
                                if (integerList.contains(round5)) {
                                    integerList.remove(integerList.indexOf(round5));
                                }
                                if (integerList.contains(round8)) {
                                    integerList.remove(integerList.indexOf(round8));
                                }
                                if (integerList.contains(round11)) {
                                    integerList.remove(integerList.indexOf(round11));
                                }
                                if (integerList.contains(round12)) {
                                    integerList.remove(integerList.indexOf(round12));
                                }
                                if (integerList.contains(round13)) {
                                    integerList.remove(integerList.indexOf(round13));
                                }
                                if (integerList.contains(round14)) {
                                    integerList.remove(integerList.indexOf(round14));
                                }
                                if (integerList.contains(round15)) {
                                    integerList.remove(integerList.indexOf(round15));
                                }
                                MinePanelSingleton.instance(panel);
                            }

                        }
                    }
                }
            }
            count++;
        }
        count = 0;

        //расстановка однопалубных кораблей
        while (shipServiceImpl.findShipDeck(1) < 4) {
            rand = integerList.get(count);
            if (rand >= 0 & rand <= 99) {
                int ver = rand / 10;
                int gor = rand % 10;
                round1 = rand - 1;
                round2 = rand - 1 + 10;
                round6 = rand + 10;
                round10 = rand + 10 + 1;
                round11 = rand + 1;
                round12 = rand - 10 + 1;
                round13 = rand - 10;
                round14 = rand - 10 - 1;
                if (!isOccupiedCellOne(Constants.VERTICAL_COORDINATE.charAt(ver), gor)) {
                    if (integerList.contains(rand)) {
                        panel.get(ver).getPointElementList().get(gor).setValue(1);
                        if (integerList.contains(rand)) {
                            integerList.remove(integerList.indexOf(rand));
                        }
                        if (integerList.contains(round1)) {
                            integerList.remove(integerList.indexOf(round1));
                        }
                        if (integerList.contains(round2)) {
                            integerList.remove(integerList.indexOf(round2));
                        }
                        if (integerList.contains(round6)) {
                            integerList.remove(integerList.indexOf(round6));
                        }
                        if (integerList.contains(round10)) {
                            integerList.remove(integerList.indexOf(round10));
                        }
                        if (integerList.contains(round11)) {
                            integerList.remove(integerList.indexOf(round11));
                        }
                        if (integerList.contains(round12)) {
                            integerList.remove(integerList.indexOf(round12));
                        }
                        if (integerList.contains(round13)) {
                            integerList.remove(integerList.indexOf(round13));
                        }
                        if (integerList.contains(round14)) {
                            integerList.remove(integerList.indexOf(round14));
                        }
                        MinePanelSingleton.instance(panel);
                    }
                }
            }
            count++;
        }
        return MinePanelSingleton.instance(panel).getPanel();
    }

    /**
     * метод: isOccupiedCellOne
     * проверка ячейки игрового поля на занятость
     */
    public static boolean isOccupiedCellOne(char row, int col) {
        return MinePanelSingleton.instance(null).getPanel().stream().filter(i -> i.getRow() == row).
                flatMap(i -> i.getPointElementList().stream()).
                anyMatch(j -> j.getCol() == col & j.getValue() == 1);
    }
}