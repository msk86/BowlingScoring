package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static <T> List<T> subList(List<T> list, int start) {
        if(list.size() <= start) {
            return new ArrayList<>();
        } else {
            return list.subList(start, list.size());
        }
    }
}
