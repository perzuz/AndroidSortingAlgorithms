package kbb.sortingalgorithms.app.Presenters;

import kbb.sortingalgorithms.app.Views.SelectAlgorithmView;

/**
 * Created by Harris on 15/05/2017.
 */

public class SelectAlgorithmPresenterImpl implements SelectAlgorithmPresenter {
    private final SelectAlgorithmView view;


    public SelectAlgorithmPresenterImpl(SelectAlgorithmView view){
        this.view = view;
    }

    @Override
    public void onBubbleSortAlgorithmButtonClicked() {
        view.showDisplayView("bubble_sort");
    }
}
