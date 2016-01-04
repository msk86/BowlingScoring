package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static <T> List<T> subList(List<T> list, int start, int size) {
        if(list.size() <= start) {
            return new ArrayList<>();
        } else if(list.size() > start + size) {
            return list.subList(start, start + size);
        } else {
            return list.subList(start, list.size());
        }
    }
}
