package kbb.sortingalgorithms.app.Presenters;

import kbb.sortingalgorithms.app.SelectAlgorithmPresenterContract;
import kbb.sortingalgorithms.app.SelectAlgorithmViewContract;

/**
 * Created by Harris on 15/05/2017.
 */

public class SelectAlgorithmPresenter implements SelectAlgorithmPresenterContract {
    private final SelectAlgorithmViewContract view;

    public SelectAlgorithmPresenter(SelectAlgorithmViewContract view){
        this.view = view;
    }

    @Override
    public void onBubbleSortAlgorithmButtonClicked() {
        view.openAlgorithmPageWithBubbleSort();
    }
}
