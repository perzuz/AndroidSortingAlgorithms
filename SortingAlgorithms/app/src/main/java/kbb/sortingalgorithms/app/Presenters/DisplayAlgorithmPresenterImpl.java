package kbb.sortingalgorithms.app.Presenters;

import java.util.ArrayList;

import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModel;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmView;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmPresenterImpl implements DisplayAlgorithmPresenter {
    private final DisplayAlgorithmModel model;
    private final DisplayAlgorithmView view;

    public DisplayAlgorithmPresenterImpl(DisplayAlgorithmView view, DisplayAlgorithmModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onStart(String algorithmKey) {
        view.setTitle(model.getTitleFromAlgorithmKey(algorithmKey));
        view.setChartData(model.shuffleData(model.getDefaultData()));
    }

    @Override
    public void onSortButtonClicked() {
        try {
            ArrayList<ArrayList<Integer>> dataStream = model.sort(model.getDefaultData());

            for (ArrayList<Integer> data : dataStream){
                view.setChartData(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
