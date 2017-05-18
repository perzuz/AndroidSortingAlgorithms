package kbb.sortingalgorithms.app.Presenters;

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
    public void onStart(String titleKey) {
        String title = model.getTitleFromAlgorithmKey(titleKey);
        view.setTitle(title);

    }
}
