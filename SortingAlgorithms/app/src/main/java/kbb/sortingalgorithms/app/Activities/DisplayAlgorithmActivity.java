package kbb.sortingalgorithms.app.Activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModel;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModelImpl;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmFragment;
import kbb.sortingalgorithms.databinding.ActivityDisplayAlgorithmBinding;

/**
 * Created by Harris on 16/05/2017.
 */

public class DisplayAlgorithmActivity extends AppCompatActivity {
    ActivityDisplayAlgorithmBinding binding;

    DisplayAlgorithmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_algorithm);

        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl();

        DisplayAlgorithmFragment view = new DisplayAlgorithmFragment();

        presenter = new DisplayAlgorithmPresenterImpl(view, model);

        view.setPresenter(presenter);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), view).commit();
    }
}
