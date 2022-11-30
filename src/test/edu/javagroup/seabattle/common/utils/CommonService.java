package edu.javagroup.seabattle.common.utils;

import edu.javagroup.seabattle.model.HorizontalLine;

import java.util.List;
import java.util.Map;

/**
 * @author kaa
 * @version 1.2
 */
public interface CommonService {

    List<HorizontalLine> getPanel00();

    List<HorizontalLine> getPanel19();

    List<HorizontalLine> getPanel20();

    List<HorizontalLine> getPanel22();

    Map<String, Boolean> getForbidden00();

    Map<String, Boolean> getForbidden05();
}
