package Presenters;

import kbb.sortingalgorithms.Contracts.SelectAlgorithmPresenterContract;
import kbb.sortingalgorithms.Contracts.SelectAlgorithmViewContract;

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
