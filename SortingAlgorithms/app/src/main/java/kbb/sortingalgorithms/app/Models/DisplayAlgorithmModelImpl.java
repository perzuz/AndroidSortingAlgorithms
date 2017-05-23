package kbb.sortingalgorithms.app.Models;

import java.util.ArrayList;

import kbb.sortingalgorithms.app.Helpers.DataOrganiser;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmModelImpl implements DisplayAlgorithmModel {
    private final DataOrganiser dataOrganiser;
    private ArrayList<Integer> defaultData;

    public DisplayAlgorithmModelImpl(DataOrganiser dataOrganiser) {
        this.dataOrganiser = dataOrganiser;

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

    @Override
    public ArrayList<Integer> shuffleData(ArrayList<Integer> data) {
        return dataOrganiser.shuffle(data);
    }

    private void populateDefaultData() {
        for (int i = 1; i <= 100; i++) {
            defaultData.add(i);
        }
    }
}
