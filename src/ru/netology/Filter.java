package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();


        logger.log("Запускаем фильтрацию");
        for (Integer value : source) {
            if (value > threshold) {
                logger.log("Элемент \"" + value + "\" не проходит");
            } else {
                result.add(value);
                logger.log("Элемент \"" + value + "\" проходит");
            }
        }

        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }
}
