package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomCounter {
    Map<String, Integer> count();
    void show();
}
