package edu.javagroup.seabattle.common.utils.impl;

import edu.javagroup.seabattle.common.utils.CommonService;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kaa
 * @version 1.2
 */
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public List<HorizontalLine> getPanel00() {
        List<HorizontalLine> horizontalLineList = new ArrayList<>();

        List<PointElement> pointElementList1 = new ArrayList<>();
        pointElementList1.add(new PointElement(1, 0));
        pointElementList1.add(new PointElement(2, 0));
        pointElementList1.add(new PointElement(3, 0));
        pointElementList1.add(new PointElement(4, 0));
        pointElementList1.add(new PointElement(5, 0));
        pointElementList1.add(new PointElement(6, 0));
        pointElementList1.add(new PointElement(7, 0));
        pointElementList1.add(new PointElement(8, 0));
        pointElementList1.add(new PointElement(9, 0));
        pointElementList1.add(new PointElement(10, 0));
        HorizontalLine horizontalLine1 = new HorizontalLine('A');
        horizontalLine1.setPointElementList(pointElementList1);
        horizontalLineList.add(horizontalLine1);

        List<PointElement> pointElementList2 = new ArrayList<>();
        pointElementList2.add(new PointElement(1, 0));
        pointElementList2.add(new PointElement(2, 0));
        pointElementList2.add(new PointElement(3, 0));
        pointElementList2.add(new PointElement(4, 0));
        pointElementList2.add(new PointElement(5, 0));
        pointElementList2.add(new PointElement(6, 0));
        pointElementList2.add(new PointElement(7, 0));
        pointElementList2.add(new PointElement(8, 0));
        pointElementList2.add(new PointElement(9, 0));
        pointElementList2.add(new PointElement(10, 0));
        HorizontalLine horizontalLine2 = new HorizontalLine('B');
        horizontalLine2.setPointElementList(pointElementList2);
        horizontalLineList.add(horizontalLine2);

        List<PointElement> pointElementList3 = new ArrayList<>();
        pointElementList3.add(new PointElement(1, 0));
        pointElementList3.add(new PointElement(2, 0));
        pointElementList3.add(new PointElement(3, 0));
        pointElementList3.add(new PointElement(4, 0));
        pointElementList3.add(new PointElement(5, 0));
        pointElementList3.add(new PointElement(6, 0));
        pointElementList3.add(new PointElement(7, 0));
        pointElementList3.add(new PointElement(8, 0));
        pointElementList3.add(new PointElement(9, 0));
        pointElementList3.add(new PointElement(10, 0));
        HorizontalLine horizontalLine3 = new HorizontalLine('C');
        horizontalLine3.setPointElementList(pointElementList3);
        horizontalLineList.add(horizontalLine3);

        List<PointElement> pointElementList4 = new ArrayList<>();
        pointElementList4.add(new PointElement(1, 0));
        pointElementList4.add(new PointElement(2, 0));
        pointElementList4.add(new PointElement(3, 0));
        pointElementList4.add(new PointElement(4, 0));
        pointElementList4.add(new PointElement(5, 0));
        pointElementList4.add(new PointElement(6, 0));
        pointElementList4.add(new PointElement(7, 0));
        pointElementList4.add(new PointElement(8, 0));
        pointElementList4.add(new PointElement(9, 0));
        pointElementList4.add(new PointElement(10, 0));
        HorizontalLine horizontalLine4 = new HorizontalLine('D');
        horizontalLine4.setPointElementList(pointElementList4);
        horizontalLineList.add(horizontalLine4);

        List<PointElement> pointElementList5 = new ArrayList<>();
        pointElementList5.add(new PointElement(1, 0));
        pointElementList5.add(new PointElement(2, 0));
        pointElementList5.add(new PointElement(3, 0));
        pointElementList5.add(new PointElement(4, 0));
        pointElementList5.add(new PointElement(5, 0));
        pointElementList5.add(new PointElement(6, 0));
        pointElementList5.add(new PointElement(7, 0));
        pointElementList5.add(new PointElement(8, 0));
        pointElementList5.add(new PointElement(9, 0));
        pointElementList5.add(new PointElement(10, 0));
        HorizontalLine horizontalLine5 = new HorizontalLine('E');
        horizontalLine5.setPointElementList(pointElementList5);
        horizontalLineList.add(horizontalLine5);

        List<PointElement> pointElementList6 = new ArrayList<>();
        pointElementList6.add(new PointElement(1, 0));
        pointElementList6.add(new PointElement(2, 0));
        pointElementList6.add(new PointElement(3, 0));
        pointElementList6.add(new PointElement(4, 0));
        pointElementList6.add(new PointElement(5, 0));
        pointElementList6.add(new PointElement(6, 0));
        pointElementList6.add(new PointElement(7, 0));
        pointElementList6.add(new PointElement(8, 0));
        pointElementList6.add(new PointElement(9, 0));
        pointElementList6.add(new PointElement(10, 0));
        HorizontalLine horizontalLine6 = new HorizontalLine('F');
        horizontalLine6.setPointElementList(pointElementList6);
        horizontalLineList.add(horizontalLine6);

        List<PointElement> pointElementList7 = new ArrayList<>();
        pointElementList7.add(new PointElement(1, 0));
        pointElementList7.add(new PointElement(2, 0));
        pointElementList7.add(new PointElement(3, 0));
        pointElementList7.add(new PointElement(4, 0));
        pointElementList7.add(new PointElement(5, 0));
        pointElementList7.add(new PointElement(6, 0));
        pointElementList7.add(new PointElement(7, 0));
        pointElementList7.add(new PointElement(8, 0));
        pointElementList7.add(new PointElement(9, 0));
        pointElementList7.add(new PointElement(10, 0));
        HorizontalLine horizontalLine7 = new HorizontalLine('G');
        horizontalLine7.setPointElementList(pointElementList7);
        horizontalLineList.add(horizontalLine7);

        List<PointElement> pointElementList8 = new ArrayList<>();
        pointElementList8.add(new PointElement(1, 0));
        pointElementList8.add(new PointElement(2, 0));
        pointElementList8.add(new PointElement(3, 0));
        pointElementList8.add(new PointElement(4, 0));
        pointElementList8.add(new PointElement(5, 0));
        pointElementList8.add(new PointElement(6, 0));
        pointElementList8.add(new PointElement(7, 0));
        pointElementList8.add(new PointElement(8, 0));
        pointElementList8.add(new PointElement(9, 0));
        pointElementList8.add(new PointElement(10, 0));
        HorizontalLine horizontalLine8 = new HorizontalLine('H');
        horizontalLine8.setPointElementList(pointElementList8);
        horizontalLineList.add(horizontalLine8);

        List<PointElement> pointElementList9 = new ArrayList<>();
        pointElementList9.add(new PointElement(1, 0));
        pointElementList9.add(new PointElement(2, 0));
        pointElementList9.add(new PointElement(3, 0));
        pointElementList9.add(new PointElement(4, 0));
        pointElementList9.add(new PointElement(5, 0));
        pointElementList9.add(new PointElement(6, 0));
        pointElementList9.add(new PointElement(7, 0));
        pointElementList9.add(new PointElement(8, 0));
        pointElementList9.add(new PointElement(9, 0));
        pointElementList9.add(new PointElement(10, 0));
        HorizontalLine horizontalLine9 = new HorizontalLine('I');
        horizontalLine9.setPointElementList(pointElementList9);
        horizontalLineList.add(horizontalLine9);

        List<PointElement> pointElementList10 = new ArrayList<>();
        pointElementList10.add(new PointElement(1, 0));
        pointElementList10.add(new PointElement(2, 0));
        pointElementList10.add(new PointElement(3, 0));
        pointElementList10.add(new PointElement(4, 0));
        pointElementList10.add(new PointElement(5, 0));
        pointElementList10.add(new PointElement(6, 0));
        pointElementList10.add(new PointElement(7, 0));
        pointElementList10.add(new PointElement(8, 0));
        pointElementList10.add(new PointElement(9, 0));
        pointElementList10.add(new PointElement(10, 0));
        HorizontalLine horizontalLine10 = new HorizontalLine('J');
        horizontalLine10.setPointElementList(pointElementList10);
        horizontalLineList.add(horizontalLine10);

        return horizontalLineList;
    }

    @Override
    public List<HorizontalLine> getPanel19() {
        List<HorizontalLine> horizontalLineList = new ArrayList<>();

        List<PointElement> pointElementList1 = new ArrayList<>();
        pointElementList1.add(new PointElement(1, 1));
        pointElementList1.add(new PointElement(2, 0));
        pointElementList1.add(new PointElement(3, 1));
        pointElementList1.add(new PointElement(4, 1));
        pointElementList1.add(new PointElement(5, 1));
        pointElementList1.add(new PointElement(6, 0));
        pointElementList1.add(new PointElement(7, 1));
        pointElementList1.add(new PointElement(8, 1));
        pointElementList1.add(new PointElement(9, 0));
        pointElementList1.add(new PointElement(10, 1));
        HorizontalLine horizontalLine1 = new HorizontalLine('A');
        horizontalLine1.setPointElementList(pointElementList1);
        horizontalLineList.add(horizontalLine1);

        List<PointElement> pointElementList2 = new ArrayList<>();
        pointElementList2.add(new PointElement(1, 1));
        pointElementList2.add(new PointElement(2, 0));
        pointElementList2.add(new PointElement(3, 0));
        pointElementList2.add(new PointElement(4, 0));
        pointElementList2.add(new PointElement(5, 0));
        pointElementList2.add(new PointElement(6, 0));
        pointElementList2.add(new PointElement(7, 0));
        pointElementList2.add(new PointElement(8, 0));
        pointElementList2.add(new PointElement(9, 0));
        pointElementList2.add(new PointElement(10, 0));
        HorizontalLine horizontalLine2 = new HorizontalLine('B');
        horizontalLine2.setPointElementList(pointElementList2);
        horizontalLineList.add(horizontalLine2);

        List<PointElement> pointElementList3 = new ArrayList<>();
        pointElementList3.add(new PointElement(1, 1));
        pointElementList3.add(new PointElement(2, 0));
        pointElementList3.add(new PointElement(3, 1));
        pointElementList3.add(new PointElement(4, 1));
        pointElementList3.add(new PointElement(5, 1));
        pointElementList3.add(new PointElement(6, 0));
        pointElementList3.add(new PointElement(7, 1));
        pointElementList3.add(new PointElement(8, 1));
        pointElementList3.add(new PointElement(9, 0));
        pointElementList3.add(new PointElement(10, 1));
        HorizontalLine horizontalLine3 = new HorizontalLine('C');
        horizontalLine3.setPointElementList(pointElementList3);
        horizontalLineList.add(horizontalLine3);

        List<PointElement> pointElementList4 = new ArrayList<>();
        pointElementList4.add(new PointElement(1, 1));
        pointElementList4.add(new PointElement(2, 0));
        pointElementList4.add(new PointElement(3, 0));
        pointElementList4.add(new PointElement(4, 0));
        pointElementList4.add(new PointElement(5, 0));
        pointElementList4.add(new PointElement(6, 0));
        pointElementList4.add(new PointElement(7, 0));
        pointElementList4.add(new PointElement(8, 0));
        pointElementList4.add(new PointElement(9, 0));
        pointElementList4.add(new PointElement(10, 0));
        HorizontalLine horizontalLine4 = new HorizontalLine('D');
        horizontalLine4.setPointElementList(pointElementList4);
        horizontalLineList.add(horizontalLine4);

        List<PointElement> pointElementList5 = new ArrayList<>();
        pointElementList5.add(new PointElement(1, 0));
        pointElementList5.add(new PointElement(2, 0));
        pointElementList5.add(new PointElement(3, 1));
        pointElementList5.add(new PointElement(4, 0));
        pointElementList5.add(new PointElement(5, 0));
        pointElementList5.add(new PointElement(6, 1));
        pointElementList5.add(new PointElement(7, 0));
        pointElementList5.add(new PointElement(8, 0));
        pointElementList5.add(new PointElement(9, 0));
        pointElementList5.add(new PointElement(10, 0));
        HorizontalLine horizontalLine5 = new HorizontalLine('E');
        horizontalLine5.setPointElementList(pointElementList5);
        horizontalLineList.add(horizontalLine5);

        List<PointElement> pointElementList6 = new ArrayList<>();
        pointElementList6.add(new PointElement(1, 1));
        pointElementList6.add(new PointElement(2, 0));
        pointElementList6.add(new PointElement(3, 0));
        pointElementList6.add(new PointElement(4, 0));
        pointElementList6.add(new PointElement(5, 0));
        pointElementList6.add(new PointElement(6, 0));
        pointElementList6.add(new PointElement(7, 0));
        pointElementList6.add(new PointElement(8, 0));
        pointElementList6.add(new PointElement(9, 0));
        pointElementList6.add(new PointElement(10, 0));
        HorizontalLine horizontalLine6 = new HorizontalLine('F');
        horizontalLine6.setPointElementList(pointElementList6);
        horizontalLineList.add(horizontalLine6);

        List<PointElement> pointElementList7 = new ArrayList<>();
        pointElementList7.add(new PointElement(1, 0));
        pointElementList7.add(new PointElement(2, 0));
        pointElementList7.add(new PointElement(3, 0));
        pointElementList7.add(new PointElement(4, 0));
        pointElementList7.add(new PointElement(5, 0));
        pointElementList7.add(new PointElement(6, 0));
        pointElementList7.add(new PointElement(7, 0));
        pointElementList7.add(new PointElement(8, 0));
        pointElementList7.add(new PointElement(9, 0));
        pointElementList7.add(new PointElement(10, 0));
        HorizontalLine horizontalLine7 = new HorizontalLine('G');
        horizontalLine7.setPointElementList(pointElementList7);
        horizontalLineList.add(horizontalLine7);

        List<PointElement> pointElementList8 = new ArrayList<>();
        pointElementList8.add(new PointElement(1, 0));
        pointElementList8.add(new PointElement(2, 0));
        pointElementList8.add(new PointElement(3, 0));
        pointElementList8.add(new PointElement(4, 0));
        pointElementList8.add(new PointElement(5, 0));
        pointElementList8.add(new PointElement(6, 0));
        pointElementList8.add(new PointElement(7, 0));
        pointElementList8.add(new PointElement(8, 0));
        pointElementList8.add(new PointElement(9, 0));
        pointElementList8.add(new PointElement(10, 0));
        HorizontalLine horizontalLine8 = new HorizontalLine('H');
        horizontalLine8.setPointElementList(pointElementList8);
        horizontalLineList.add(horizontalLine8);

        List<PointElement> pointElementList9 = new ArrayList<>();
        pointElementList9.add(new PointElement(1, 0));
        pointElementList9.add(new PointElement(2, 0));
        pointElementList9.add(new PointElement(3, 0));
        pointElementList9.add(new PointElement(4, 0));
        pointElementList9.add(new PointElement(5, 0));
        pointElementList9.add(new PointElement(6, 0));
        pointElementList9.add(new PointElement(7, 0));
        pointElementList9.add(new PointElement(8, 0));
        pointElementList9.add(new PointElement(9, 0));
        pointElementList9.add(new PointElement(10, 0));
        HorizontalLine horizontalLine9 = new HorizontalLine('I');
        horizontalLine9.setPointElementList(pointElementList9);
        horizontalLineList.add(horizontalLine9);

        List<PointElement> pointElementList10 = new ArrayList<>();
        pointElementList10.add(new PointElement(1, 0));
        pointElementList10.add(new PointElement(2, 0));
        pointElementList10.add(new PointElement(3, 0));
        pointElementList10.add(new PointElement(4, 0));
        pointElementList10.add(new PointElement(5, 0));
        pointElementList10.add(new PointElement(6, 0));
        pointElementList10.add(new PointElement(7, 0));
        pointElementList10.add(new PointElement(8, 0));
        pointElementList10.add(new PointElement(9, 0));
        pointElementList10.add(new PointElement(10, 0));
        HorizontalLine horizontalLine10 = new HorizontalLine('J');
        horizontalLine10.setPointElementList(pointElementList10);
        horizontalLineList.add(horizontalLine10);

        return horizontalLineList;
    }

    @Override
    public List<HorizontalLine> getPanel20() {
        List<HorizontalLine> horizontalLineList = new ArrayList<>();

        List<PointElement> pointElementList1 = new ArrayList<>();
        pointElementList1.add(new PointElement(1, 1));
        pointElementList1.add(new PointElement(2, 0));
        pointElementList1.add(new PointElement(3, 1));
        pointElementList1.add(new PointElement(4, 1));
        pointElementList1.add(new PointElement(5, 1));
        pointElementList1.add(new PointElement(6, 0));
        pointElementList1.add(new PointElement(7, 1));
        pointElementList1.add(new PointElement(8, 1));
        pointElementList1.add(new PointElement(9, 0));
        pointElementList1.add(new PointElement(10, 1));
        HorizontalLine horizontalLine1 = new HorizontalLine('A');
        horizontalLine1.setPointElementList(pointElementList1);
        horizontalLineList.add(horizontalLine1);

        List<PointElement> pointElementList2 = new ArrayList<>();
        pointElementList2.add(new PointElement(1, 1));
        pointElementList2.add(new PointElement(2, 0));
        pointElementList2.add(new PointElement(3, 0));
        pointElementList2.add(new PointElement(4, 0));
        pointElementList2.add(new PointElement(5, 0));
        pointElementList2.add(new PointElement(6, 0));
        pointElementList2.add(new PointElement(7, 0));
        pointElementList2.add(new PointElement(8, 0));
        pointElementList2.add(new PointElement(9, 0));
        pointElementList2.add(new PointElement(10, 0));
        HorizontalLine horizontalLine2 = new HorizontalLine('B');
        horizontalLine2.setPointElementList(pointElementList2);
        horizontalLineList.add(horizontalLine2);

        List<PointElement> pointElementList3 = new ArrayList<>();
        pointElementList3.add(new PointElement(1, 1));
        pointElementList3.add(new PointElement(2, 0));
        pointElementList3.add(new PointElement(3, 1));
        pointElementList3.add(new PointElement(4, 1));
        pointElementList3.add(new PointElement(5, 1));
        pointElementList3.add(new PointElement(6, 0));
        pointElementList3.add(new PointElement(7, 1));
        pointElementList3.add(new PointElement(8, 1));
        pointElementList3.add(new PointElement(9, 0));
        pointElementList3.add(new PointElement(10, 1));
        HorizontalLine horizontalLine3 = new HorizontalLine('C');
        horizontalLine3.setPointElementList(pointElementList3);
        horizontalLineList.add(horizontalLine3);

        List<PointElement> pointElementList4 = new ArrayList<>();
        pointElementList4.add(new PointElement(1, 1));
        pointElementList4.add(new PointElement(2, 0));
        pointElementList4.add(new PointElement(3, 0));
        pointElementList4.add(new PointElement(4, 0));
        pointElementList4.add(new PointElement(5, 0));
        pointElementList4.add(new PointElement(6, 0));
        pointElementList4.add(new PointElement(7, 0));
        pointElementList4.add(new PointElement(8, 0));
        pointElementList4.add(new PointElement(9, 0));
        pointElementList4.add(new PointElement(10, 0));
        HorizontalLine horizontalLine4 = new HorizontalLine('D');
        horizontalLine4.setPointElementList(pointElementList4);
        horizontalLineList.add(horizontalLine4);

        List<PointElement> pointElementList5 = new ArrayList<>();
        pointElementList5.add(new PointElement(1, 0));
        pointElementList5.add(new PointElement(2, 0));
        pointElementList5.add(new PointElement(3, 1));
        pointElementList5.add(new PointElement(4, 0));
        pointElementList5.add(new PointElement(5, 0));
        pointElementList5.add(new PointElement(6, 1));
        pointElementList5.add(new PointElement(7, 0));
        pointElementList5.add(new PointElement(8, 0));
        pointElementList5.add(new PointElement(9, 0));
        pointElementList5.add(new PointElement(10, 0));
        HorizontalLine horizontalLine5 = new HorizontalLine('E');
        horizontalLine5.setPointElementList(pointElementList5);
        horizontalLineList.add(horizontalLine5);

        List<PointElement> pointElementList6 = new ArrayList<>();
        pointElementList6.add(new PointElement(1, 1));
        pointElementList6.add(new PointElement(2, 0));
        pointElementList6.add(new PointElement(3, 0));
        pointElementList6.add(new PointElement(4, 0));
        pointElementList6.add(new PointElement(5, 0));
        pointElementList6.add(new PointElement(6, 0));
        pointElementList6.add(new PointElement(7, 0));
        pointElementList6.add(new PointElement(8, 0));
        pointElementList6.add(new PointElement(9, 0));
        pointElementList6.add(new PointElement(10, 0));
        HorizontalLine horizontalLine6 = new HorizontalLine('F');
        horizontalLine6.setPointElementList(pointElementList6);
        horizontalLineList.add(horizontalLine6);

        List<PointElement> pointElementList7 = new ArrayList<>();
        pointElementList7.add(new PointElement(1, 1));
        pointElementList7.add(new PointElement(2, 0));
        pointElementList7.add(new PointElement(3, 0));
        pointElementList7.add(new PointElement(4, 0));
        pointElementList7.add(new PointElement(5, 0));
        pointElementList7.add(new PointElement(6, 0));
        pointElementList7.add(new PointElement(7, 0));
        pointElementList7.add(new PointElement(8, 0));
        pointElementList7.add(new PointElement(9, 0));
        pointElementList7.add(new PointElement(10, 0));
        HorizontalLine horizontalLine7 = new HorizontalLine('G');
        horizontalLine7.setPointElementList(pointElementList7);
        horizontalLineList.add(horizontalLine7);

        List<PointElement> pointElementList8 = new ArrayList<>();
        pointElementList8.add(new PointElement(1, 0));
        pointElementList8.add(new PointElement(2, 0));
        pointElementList8.add(new PointElement(3, 0));
        pointElementList8.add(new PointElement(4, 0));
        pointElementList8.add(new PointElement(5, 0));
        pointElementList8.add(new PointElement(6, 0));
        pointElementList8.add(new PointElement(7, 0));
        pointElementList8.add(new PointElement(8, 0));
        pointElementList8.add(new PointElement(9, 0));
        pointElementList8.add(new PointElement(10, 0));
        HorizontalLine horizontalLine8 = new HorizontalLine('H');
        horizontalLine8.setPointElementList(pointElementList8);
        horizontalLineList.add(horizontalLine8);

        List<PointElement> pointElementList9 = new ArrayList<>();
        pointElementList9.add(new PointElement(1, 0));
        pointElementList9.add(new PointElement(2, 0));
        pointElementList9.add(new PointElement(3, 0));
        pointElementList9.add(new PointElement(4, 0));
        pointElementList9.add(new PointElement(5, 0));
        pointElementList9.add(new PointElement(6, 0));
        pointElementList9.add(new PointElement(7, 0));
        pointElementList9.add(new PointElement(8, 0));
        pointElementList9.add(new PointElement(9, 0));
        pointElementList9.add(new PointElement(10, 0));
        HorizontalLine horizontalLine9 = new HorizontalLine('I');
        horizontalLine9.setPointElementList(pointElementList9);
        horizontalLineList.add(horizontalLine9);

        List<PointElement> pointElementList10 = new ArrayList<>();
        pointElementList10.add(new PointElement(1, 0));
        pointElementList10.add(new PointElement(2, 0));
        pointElementList10.add(new PointElement(3, 0));
        pointElementList10.add(new PointElement(4, 0));
        pointElementList10.add(new PointElement(5, 0));
        pointElementList10.add(new PointElement(6, 0));
        pointElementList10.add(new PointElement(7, 0));
        pointElementList10.add(new PointElement(8, 0));
        pointElementList10.add(new PointElement(9, 0));
        pointElementList10.add(new PointElement(10, 0));
        HorizontalLine horizontalLine10 = new HorizontalLine('J');
        horizontalLine10.setPointElementList(pointElementList10);
        horizontalLineList.add(horizontalLine10);

        return horizontalLineList;
    }

    @Override
    public List<HorizontalLine> getPanel22() {
        List<HorizontalLine> horizontalLineList = new ArrayList<>();

        List<PointElement> pointElementList1 = new ArrayList<>();
        pointElementList1.add(new PointElement(1, 2));
        pointElementList1.add(new PointElement(2, 0));
        pointElementList1.add(new PointElement(3, 2));
        pointElementList1.add(new PointElement(4, 2));
        pointElementList1.add(new PointElement(5, 2));
        pointElementList1.add(new PointElement(6, 0));
        pointElementList1.add(new PointElement(7, 2));
        pointElementList1.add(new PointElement(8, 2));
        pointElementList1.add(new PointElement(9, 0));
        pointElementList1.add(new PointElement(10, 2));
        HorizontalLine horizontalLine1 = new HorizontalLine('A');
        horizontalLine1.setPointElementList(pointElementList1);
        horizontalLineList.add(horizontalLine1);

        List<PointElement> pointElementList2 = new ArrayList<>();
        pointElementList2.add(new PointElement(1, 2));
        pointElementList2.add(new PointElement(2, 0));
        pointElementList2.add(new PointElement(3, 0));
        pointElementList2.add(new PointElement(4, 0));
        pointElementList2.add(new PointElement(5, 0));
        pointElementList2.add(new PointElement(6, 0));
        pointElementList2.add(new PointElement(7, 0));
        pointElementList2.add(new PointElement(8, 0));
        pointElementList2.add(new PointElement(9, 0));
        pointElementList2.add(new PointElement(10, 0));
        HorizontalLine horizontalLine2 = new HorizontalLine('B');
        horizontalLine2.setPointElementList(pointElementList2);
        horizontalLineList.add(horizontalLine2);

        List<PointElement> pointElementList3 = new ArrayList<>();
        pointElementList3.add(new PointElement(1, 2));
        pointElementList3.add(new PointElement(2, 0));
        pointElementList3.add(new PointElement(3, 2));
        pointElementList3.add(new PointElement(4, 2));
        pointElementList3.add(new PointElement(5, 2));
        pointElementList3.add(new PointElement(6, 0));
        pointElementList3.add(new PointElement(7, 2));
        pointElementList3.add(new PointElement(8, 2));
        pointElementList3.add(new PointElement(9, 0));
        pointElementList3.add(new PointElement(10, 2));
        HorizontalLine horizontalLine3 = new HorizontalLine('C');
        horizontalLine3.setPointElementList(pointElementList3);
        horizontalLineList.add(horizontalLine3);

        List<PointElement> pointElementList4 = new ArrayList<>();
        pointElementList4.add(new PointElement(1, 2));
        pointElementList4.add(new PointElement(2, 0));
        pointElementList4.add(new PointElement(3, 0));
        pointElementList4.add(new PointElement(4, 0));
        pointElementList4.add(new PointElement(5, 0));
        pointElementList4.add(new PointElement(6, 0));
        pointElementList4.add(new PointElement(7, 0));
        pointElementList4.add(new PointElement(8, 0));
        pointElementList4.add(new PointElement(9, 0));
        pointElementList4.add(new PointElement(10, 0));
        HorizontalLine horizontalLine4 = new HorizontalLine('D');
        horizontalLine4.setPointElementList(pointElementList4);
        horizontalLineList.add(horizontalLine4);

        List<PointElement> pointElementList5 = new ArrayList<>();
        pointElementList5.add(new PointElement(1, 0));
        pointElementList5.add(new PointElement(2, 0));
        pointElementList5.add(new PointElement(3, 2));
        pointElementList5.add(new PointElement(4, 0));
        pointElementList5.add(new PointElement(5, 0));
        pointElementList5.add(new PointElement(6, 2));
        pointElementList5.add(new PointElement(7, 0));
        pointElementList5.add(new PointElement(8, 0));
        pointElementList5.add(new PointElement(9, 0));
        pointElementList5.add(new PointElement(10, 0));
        HorizontalLine horizontalLine5 = new HorizontalLine('E');
        horizontalLine5.setPointElementList(pointElementList5);
        horizontalLineList.add(horizontalLine5);

        List<PointElement> pointElementList6 = new ArrayList<>();
        pointElementList6.add(new PointElement(1, 2));
        pointElementList6.add(new PointElement(2, 0));
        pointElementList6.add(new PointElement(3, 0));
        pointElementList6.add(new PointElement(4, 0));
        pointElementList6.add(new PointElement(5, 0));
        pointElementList6.add(new PointElement(6, 0));
        pointElementList6.add(new PointElement(7, 0));
        pointElementList6.add(new PointElement(8, 0));
        pointElementList6.add(new PointElement(9, 0));
        pointElementList6.add(new PointElement(10, 0));
        HorizontalLine horizontalLine6 = new HorizontalLine('F');
        horizontalLine6.setPointElementList(pointElementList6);
        horizontalLineList.add(horizontalLine6);

        List<PointElement> pointElementList7 = new ArrayList<>();
        pointElementList7.add(new PointElement(1, 2));
        pointElementList7.add(new PointElement(2, 0));
        pointElementList7.add(new PointElement(3, 0));
        pointElementList7.add(new PointElement(4, 0));
        pointElementList7.add(new PointElement(5, 0));
        pointElementList7.add(new PointElement(6, 0));
        pointElementList7.add(new PointElement(7, 0));
        pointElementList7.add(new PointElement(8, 0));
        pointElementList7.add(new PointElement(9, 0));
        pointElementList7.add(new PointElement(10, 0));
        HorizontalLine horizontalLine7 = new HorizontalLine('G');
        horizontalLine7.setPointElementList(pointElementList7);
        horizontalLineList.add(horizontalLine7);

        List<PointElement> pointElementList8 = new ArrayList<>();
        pointElementList8.add(new PointElement(1, 0));
        pointElementList8.add(new PointElement(2, 0));
        pointElementList8.add(new PointElement(3, 0));
        pointElementList8.add(new PointElement(4, 0));
        pointElementList8.add(new PointElement(5, 0));
        pointElementList8.add(new PointElement(6, 0));
        pointElementList8.add(new PointElement(7, 0));
        pointElementList8.add(new PointElement(8, 0));
        pointElementList8.add(new PointElement(9, 0));
        pointElementList8.add(new PointElement(10, 0));
        HorizontalLine horizontalLine8 = new HorizontalLine('H');
        horizontalLine8.setPointElementList(pointElementList8);
        horizontalLineList.add(horizontalLine8);

        List<PointElement> pointElementList9 = new ArrayList<>();
        pointElementList9.add(new PointElement(1, 0));
        pointElementList9.add(new PointElement(2, 0));
        pointElementList9.add(new PointElement(3, 0));
        pointElementList9.add(new PointElement(4, 0));
        pointElementList9.add(new PointElement(5, 0));
        pointElementList9.add(new PointElement(6, 0));
        pointElementList9.add(new PointElement(7, 0));
        pointElementList9.add(new PointElement(8, 0));
        pointElementList9.add(new PointElement(9, 0));
        pointElementList9.add(new PointElement(10, 0));
        HorizontalLine horizontalLine9 = new HorizontalLine('I');
        horizontalLine9.setPointElementList(pointElementList9);
        horizontalLineList.add(horizontalLine9);

        List<PointElement> pointElementList10 = new ArrayList<>();
        pointElementList10.add(new PointElement(1, 0));
        pointElementList10.add(new PointElement(2, 0));
        pointElementList10.add(new PointElement(3, 0));
        pointElementList10.add(new PointElement(4, 0));
        pointElementList10.add(new PointElement(5, 0));
        pointElementList10.add(new PointElement(6, 0));
        pointElementList10.add(new PointElement(7, 0));
        pointElementList10.add(new PointElement(8, 0));
        pointElementList10.add(new PointElement(9, 0));
        pointElementList10.add(new PointElement(10, 0));
        HorizontalLine horizontalLine10 = new HorizontalLine('J');
        horizontalLine10.setPointElementList(pointElementList10);
        horizontalLineList.add(horizontalLine10);

        return horizontalLineList;
    }

    @Override
    public Map<String, Boolean> getForbidden00() {
        return new HashMap<>(0);
    }

    @Override
    public Map<String, Boolean> getForbidden05() {
        Map<String, Boolean> map = new HashMap<>(5);
        map.put("A01", true);
        map.put("A03", true);
        map.put("B02", true);
        map.put("C01", true);
        map.put("C03", true);
        return map;
    }
}
