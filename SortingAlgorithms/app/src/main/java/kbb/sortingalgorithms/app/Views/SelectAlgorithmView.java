package kbb.sortingalgorithms.app.Views;

import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;

/**
 * Created by Harris on 15/05/2017.
 */

public interface SelectAlgorithmView {
    void openAlgorithmPageWithBubbleSort();
    void setPresenter(SelectAlgorithmPresenter presenter);
}
