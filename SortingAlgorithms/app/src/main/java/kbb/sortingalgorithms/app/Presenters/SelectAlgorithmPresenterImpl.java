package kbb.sortingalgorithms.app.Presenters;

import kbb.sortingalgorithms.app.Models.SelectAlgorithmModel;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmView;

/**
 * Created by Harris on 15/05/2017.
 */

public class SelectAlgorithmPresenterImpl implements SelectAlgorithmPresenter {
    private final SelectAlgorithmView view;
    private final SelectAlgorithmModel model;

    public SelectAlgorithmPresenterImpl(SelectAlgorithmView view, SelectAlgorithmModel model){
        this.model = model;
        this.view = view;
    }

    @Override
    public void onBubbleSortAlgorithmButtonClicked() {
        model.getBubbleSortAlgorithm();
        view.openAlgorithmPageWithBubbleSort();
    }
}
