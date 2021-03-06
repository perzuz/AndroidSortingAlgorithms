package kbb.sortingalgorithms.app.Activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModel;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModelImpl;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmFragment;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmView;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmFragment;
import kbb.sortingalgorithms.databinding.ActivityMainBinding;

public class SelectAlgorithmActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    SelectAlgorithmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        SelectAlgorithmFragment view = new SelectAlgorithmFragment();

        presenter = new SelectAlgorithmPresenterImpl(view);

        view.setPresenter(presenter);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), view).commit();
    }

    public void startFragment(DisplayAlgorithmFragment fragment){

        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl();

        DisplayAlgorithmFragment view = fragment;

        DisplayAlgorithmPresenter displayPresenter = new DisplayAlgorithmPresenterImpl(view, model);

        view.setPresenter(displayPresenter);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), view).addToBackStack(view.getTag()).commit();
    }
}
