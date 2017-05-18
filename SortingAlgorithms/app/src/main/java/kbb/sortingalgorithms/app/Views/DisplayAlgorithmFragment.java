package kbb.sortingalgorithms.app.Views;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.databinding.FragmentDisplayAlgorithmBinding;

/**
 * Created by Harris on 16/05/2017.
 */

@SuppressLint("ValidFragment")
public class DisplayAlgorithmFragment extends android.support.v4.app.Fragment implements DisplayAlgorithmView{

    private FragmentDisplayAlgorithmBinding binding;

    private DisplayAlgorithmPresenter presenter;

    public DisplayAlgorithmFragment(String algorithmKey){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_algorithm, container, false);

        return binding.getRoot();
    }

    @Override
    public void setPresenter(DisplayAlgorithmPresenter presenter) {
        this.presenter = presenter;
    }
}
