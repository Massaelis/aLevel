package com.prodius.container;

import com.prodius.model.Car;
import java.util.Comparator;

public class CarComparator<T extends Car> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1 != null && o2 != null) {
            int result = 0;
            if(o1.getCount() > o2.getCount()) {
                result = 1;
            } else if(o1.getCount() < o2.getCount()){
                result = -1;
            }
            return result;
        }
        return -2;
    }
}