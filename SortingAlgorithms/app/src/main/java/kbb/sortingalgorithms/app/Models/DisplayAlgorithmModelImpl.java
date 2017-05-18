package kbb.sortingalgorithms.app.Models;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmModelImpl implements DisplayAlgorithmModel {
    @Override
    public String getTitleFromAlgorithmKey(String titleKey) {
        return titleKey.replaceAll("_", " ");
    }
}
