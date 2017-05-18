package kbb.sortingalgorithms.app.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Activities.SelectAlgorithmActivity;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.databinding.FragmentSelectAlgorithmBinding;

/**
 * Created by Harris on 16/05/2017.
 */

public class SelectAlgorithmFragment extends android.support.v4.app.Fragment implements SelectAlgorithmView {

    private FragmentSelectAlgorithmBinding binding;

    private SelectAlgorithmPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_algorithm,container,false);

        binding.buttonBubbleSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBubbleSortAlgorithmButtonClicked();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void openAlgorithmPageWithBubbleSort() {
    }

    @Override
    public void setPresenter(SelectAlgorithmPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showDisplayView(String algorithmKey) {

        SelectAlgorithmActivity activity = (SelectAlgorithmActivity)getActivity();

        activity.startFragment(new DisplayAlgorithmFragment(algorithmKey));
    }
}
