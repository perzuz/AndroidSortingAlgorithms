package kbb.sortingalgorithms.app.Views;

import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;

/**
 * Created by Harris on 16/05/2017.
 */

public interface DisplayAlgorithmView {
    void setPresenter(DisplayAlgorithmPresenter presenter);

    void setTitle(String title);
}
