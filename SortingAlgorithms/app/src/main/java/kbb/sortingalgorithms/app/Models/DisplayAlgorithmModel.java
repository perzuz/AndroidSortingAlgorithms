package kbb.sortingalgorithms.app.Models;

import java.util.ArrayList;

/**
 * Created by Harris on 16/05/2017.
 */

public interface DisplayAlgorithmModel {
    String getTitleFromAlgorithmKey(String titleKey);

    ArrayList<Integer> getDefaultData();

    ArrayList<Integer> shuffleData(ArrayList<Integer> data);
}
