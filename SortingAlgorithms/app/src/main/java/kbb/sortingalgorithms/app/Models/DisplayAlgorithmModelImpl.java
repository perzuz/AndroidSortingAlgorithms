package kbb.sortingalgorithms.app.Models;

import java.util.ArrayList;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmModelImpl implements DisplayAlgorithmModel {
    private ArrayList<Integer> defaultData;

    public DisplayAlgorithmModelImpl(){
        defaultData = new ArrayList<>();
        populateDefaultData();
    }

    @Override
    public String getTitleFromAlgorithmKey(String titleKey) {
        return titleKey.replaceAll("_", " ");
    }

    @Override
    public ArrayList<Integer> getDefaultData() {
        return defaultData;
    }

    private void populateDefaultData() {
        for (int i = 1; i <= 100; i++){
            defaultData.add(i);
        }
    }
}
