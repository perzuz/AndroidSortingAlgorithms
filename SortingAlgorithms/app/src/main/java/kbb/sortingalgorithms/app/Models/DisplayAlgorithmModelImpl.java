package kbb.sortingalgorithms.app.Models;

import java.util.ArrayList;

import kbb.sortingalgorithms.app.Helpers.DataOrganiser;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmModelImpl implements DisplayAlgorithmModel {
    private final DataOrganiser dataOrganiser;
    private ArrayList<Integer> defaultData;
    private String algorithmKey;

    public DisplayAlgorithmModelImpl(DataOrganiser dataOrganiser) {
        this.dataOrganiser = dataOrganiser;

        defaultData = new ArrayList<>();
        populateDefaultData();
    }

    @Override
    public String getTitleFromAlgorithmKey(String titleKey) {
        this.algorithmKey = titleKey;
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

    @Override
    public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> data) throws Exception {
        switch (algorithmKey){
            case("bubble_sort"):
                return  dataOrganiser.bubbleSort(data);
            default:
                throw new Exception("algorithm key not matched to any available algorithms");
        }
    }

    private void populateDefaultData() {
        for (int i = 1; i <= 100; i++) {
            defaultData.add(i);
        }
    }
}
