package kbb.sortingalgorithms.app.Helpers;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * Created by Harris on 23/05/2017.
 */

public class DisplayAlgorithmHelper {
    private DisplayAlgorithmHelper(){}

    public static BarData convertIntegerArrayListToBarData(ArrayList<Integer> data) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            entries.add(new BarEntry(i, data.get(i)));
            labels.add(String.valueOf(data.get(i)));
        }
        BarDataSet dataSet = new BarDataSet(entries,"Values");

        return new BarData(dataSet);
    }
}
